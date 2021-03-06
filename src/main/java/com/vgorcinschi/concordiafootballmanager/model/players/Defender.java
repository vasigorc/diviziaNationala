/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vgorcinschi.concordiafootballmanager.model.players;

import com.vgorcinschi.concordiafootballmanager.model.Player;
import javax.persistence.Entity;

/**
 *
 * @author vgorcinschi
 */
@Entity
@SuppressWarnings("PersistenceUnitPresent")
public class Defender extends Player {

    public Defender() {
        super();
        this.position = "Defender";
    }

    public Defender(String firstName, String lastName, int age, double salary,
            String birthCountry) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
        this.birthCountry = birthCountry;
        this.position = "Defender";
    }
}
