package app.example;

import app.example.domain.Client;

import javax.persistence.EntityManager;

public class Task2 implements Runnable {

    @Override
    public void run() {
        DbWork db = DbWork.getInstance();

        EntityManager entityManager = db.getEmManager();
        entityManager.getTransaction().begin();

        Client client = entityManager.find(Client.class, 2L);
        System.out.println(Thread.currentThread().getId() + ", version = " +
                client.getVersion() + ", em " + entityManager.hashCode());
        client.setName("Client 1 task 2");

        entityManager.getTransaction().commit();
        db.closeEntityManager();

        System.out.println("Done (task2)");
    }

}
