/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vgorcinschi.concordiafootballmanager.web.forms;

import com.vgorcinschi.concordiafootballmanager.model.Experience;
import com.vgorcinschi.concordiafootballmanager.model.Statistic;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;

/**
 *
 * @author vgorcinschi
 */
public class PlayerForm {

    @NotNull
    @Size(min=2, max=20, message="{firstname.size}")
    private String firstName;
    
    @NotNull
    @Size(min=2, max=20, message="{lastname.size}")
    private String lastName;
    
    @Digits(integer=2, fraction=0, message = "{player.age.format}")
    @Max(value=37, message = "{player.age.format}")
    @Min(value=17, message = "{player.age.format}")
    private int age;
    
    @Digits(integer=7, fraction = 2, message="{salary.format}")
    @Max(value=9000000, message = "{salary.format}")
    private double salary;    
    
    private String position;
    private final List<String> validPositions;
//            = new ArrayList<>(Arrays.asList("Goalk"
//            + "eeper", "Defender", "Midfielder", "Forward"));
    private Statistic stats;
    private String birthCountry;
    private List<Experience> experience;

    public PlayerForm() {
        this.stats = new Statistic(0, 0);
        this.validPositions = new ArrayList<>();
        this.validPositions.add("Goalkeeper");
        this.validPositions.add("Defender");
        this.validPositions.add("Midfielder");
        this.validPositions.add("Forward");        
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Statistic getStats() {
        return stats;
    }

    public void setStats(Statistic stats) {
        this.stats = stats;
    }

    public String getBirthCountry() {
        return birthCountry;
    }

    public void setBirthCountry(String birthCountry) {
        this.birthCountry = birthCountry;
    }

    public List<Experience> getExperience() {
        return experience;
    }

    public void setExperience(List<Experience> experience) {
        this.experience = experience;
    }

    public List<String> getValidPositions() {
        return validPositions;
    }

    
}
