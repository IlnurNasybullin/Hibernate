package app.server.service;

import app.server.domain.Account;
import app.server.domain.Transaction;
import app.server.repository.AccountRepository;
import app.server.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
public class TransactionJPAService {

    private final TransactionRepository repository;
    private final AccountRepository accountRepository;

    public TransactionJPAService(TransactionRepository repository, AccountRepository accountRepository) {
        this.repository = repository;
        this.accountRepository = accountRepository;
    }

    @Transactional
    public Transaction commit(Transaction transaction) {
        Double transactionSum = transaction.getTransactionSum();
        Account from = transaction.getFrom();
        from.setBalance(from.getBalance() - transactionSum);

        Account to = transaction.getTo();
        to.setBalance(to.getBalance() + transactionSum);

        accountRepository.saveAndFlush(from);
        accountRepository.saveAndFlush(to);

        transaction.setDateTime(LocalDateTime.now());
        return repository.save(transaction);
    }

}
