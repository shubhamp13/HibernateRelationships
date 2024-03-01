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
        System.out.println("5.Update Aadhaar Details");
        System.out.println("6.Display Person details");
        int ch=Integer.parseInt(bufferedReader.readLine());
        Person person=new Person();
        PersonDao personDao=new PersonDao();
        AadharCardDao aadharCardDao=new AadharCardDao();
        AadharCard aadharCard=new AadharCard();
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
                person.setName(name);
                person.setId(id);
                person.setAddress(address);
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
                person.setName(name);
                person.setId(id);
                person.setAddress(address);
                personDao.savePerson(person);
                aadharCard.setId(aadhaarId);
                aadharCard.setAge(age);
                aadharCard.setName(aadhaarName);
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
                aadharCard.setId(aadhaarId);
                aadharCard.setAge(age);
                aadharCard.setName(aadhaarName);
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
                        person.setName(newName);
                        personDao.updatePerson(id,person);
                    }
                    break;
                    case 2:
                    {
                        System.out.println("Enter New Address Of the Person To be Updated");
                        String newAddress=bufferedReader.readLine();
                        person.setAddress(newAddress);
                        personDao.updatePerson(id,person);
                    }
                    break;
                    default:
                        System.out.println("Enter Valid Choice");
                }
            }
            break;
            case 5:
            {
                System.out.println("Enter Aadhaar Id Number");
                int aadhaarId=Integer.parseInt(bufferedReader.readLine());
                System.out.println("Enter What do you want to update");
                System.out.println("1.Name On aadhaar card");
                System.out.println("2.age of Aadhaar card");
                int choice =Integer.parseInt(bufferedReader.readLine());
                switch (choice)
                {
                    case 1:
                    {
                        System.out.println("Enter New Name To be Updated");
                        String newName=bufferedReader.readLine();
                        aadharCard.setName(newName);
                        aadharCardDao.updateAadharCard(aadhaarId,aadharCard);
                    }
                    break;
                    case 2:
                    {
                        System.out.println("Enter New age To be Updated");
                        int newAge=Integer.parseInt(bufferedReader.readLine());
                        aadharCard.setAge(newAge);
                        aadharCardDao.updateAadharCard(aadhaarId,aadharCard);
                    }
                    break;
                }

            }
            break;
            case 6:
            {
                System.out.println("Enter Id of Person To Be Deleted");
                int id=Integer.parseInt(bufferedReader.readLine());
                personDao.deletePerson(id);
            }
            break;
            case 7:
            {
                System.out.println("Enter id of aadhaar to be deleted");
                int id=Integer.parseInt(bufferedReader.readLine());
                personDao.displayAll(id);
            }
            break;

        }
    }
}
