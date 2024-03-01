package org.onetoone.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AadharCard
{
    @Id
    private int id;
    private String name;
    private  int age;

    @Override
    public String toString() {
        return "\n{" +
                "Aadhaar id=" + id +
                ", Aadhaar name='" + name + '\'' +
                ", Aadhaar age=" + age +
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}