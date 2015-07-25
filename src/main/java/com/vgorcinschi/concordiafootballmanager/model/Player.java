/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vgorcinschi.concordiafootballmanager.model;

import com.vgorcinschi.concordiafootballmanager.customexceptions.InvalidPositionException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author vgorcinschi
 */
public abstract class Player implements Person {

    protected String firstName, lastName;
    protected int age;
    protected double salary;
    protected String position;
    protected final Set<String> validPositions = new HashSet<>(Arrays.asList("Goalk"
            + "eeper", "Defender", "Midfielder", "Forward"));
    protected Statistic stats;
    protected String birthCountry;
    private List<Experience> experience;

    protected Player() {
        this.stats = new Statistic();
        this.experience = new ArrayList<>();
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getSalary() {
        return euroFormatter.format(salary);
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

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void playedGame() {
        this.stats.addGame();
    }

    public void scoredGoals(int howMany) {
        this.stats.addGoals(howMany);
        /*TODO write an aspect catching name of player and no of goals
         if 3, cry "hattrick by .." if 4, "pocker" 
         */
    }

    public void setPosition(String position) {
        for (String pos : validPositions) {
            if (pos.equalsIgnoreCase(position)) {
                this.position = position;
                return;
            }
        }
        throw new InvalidPositionException(position+" is not a valid position"
                + " for a football player in this application.");
    }

    public String getPosition() {
        return position;
    }

    public String getBirthCountry() {
        return birthCountry;
    }
    
    public Team currentTeam() {
        return experience.get(experience.size() - 1).getTeam();
    }

    public void addTeam(int yearFrom, int yearTo, Team t) {
        experience.add(new Experience(yearFrom, yearTo, t));
    }

    public Statistic getStats() {
        return stats;
    }

    public List<Experience> getAllTeams() {
        return experience;
    }

    public void setBirthCountry(String birthCountry) {
        this.birthCountry = birthCountry;
    }  

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Player other = (Player) obj;
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (this.age != other.age) {
            return false;
        }
        if (!Objects.equals(this.position, other.position)) {
            return false;
        }        
        if (!Objects.equals(this.birthCountry, other.birthCountry)) {
            return false;
        }
        return true;
    }
    
    
}
