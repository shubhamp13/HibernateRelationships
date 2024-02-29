package org.onetoone.controller;

import org.onetoone.dao.AadharCardDao;
import org.onetoone.dao.PersonDao;
import org.onetoone.dto.AadharCard;
import org.onetoone.dto.Person;

public class PersonAadharController
{
    public static void main(String[] args)
    {
//        Person person=new Person();
//        person.setId(1);
//        person.setName("Shubham Puri");
//        person.setAddress("Pune");
//
//        PersonDao personDao=new PersonDao();
//        personDao.savePerson(person);

//        AadharCard aadharCard=new AadharCard();
//        aadharCard.setAge(24);
//        aadharCard.setName("Shubham  Puri");
//        aadharCard.setId(13);
//        AadharCardDao aadharCardDao=new AadharCardDao();
////        aadharCardDao.saveAadharCard(1,aadharCard);
//        aadharCardDao.updateAadharCard(13,aadharCard);
        Person person =new Person();
        person.setId(1);
        person.setName("Shubham Pandit Puri");
        person.setAddress("Pune");
        PersonDao personDao=new PersonDao();
        personDao.deletePerson(11);
//        personDao.findPerson(1);
//        personDao.updatePerson(1,person);
    }
}
