/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vgorcinschi.concordiafootballmanager.model.beans;

import com.vgorcinschi.concordiafootballmanager.customexceptions.InvalidTeamException;
import com.vgorcinschi.concordiafootballmanager.model.Player;
import com.vgorcinschi.concordiafootballmanager.model.Team;
import com.vgorcinschi.concordiafootballmanager.model.Trainer;
import com.vgorcinschi.concordiafootballmanager.model.validators.TeamValidator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author vgorcinschi
 */
public class TeamFactory {

    @Autowired
    TransferMarket tM;
    
    @Autowired
    TeamValidator tValid;

    public TeamFactory(TransferMarket tM, TeamValidator tv) {
        this.tM = tM;
        this.tValid = tv;
    }
    
    public Team getTeam(String name, int foundationYear) throws InvalidTeamException{
        Team tempTeam = new Team(name, foundationYear);
        if(!tValid.isValid(tempTeam))
            throw new InvalidTeamException();
        return tempTeam;
    }
    
    public Team getTeam(List<Player> players, Trainer tr, String name, int foundationYear) throws InvalidTeamException{
        Team tempTeam = new Team(players,tr, name, foundationYear);
        if(!tValid.isValid(tempTeam))
            throw new InvalidTeamException();
        for (Player player:players) {
            player.addTeam(2015, 2016, tempTeam);
        }
        tr.addTeam(2015, 2016, tempTeam);
        return tempTeam;
    }
}
