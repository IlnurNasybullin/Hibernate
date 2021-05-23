package app.server.controller;

import app.server.domain.Account;
import app.server.domain.Transaction;
import app.server.domain.UserAgent;
import app.server.repository.AccountRepository;
import app.server.service.TransactionJPAService;
import app.server.util.TransactionData;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManager;
import java.util.Optional;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private final AccountRepository repository;
    private final TransactionJPAService service;
    private final EntityManager entityManager;

    public TransactionController(AccountRepository repository, TransactionJPAService service, EntityManager entityManager) {
        this.repository = repository;
        this.service = service;
        this.entityManager = entityManager;
    }

    @PostMapping
    @ResponseBody
    public Transaction commit(@RequestBody TransactionData transactionData) {
        transactionData.getFromId();
        Optional<Account> optionalFrom = repository.findById(transactionData.getFromId());
        if (optionalFrom.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        Account from = optionalFrom.get();

        Double transactionSum = transactionData.getTransactionSum();
        if (transactionSum > from.getBalance()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Balance is less than transaction sum!", null);
        }

        Optional<Account> optionalTo = repository.findById(transactionData.getToId());
        if (optionalTo.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        UserAgent userAgent = entityManager.find(UserAgent.class, transactionData.getUserAgentId());
        Transaction transaction = toTransaction(from, optionalTo.get(), userAgent, transactionSum);
        return service.commit(transaction);
    }

    private Transaction toTransaction(Account from, Account to, UserAgent userAgent, Double transactionSum) {
        Transaction transaction = new Transaction();
        transaction.setTransactionSum(transactionSum);
        transaction.setFrom(from);
        transaction.setTo(to);
        transaction.setResponsibleAgent(userAgent);

        return transaction;
    }


}
