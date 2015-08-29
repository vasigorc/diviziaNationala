/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vgorcinschi.concordiafootballmanager.model.beans;

import com.vgorcinschi.concordiafootballmanager.contextconfig.RootConfig;
import com.vgorcinschi.concordiafootballmanager.customannotations.H2Schema;
import com.vgorcinschi.concordiafootballmanager.customexceptions.InvalidSoccerDudeException;
import com.vgorcinschi.concordiafootballmanager.data.PlayerRepository;
import com.vgorcinschi.concordiafootballmanager.data.PlayerService;
import com.vgorcinschi.concordiafootballmanager.data.TrainerService;
import com.vgorcinschi.concordiafootballmanager.model.Player;
import com.vgorcinschi.concordiafootballmanager.model.Trainer;
import com.vgorcinschi.concordiafootballmanager.model.players.Defender;
import com.vgorcinschi.concordiafootballmanager.web.WebConfig;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @author vgorcinschi
 */
@WebAppConfiguration
@ContextConfiguration(classes = {WebConfig.class, RootConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class RepositoryTest {
    @Autowired
    TransferMarket generator;
    
    @Autowired
    PlayerService playerService;
    
    @Autowired
    TrainerService trainerService;
    
    @Autowired
    @H2Schema
    PlayerRepository pr;
    
    Player dummy;
    Trainer tester;
    
    @Autowired
    protected WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = webAppContextSetup(wac).build();
        try {
            dummy = generator.playerGenerator("Defender", "Donald", "Duck", 23, "USA", 3000000);
            tester = generator.trainerGenerator("Cristophor", "Columbus", 41, 2000000);
        } catch (InvalidSoccerDudeException ex) {
            Logger.getLogger(RepositoryTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Test
    public void dummyIsDef(){
        assertThat(dummy, instanceOf(Defender.class));
    }
    
    @Test
    public void dummyIsStored(){
        playerService.savePlayer(dummy);
        long dummyId = dummy.getId();
        assertEquals(dummy, playerService.getPlayer(dummyId));
    }
    
    @Test
    public void testerIsStored(){
        trainerService.saveTraier(tester);
        long testerId = tester.getId();
        assertEquals(tester, trainerService.getTrainer(testerId));
    }
}
