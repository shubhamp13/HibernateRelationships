package org.onetoone.dao;

import org.onetoone.dto.AadharCard;
import org.onetoone.dto.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersonDao
{
    EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("persistence");
    EntityManager entityManager=entityManagerFactory.createEntityManager();
    public  void savePerson(Person person)
    {
        entityManager.getTransaction().begin();
        entityManager.persist(person);
        entityManager.getTransaction().commit();
    }
    public  void updatePerson(int id,Person person)
    {
        Person dbPerson =entityManager.find(Person.class,id);
        if(dbPerson!=null)
        {
            entityManager.getTransaction().begin();
            person.setAadhar(dbPerson.getAadhar());
            entityManager.merge(person);
            entityManager.getTransaction().commit();
        }
        else
        {
            System.out.println("invalid details");
        }
    }
    public  void findPerson(int id)
    {
        Person dbPerson= entityManager.find(Person.class,id);
        if(dbPerson!=null)
        {
            System.out.println(dbPerson);
        }
        else
        {
            System.out.println("Not Present");
        }
    }
    public  void  deletePerson(int id)
    {
        Person dbPerson=entityManager.find(Person.class,id);

        if(dbPerson!=null)
        {
            AadharCard dbaadharCard=entityManager.find(AadharCard.class,dbPerson.getAadhar().getId());
            entityManager.getTransaction().begin();;
            entityManager.remove(dbPerson);
            entityManager.remove(dbaadharCard);
            entityManager.getTransaction().commit();
        }
        else
        {
            System.out.println("Given Person Is Not Present In The Database");
        }
    }

}
