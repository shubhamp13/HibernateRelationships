package org.onetoone.dao;

import org.onetoone.dto.AadharCard;
import org.onetoone.dto.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AadharCardDao
{
    EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("persistence");
    EntityManager entityManager=entityManagerFactory.createEntityManager();

    public  void saveAadharCard(int personId,AadharCard aadharCard)
    {

        Person dbPerson=entityManager.find(Person.class,personId);
        if(dbPerson!=null)
        {
            entityManager.getTransaction().begin();
            entityManager.persist(aadharCard);
            dbPerson.setAadhar(aadharCard);
            entityManager.getTransaction().commit();
        }
        else
        {
            System.out.println("Invalid Details");
        }

    }
}
