package org.onetoone.controller;

import org.onetoone.dao.AadharCardDao;
import org.onetoone.dao.PersonDao;
import org.onetoone.dto.AadharCard;
import org.onetoone.dto.Person;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PersonAadhaarController
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter The Choice:");
        System.out.println("1.Add The Person Only");
        System.out.println("2.Add The Person Details With Aadhaar Card");
        System.out.println("3.Add The Aadhaar Card Details Of Person ");
        System.out.println("4.Update The Person Details");
        int ch=Integer.parseInt(bufferedReader.readLine());
        switch (ch)
        {
            case 1:
            {
                System.out.println("Enter Person Name");
                String name=bufferedReader.readLine();
                System.out.println("Enter Person Id");
                int id= Integer.parseInt(bufferedReader.readLine());
                System.out.println("Enter Person Address");
                String address=bufferedReader.readLine();
                Person person=new Person();
                person.setName(name);
                person.setId(id);
                person.setAddress(address);
                PersonDao personDao=new PersonDao();
                personDao.savePerson(person);
            }
            break;
            case 2:
            {
                System.out.println("Enter Person Name");
                String name=bufferedReader.readLine();
                System.out.println("Enter Person Id");
                int id= Integer.parseInt(bufferedReader.readLine());
                System.out.println("Enter Person Address");
                String address=bufferedReader.readLine();
                System.out.println("For Aadhaar Card");
                System.out.println("Enter Name");
                String  aadhaarName=bufferedReader.readLine();
                System.out.println("Aadhaar Card Id");
                int aadhaarId=Integer.parseInt(bufferedReader.readLine());
                System.out.println("Aadhaar Card Age ");
                int age=Integer.parseInt(bufferedReader.readLine());
                Person person=new Person();
                person.setName(name);
                person.setId(id);
                person.setAddress(address);
                PersonDao personDao=new PersonDao();
                personDao.savePerson(person);
                AadharCard aadharCard=new AadharCard();
                aadharCard.setId(aadhaarId);
                aadharCard.setAge(age);
                aadharCard.setName(aadhaarName);
                AadharCardDao aadharCardDao=new AadharCardDao();
                aadharCardDao.saveAadharCard(id,aadharCard);
            }
            break;
            case 3:
            {
                System.out.println("Enter Your Person Id");
                int id=Integer.parseInt(bufferedReader.readLine());
                System.out.println("For Aadhaar Card");
                System.out.println("Enter Name");
                String  aadhaarName=bufferedReader.readLine();
                System.out.println("Aadhaar Card Id");
                int aadhaarId=Integer.parseInt(bufferedReader.readLine());
                System.out.println("Aadhaar Card Age ");
                int age=Integer.parseInt(bufferedReader.readLine());
                AadharCard aadharCard=new AadharCard();
                aadharCard.setId(aadhaarId);
                aadharCard.setAge(age);
                aadharCard.setName(aadhaarName);
                AadharCardDao aadharCardDao=new AadharCardDao();
                aadharCardDao.saveAadharCard(id,aadharCard);
            }
            break;
            case 4:
            {
                System.out.println("Enter Id Of The Person to be Updated");
                int id=Integer.parseInt(bufferedReader.readLine());
                System.out.println("Enter Which detail you want to update:");
                System.out.println("1.Name Of Person");
                System.out.println("2.Address Of Person");
                int choice=Integer.parseInt(bufferedReader.readLine());
                switch (choice)
                {
                    case 1:
                    {
                        System.out.println("Enter Name of the Person to be Updated");
                        String newName=bufferedReader.readLine();
                        Person person=new Person();
                        person.setName(newName);
                        PersonDao personDao=new PersonDao();
                        personDao.updatePerson(id,person);
                    }
                    break;
                    case 2:
                    {
                        System.out.println("Enter New Address Of the Person To be Updated");
                        String newAddress=bufferedReader.readLine();
                        Person person=new Person();
                        person.setAddress(newAddress);
                        PersonDao personDao=new PersonDao();
                        personDao.updatePerson(id,person);
                    }
                    break;
                    default:
                        System.out.println("Enter Valid Choice");
                }
            }
            break;
        }
    }
}
