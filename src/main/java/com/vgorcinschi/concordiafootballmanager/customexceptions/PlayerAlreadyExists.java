/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vgorcinschi.concordiafootballmanager.customexceptions;

import java.io.IOException;

/**
 *
 * @author vgorcinschi
 */
public class PlayerAlreadyExists extends IOException{

    public PlayerAlreadyExists() {
    }
    
    public PlayerAlreadyExists(String message) {
        super(message);
    }
}
