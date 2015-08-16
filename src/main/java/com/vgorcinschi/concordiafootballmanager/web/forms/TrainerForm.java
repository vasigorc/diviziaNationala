/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vgorcinschi.concordiafootballmanager.web.forms;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author vgorcinschi
 */
public class TrainerForm {
    @NotNull
    @Size(min=2, max=20, message="{firstname.size}")
    private String firstName;
    
    @NotNull
    @Size(min=2, max=20, message="{lastname.size}")
    private String lastName;
    
    @Digits(integer=2, fraction=0, message = "{trainer.age.format}")
    @Max(value=80, message = "{trainer.age.format}")
    @Min(value=40, message = "{trainer.age.format}")
    private int age;
    
    @Digits(integer=7, fraction = 2, message="{salary.format}")
    @Max(value=9000000, message = "{salary.format}")
    private double salary;

    public TrainerForm() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    
}
