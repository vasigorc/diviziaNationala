/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vgorcinschi.concordiafootballmanager.model.beans;

import com.vgorcinschi.concordiafootballmanager.customexceptions.*;
import com.vgorcinschi.concordiafootballmanager.model.*;
import com.vgorcinschi.concordiafootballmanager.model.validators.*;

/**
 *
 * @author vgorcinschi
 */
public class TransferMarket {
    
    private final PlayerFactory plF;
    private final TrainerFactory trF;
    private final SoccerDudesValidator sdv;
    private final TeamValidator tv;
    
    public TransferMarket(PlayerFactory plF, TrainerFactory trF, SoccerDudesValidator sdv, TeamValidator tv) {
        this.plF = plF;
        this.trF = trF;
        this.sdv = sdv;
        this.tv = tv;
    }
    
    public Player playerGenerator(String position, String firstName, String
            lastName, int age, String birthCountry, double salary) throws InvalidSoccerDudeException{
        
        Player player = plF.getPlayer(position);
        player.setAge(age);
        player.setFirstName(firstName);
        player.setLastName(lastName);
        player.setPureSalary(salary);
        player.setBirthCountry(birthCountry);
        if (!sdv.playerIsValid(player)) 
            throw new InvalidSoccerDudeException("Some of "+player.getLastName()+
                    "'s data was invalid");
        return player;
    }
    
    public Trainer trainerGenerator(String firstName, String lastName, int age,
            double salary) throws InvalidSoccerDudeException{
        Trainer trainer = trF.gettrainer();
        trainer.setAge(age);
        trainer.setFirstName(firstName);
        trainer.setLastName(lastName);
        trainer.setSalary(salary);        
        if (!sdv.trainerIsValid(trainer)) 
            throw new InvalidSoccerDudeException("Some of "+trainer.getLastName()+
                    "'s data was invalid");
        return trainer;
    }    
    
    /*
        will write implementation code later, make advised by an Aspect
        to withdraw this player from from team, should later be a bean
    */
    public boolean transferPlayer(Team from, Team to, Player player){
        return false;
    }
}
