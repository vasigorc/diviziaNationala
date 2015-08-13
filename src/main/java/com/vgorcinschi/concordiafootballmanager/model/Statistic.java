/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vgorcinschi.concordiafootballmanager.model;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 *
 * @author vgorcinschi
 */
public class Statistic {
    @Digits(integer=4, fraction=0, message = "{stats.games}")
    @Max(value=9999, message = "{stats.games}")
    @Min(value=0, message = "{stats.games}")
    private int games; 
    
    @Digits(integer=4, fraction=0, message = "{stats.goals}")
    @Max(value=9999, message = "{stats.goals}")
    @Min(value=0, message = "{stats.goals}")
    private int goals;

    public Statistic() {
        this.games = 0;
        this.goals = 0;
    }

    public Statistic(int games, int goals) {
        this.games = games;
        this.goals = goals;
    }

    public int getGames() {
        return games;
    }

    public void setGames(int games) {
        this.games = games;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }
    
    public void addGame(){
        this.games++;
    }
    
    public void addGoals(int newGoals){
        this.goals+=newGoals;        
    }
}
