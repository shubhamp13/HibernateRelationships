package org.onetoone.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Person
{
    @Id
    private  int id;
    private String name;
    private  String address;
    @OneToOne
    private AadharCard aadharCard;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", aadhar=" + aadharCard +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public AadharCard getAadhar() {
        return aadharCard;
    }

    public void setAadhar(AadharCard aadharCard) {
        this.aadharCard = aadharCard;
    }
}
