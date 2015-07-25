/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vgorcinschi.concordiafootballmanager.model;

/**
 *
 * @author vgorcinschi
 */
public class Statistic {
    private int games, goals;

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
