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
    public  void updateAadharCard(int id,AadharCard aadharCard)
    {
        AadharCard dbAadharCard=entityManager.find(AadharCard.class,id);

        if(dbAadharCard!=null)
        {
            if(aadharCard.getName()==null)
            {
                aadharCard.setName(dbAadharCard.getName());
            }
            if(aadharCard.getAge()==0)
            {
                aadharCard.setAge(dbAadharCard.getAge());
            }
            entityManager.getTransaction().begin();
            aadharCard.setId(dbAadharCard.getId());
            entityManager.merge(aadharCard);
            entityManager.getTransaction().commit();
        }
        else
        {
            System.out.println("invalid id details");
        }
    }
    public  void deleteAadhaar(int id)
    {
        AadharCard dbAadharCard=entityManager.find(AadharCard.class,id);
        if(dbAadharCard!=null)
        {
            Person dbPerson=entityManager.find(Person.class,dbAadharCard.getId());
            dbPerson.setAadhar(null);
            entityManager.getTransaction().begin();
            entityManager.remove(dbAadharCard);
            entityManager.getTransaction().commit();
        }
        else
        {
            System.out.println("Not Found");
        }
    }
}
