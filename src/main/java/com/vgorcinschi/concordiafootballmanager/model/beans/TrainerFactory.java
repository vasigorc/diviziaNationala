/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vgorcinschi.concordiafootballmanager.model.beans;

import com.vgorcinschi.concordiafootballmanager.model.Trainer;
/**
 *
 * @author vgorcinschi
 */
public class TrainerFactory {
    
    public TrainerFactory(){}
    
    public Trainer gettrainer(){
        return new Trainer();
    }
}
