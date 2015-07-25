/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vgorcinschi.concordiafootballmanager.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vgorcinschi
 */
public class Trainer implements Person {

    private String firstName, lastName;
    private int age;
    private double salary;
    private List<Experience> experience;

    public Trainer() {
        this.experience = new ArrayList<>();
    }

    public Trainer(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.experience = new ArrayList<>();
    }

    public Trainer(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
        this.experience = new ArrayList<>();
    }
    

    public Trainer(String firstName, String lastName, int age, double salary, List<Experience> experience) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
        this.experience = experience;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    public Team currentTeam() {
        return experience.get(experience.size() - 1).getTeam();
    }

    public void addTeam(int yearFrom, int yearTo, Team t) {
        experience.add(new Experience(yearFrom, yearTo, t));
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public String getSalary() {
        return euroFormatter.format(salary);
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
}
