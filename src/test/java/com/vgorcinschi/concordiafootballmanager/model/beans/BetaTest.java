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
import com.vgorcinschi.concordiafootballmanager.model.validators.SoccerDudesValidator;
import java.util.ArrayList;
import java.util.Arrays;
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
public class BetaTest {

    Player denisIlescu;
    Team zimbru;
    Trainer sStoica;

    @Autowired
    TransferMarket tM;

    @Autowired
    TrainerFactory trF;

    @Autowired
    PlayerFactory plF;

    @Autowired
    TeamFactory tF;

    @Autowired
    SoccerDudesValidator dv;

    @Before
    public void setUp() {
        try {
            denisIlescu = tM.playerGenerator("defender", "Denis", "Ilescu",
                    28, "Moldova", 1800);
            sStoica = tM.trainerGenerator("Stefan", "Stoica", 48, 5000);
            try {
                zimbru = tF.getTeam(new ArrayList<>(Arrays.asList(denisIlescu,
                        tM.playerGenerator("Goalkeeper", "Josimar", "Vozinha", 29, "Capo Verde", 3000),
                        tM.playerGenerator("Defender", "Stefan", "Burghiu", 24, "Moldova", 2500),
                        tM.playerGenerator("Defender", "Ion", "Jardan", 25, "Moldova", 3000),
                        tM.playerGenerator("Defender", "Daniel", "Vlas", 20, "Moldova", 1700),
                        tM.playerGenerator("Midfielder", "Jean-Marie", "Amani", 26, "France", 3000),
                        tM.playerGenerator("Midfielder", "Mendes", "Calu", 31, "Capo Verde", 3000),
                        tM.playerGenerator("Midfielder", "Bruno", "Alex", 21, "Brazil", 4000),
                        tM.playerGenerator("Midfielder", "Santos", "Jo", 24, "Brazil", 3000),
                        tM.playerGenerator("Midfielder", "Dan", "Spataru", 21, "Moldova", 4000),
                        tM.playerGenerator("Forward", "Reis", "Edivandio", 24, "Capo Verde", 4100))), 
                        sStoica, "FC Zimbru", 1951);
            } catch (InvalidTeamException ex) {
                System.out.println(ex.getMessage());
            }
        } catch (InvalidSoccerDudeException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void aValidatorIsWired() {
        assertNotNull(tF);
    }

    @Test
    public void playerIsGood() {
        assertTrue(dv.playerIsValid(denisIlescu));
    }

    @Test
    public void checkCurrentTeam() {
        assertEquals(denisIlescu.currentTeam(), sStoica.currentTeam());
    }

    @Test(expected = PlayerAlreadyExists.class)
    public void addingExistingPlayerToATeam() throws PlayerAlreadyExists {
        try {
            zimbru.addPlayer(denisIlescu);
        } catch (TeamSizeException ex) {
            Logger.getLogger(BetaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void playerSalaryIsAlright() {
        System.out.println(denisIlescu.getFirstName()
                + "'s salary is " + denisIlescu.getSalary());
        assertEquals("1.800,00 €", denisIlescu.getSalary());
    }

    @Test
    public void plasyerAgeWithinRange() {
        assertTrue(denisIlescu.getAge() >= 17 & denisIlescu.getAge() <= 38);
    }
}
