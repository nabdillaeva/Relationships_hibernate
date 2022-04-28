package org.example.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.configuration.DatabaseConnection;
import org.example.models.Country;

import java.util.List;


public class CountryRepository implements AutoCloseable{

    private EntityManagerFactory entityManagerFactory = DatabaseConnection.createEntityManagerFactory();

    public void save(Country newCountry){
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(newCountry);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public void update(Country newCountry){
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.merge(newCountry);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Country> findAll(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        List<Country> country = entityManager.createQuery("select c from Country c ", Country.class).getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();

        return country;
    }
    public Country findById(long id){
        EntityManager entityManager =entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Country country = entityManager.createQuery("select c from Country c where c.id=:id", Country.class)
                .setParameter("id", id)
                        .getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();

        return country;
    }

    public void deleteById(long id){
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.createQuery(" delete from Country c where c.id= :id")
                .setParameter("id",id)
                        .executeUpdate();
       // entityManager.remove(entityManager.find(Country.class,id));

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void close() throws Exception {
        entityManagerFactory.close();
    }
}
