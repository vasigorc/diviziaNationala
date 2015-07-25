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
public class TeamSizeException extends IOException{

    public TeamSizeException() {
    }

    public TeamSizeException(String message) {
        super(message);
    }
    
}
