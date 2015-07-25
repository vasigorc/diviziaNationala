/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vgorcinschi.concordiafootballmanager.customexceptions;

/**
 *
 * @author vgorcinschi
 */
public class InvalidPositionException extends IllegalArgumentException {
    public InvalidPositionException(){};
    
    public InvalidPositionException(String message){
        super(message);
    };
}
