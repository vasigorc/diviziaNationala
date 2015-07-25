/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vgorcinschi.concordiafootballmanager.model.players;

import com.vgorcinschi.concordiafootballmanager.model.Player;

/**
 *
 * @author vgorcinschi
 */
public class Forward extends Player {
    
    
    public Forward(){
        super();
        this.position = "Forward";
    }
    
    public Forward(String firstName, String lastName, int age, double salary,
            String birthCountry){
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
        this.birthCountry = birthCountry;
        this.position = "Forward";
    }
}
