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
class Experience {
    private int yearFrom;
    private int yearTo;
    private Team team;

    public Experience(int yearFrom, int yearTo, Team t) {
        this.yearFrom = yearFrom;
        this.yearTo = yearTo;
        this.team = t;
    }

    public int getYearFrom() {
        return yearFrom;
    }

    public int getYearTo() {
        return yearTo;
    }

    public Team getTeam() {
        return team;
    }

    public void setYearFrom(int yearFrom) {
        this.yearFrom = yearFrom;
    }

    public void setYearTo(int yearTo) {
        this.yearTo = yearTo;
    }

    public void setTeam(Team team) {
        this.team = team;
    }   
}
