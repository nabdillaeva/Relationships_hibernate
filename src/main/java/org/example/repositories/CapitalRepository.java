package org.example.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.configuration.DatabaseConnection;
import org.example.models.Capital;

import java.util.List;

public class CapitalRepository implements AutoCloseable{


    private EntityManagerFactory entityManagerFactory = DatabaseConnection.createEntityManagerFactory();

    public void save(Capital newCapital){

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(newCapital);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public void update(Capital newCapital){

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.merge(newCapital);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Capital> findAll(){
        EntityManager entityManager =entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        List<Capital> capitals = entityManager.createQuery("select c from Capital c", Capital.class).getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();

        return capitals;
    }

    public Capital findById(long id){
        EntityManager entityManager =entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Capital capital = entityManager.createQuery("select c from Capital c where c.id = :id", Capital.class)
                .setParameter("id", id)
                .getSingleResult();

        entityManager.getTransaction().commit();
        entityManager.close();

        return capital;
    }

    @Override
    public void close() throws Exception {
        entityManagerFactory.close();
    }
}
