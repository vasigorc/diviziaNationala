/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vgorcinschi.concordiafootballmanager.model.beans;

import com.vgorcinschi.concordiafootballmanager.contextconfig.RootConfig;
import com.vgorcinschi.concordiafootballmanager.customexceptions.InvalidSoccerDudeException;
import com.vgorcinschi.concordiafootballmanager.customexceptions.InvalidTeamException;
import com.vgorcinschi.concordiafootballmanager.customexceptions.PlayerAlreadyExists;
import com.vgorcinschi.concordiafootballmanager.customexceptions.TeamSizeException;
import com.vgorcinschi.concordiafootballmanager.model.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author vgorcinschi
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
public class TransferMarketTest {

    Player igorAndronic;
    Team teamSperanta;
    @Autowired
    TransferMarket tM;

    @Autowired
    TrainerFactory trF;

    @Autowired
    PlayerFactory plF;
      
    @Autowired
    TeamFactory tF;

    @Before
    public void setUp() throws PlayerAlreadyExists {
        try {
            teamSperanta = tF.getTeam("Speranta Nisporeni", 1992);
        } catch (InvalidTeamException ex) {
            Logger.getLogger(TransferMarketTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            igorAndronic = tM.playerGenerator("Defender", "Igor", "Andronic", 27, "Moldova", 2300);
        } catch (InvalidSoccerDudeException ex) {
            System.out.println(ex.getMessage());
        }
        igorAndronic.addTeam(2015, 2016, teamSperanta);
        try {
            teamSperanta.addPlayer(igorAndronic);
        } catch (TeamSizeException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void playerFactorySThere() {
        assertNotNull(plF);
    }

    @Test
    public void trainerFactorySThere() {
        assertNotNull(trF);
    }
   
    @Test
    public void checkPlayerCurrentTeam() {
        assertEquals("Speranta Nisporeni", igorAndronic.currentTeam().toString());
        System.out.println(igorAndronic.getFirstName() + " " + igorAndronic.getLastName()
                + " is currently playing for ".concat(igorAndronic.currentTeam().toString()));
    }

    @Test
    public void playerSalaryIsAlright() {
        System.out.println(igorAndronic.getFirstName()
                + "'s salary is " + igorAndronic.getSalary());
        assertEquals("2.300,00 €", igorAndronic.getSalary());
    }

    @Test
    public void plasyerAgeWithinRange() {
        assertTrue(igorAndronic.getAge() >= 17 & igorAndronic.getAge() <= 38);
    }

    @Test
    public void playerIsInTheTeam() {
        assertTrue(teamSperanta.getPlayers().contains(igorAndronic));
    }

    @Test(expected = PlayerAlreadyExists.class)
    public void addingExistingPlayerToATeam() throws PlayerAlreadyExists {
        try {
            teamSperanta.addPlayer(igorAndronic);
        } catch (TeamSizeException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
