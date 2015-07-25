/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vgorcinschi.concordiafootballmanager.model.beans;

import com.vgorcinschi.concordiafootballmanager.customexceptions.InvalidPositionException;
import com.vgorcinschi.concordiafootballmanager.model.Player;
import com.vgorcinschi.concordiafootballmanager.model.players.*;

/**
 *
 * @author vgorcinschi
 */
public class PlayerFactory {
    
    public PlayerFactory(){}
    
    public Player getPlayer(String position){
        String requestedPosition = position;
        switch (requestedPosition.toLowerCase()) {
            case "goalkeeper":
                return new Goalkeeper();
            case "defender":
                return new Defender();
            case "midfielder":
                return new Midfielder();
            case "forward":
                return new Forward();
            default:
                throw new InvalidPositionException(position+" is not a valid position"
                + " for a football player in this application.");
        }
    }
}
