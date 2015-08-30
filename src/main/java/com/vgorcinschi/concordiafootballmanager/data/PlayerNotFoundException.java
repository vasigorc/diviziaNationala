/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vgorcinschi.concordiafootballmanager.data;

/**
 *
 * @author vgorcinschi
 */
public class PlayerNotFoundException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;
    private String lastName;

    public PlayerNotFoundException(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }    
}
