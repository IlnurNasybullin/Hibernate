package app.testDB;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DBWork {

    private static EntityManagerFactory emf;
    private static volatile DBWork db = null;
    private final Map<Long, EntityManager> mapEntityManager = new ConcurrentHashMap<>();

    private DBWork() {}

    public static DBWork getInstance() {
        DBWork localInstance = db;
        if (localInstance == null) {
            synchronized (DBWork.class) {
                localInstance = db;
                if (localInstance == null) {
                    emf = getEmfFactory();
                    db = localInstance = new DBWork();
                }
            }
        }

        return localInstance;
    }

    private static EntityManagerFactory getEmfFactory() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("lab16");
        }

        return emf;
    }

    public static void clear() {
        db.closeAllEntityManagers();
        emf.close();
        emf = null;
        db = null;
    }

    private void closeAllEntityManagers() {
        synchronized (mapEntityManager) {
            for (EntityManager tmp: mapEntityManager.values()) {
                if (tmp != null && tmp.isOpen()) {
                    tmp.close();
                }
            }

            mapEntityManager.clear();
        }
    }

    public void closeEntityManager() {
        Long key = Thread.currentThread().getId();
        EntityManager tmp = mapEntityManager.get(key);
        if (tmp != null) {
            if (tmp.isOpen()) {
                tmp.close();
            }
        }
        mapEntityManager.remove(key);
        tmp = null;
    }

    public EntityManager getEntityManager() {
        Long key = Thread.currentThread().getId();
        if (!mapEntityManager.containsKey(key)) {
            EntityManager tmp = emf.createEntityManager();
            mapEntityManager.put(key, tmp);
        }

        return mapEntityManager.get(key);
    }

    public void startTransaction() {
        EntityTransaction transaction = getEntityManager().getTransaction();
        if (!transaction.isActive()) {
            transaction.begin();
        }
    }

    public void endTransaction(boolean commit) {
        try {
            EntityTransaction transaction = getEntityManager().getTransaction();
            if (transaction.isActive()) {
                if (commit) {
                    transaction.commit();
                } else {
                    transaction.rollback();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
