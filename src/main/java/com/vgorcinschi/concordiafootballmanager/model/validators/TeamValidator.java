/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vgorcinschi.concordiafootballmanager.model.validators;

import com.vgorcinschi.concordiafootballmanager.model.Team;

/**
 *
 * @author vgorcinschi
 */
public class TeamValidator {

    private Team team = null;
    public TeamValidator() {
    }
    
    private boolean yearIsGood(){
        return team.getFoundationYear()>=1950 && team.getFoundationYear()<=2015;
    }
    
    private boolean hasMinimalSquad(){
        return team.getPlayers().size()>=11;
    }
    
    public boolean isValid(Team tm){
        this.team = tm;
        return (team!=null && yearIsGood()&& team.getName()!=null
                && team.getName().length()>0 && hasMinimalSquad());        
    }    
}
