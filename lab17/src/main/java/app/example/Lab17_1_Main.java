package app.example;

import app.example.domain.Client;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class Lab17_1_Main {

    public static void main(String[] args) {
        DbWork db = DbWork.getInstance();

        EntityManager entityManager = db.getEmManager();
        entityManager.getTransaction().begin();

        Client client = entityManager.find(Client.class, 2L);
        System.out.println(Thread.currentThread().getId() + ", version = "
                + client.getVersion() + ", em " + entityManager.hashCode());

        long v1 = client.getVersion();

        Thread thread2 = new Thread(new Task2());
        thread2.start();

        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Query query = entityManager.createQuery("select c.version from Client c where c.id = :id");
        query.setParameter("id", 2L);


        client.setName("Client 1 task 1");

        Long v2 = (Long) query.getSingleResult();
        System.out.println("v2 = " + v2);
        try {
            //commit only version is required!
            if (v1==v2)
                entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        db.closeEntityManager();

        DbWork.clear();
    }
}
