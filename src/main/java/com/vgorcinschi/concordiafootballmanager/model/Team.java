/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vgorcinschi.concordiafootballmanager.model;

import com.vgorcinschi.concordiafootballmanager.customexceptions.PlayerAlreadyExists;
import com.vgorcinschi.concordiafootballmanager.customexceptions.TeamSizeException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vgorcinschi
 */
public class Team {

    private List<Player> players;
    private Trainer tr;
    private String name;
    private int foundationYear;

    public Team(String name, int foundationYear) {
        this.name = name;
        this.foundationYear = foundationYear;
        this.players = new ArrayList<>();
    }

    public Team(List<Player> players, Trainer tr, String name, int foundationYear) {
        this.players = players;
        this.tr = tr;
        this.name = name;
        this.foundationYear = foundationYear;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Trainer getTr() {
        return tr;
    }

    public void setTr(Trainer tr) {
        this.tr = tr;
    }

    @Override
    public String toString() {
        return name;
    }

    public void addPlayer(Player newBie) throws PlayerAlreadyExists, TeamSizeException {
        if (players.isEmpty()) {
            players.add(newBie);
            return;
        }
        if(players.size()>22)
            throw new TeamSizeException("Too many players in "+name);
        for (Player player : players) {
            if (player.equals(newBie)) {                
                throw new PlayerAlreadyExists(newBie.getFirstName()+" "+
                        newBie.getLastName()+" already plays for "+
                        this.name);
            }
        }
        players.add(newBie);
    }

    public void letgoPlayer(Player toPart) throws TeamSizeException {
        if (players.isEmpty()) {
            throw new TeamSizeException(toPart.firstName+" "
                    +toPart.lastName+" does not play for ".concat(name));
        }
        for (Player player : players) {
            if (player.equals(toPart)) {
                players.remove(player);
                return;
            }
        }
    }

    public void letgoTrainer() {
        this.tr = null;
    }

    public String getName() {
        return name;
    }

    public int getFoundationYear() {
        return foundationYear;
    }
    
    
}
