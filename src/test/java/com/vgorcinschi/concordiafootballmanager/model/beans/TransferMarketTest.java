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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    Player igorAndronic, adrianPatras, sergiuVitu, alinSeroni, ionDemerji,
            alexGrosu, eugenGorceac, cristianEfros, igorDima, maximSoimu,
            ghenadieOrbu, mihaiOnicas;
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
        Trainer petruEfros = null;
        try {
            igorAndronic = tM.playerGenerator("Defender", "Igor", "Andronic", 27, "Moldova", 2300);
            adrianPatras = tM.playerGenerator("Goalkeeper", "Adrian", "Patras", 30, "Moldova", 1600);
            sergiuVitu = tM.playerGenerator("Defender", "Sergiu", "Vitu", 23, "Moldova", 1300);
            alinSeroni = tM.playerGenerator("Defender", "Alin", "Seroni", 28, "Moldova", 1250);
            ionDemerji = tM.playerGenerator("Midfielder", "Ion", "Demerji", 26, "Moldova", 1400);
            alexGrosu = tM.playerGenerator("Midfielder", "Alexandru", "Grosu", 27, "Moldova", 1850);
            eugenGorceac = tM.playerGenerator("Midfielder", "Eugen", "Gorceac", 28, "Moldova", 1300);
            cristianEfros = tM.playerGenerator("Midfielder", "Cristian", "Efros", 23, "Moldova", 1450);
            igorDima = tM.playerGenerator("Midfielder", "Igor", "Dima", 22, "Moldova", 1800);
            maximSoimu = tM.playerGenerator("Midfielder", "Maxim", "Soimu", 25, "Moldova", 1400);
            ghenadieOrbu = tM.playerGenerator("Forward", "Ghenadie", "Orbu", 33, "Moldova", 1800);
            mihaiOnicas = tM.playerGenerator("Midfielder", "Mihai", "Onicas", 25, "Moldova", 1900);
            petruEfros = tM.trainerGenerator("Petru", "Efros", 50, 2400);
        } catch (InvalidSoccerDudeException ex) {
            System.out.println(ex.getMessage());
        }
        List<Player> players = new ArrayList<>(Arrays.asList(igorAndronic, adrianPatras, sergiuVitu, alinSeroni, ionDemerji,
                alexGrosu, eugenGorceac, cristianEfros, igorDima, maximSoimu,
                ghenadieOrbu, mihaiOnicas));
        try {
            teamSperanta = tF.getTeam(players, petruEfros, "Speranta Nisporeni", 1992);
        } catch (InvalidTeamException ex) {
            Logger.getLogger(TransferMarketTest.class.getName()).log(Level.SEVERE, null, ex);
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
        assertEquals("Speranta Nisporeni", igorAndronic.getCurrentTeam().toString());
        System.out.println(igorAndronic.getFirstName() + " " + igorAndronic.getLastName()
                + " is currently playing for ".concat(igorAndronic.getCurrentTeam().toString()));
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
