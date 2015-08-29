/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vgorcinschi.concordiafootballmanager.web.views;

import com.vgorcinschi.concordiafootballmanager.contextconfig.RootConfig;
import com.vgorcinschi.concordiafootballmanager.customannotations.H2Schema;
import com.vgorcinschi.concordiafootballmanager.customexceptions.InvalidSoccerDudeException;
import com.vgorcinschi.concordiafootballmanager.data.PlayerRepository;
import com.vgorcinschi.concordiafootballmanager.data.PlayerService;
import com.vgorcinschi.concordiafootballmanager.model.Player;
import com.vgorcinschi.concordiafootballmanager.model.beans.TransferMarket;
import com.vgorcinschi.concordiafootballmanager.web.PlayerController;
import com.vgorcinschi.concordiafootballmanager.web.WebConfig;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.web.context.WebApplicationContext;
import static org.hamcrest.Matchers.*;

/**
 *
 * @author vgorcinschi
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class, RootConfig.class})
@WebAppConfiguration
public class AllPlayersPageTest {
    
    private MockMvc mockMvc;
    private Player playerOne, playerTwo;
    
    private PlayerController controller;
        
    @Autowired
    private WebApplicationContext wac;
    
    @Autowired
    PlayerService service;
    
    @Autowired
    @H2Schema
    PlayerRepository repository;
    
    @Autowired
    TransferMarket generator;    
    
    @Before
    public void setUp() throws InvalidSoccerDudeException {
        mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();  
        controller = new PlayerController(service);
        playerOne = this.generator.playerGenerator("Goalkeeper", "Vladimir", "Panteleimonov", 25, "Russia", 250000);
        playerTwo = this.generator.playerGenerator("Defender", "Joze", "Nadson", 30, "Brazil", 3000000);
        this.service.savePlayer(playerOne);
        this.service.savePlayer(playerTwo);
    }
    
    @After
    public void cleanUp(){
        this.service.deletePlayer(playerOne);
        this.service.deletePlayer(playerTwo);
    }
   
    @Test
    public void allPlayersPageTest() throws Exception{
        mockMvc.perform(get("/player"))
                .andExpect(view().name("allPlayers"))
                .andExpect(model().attributeExists("playerList"))
                .andExpect(model().attribute("playerList", hasItems(this.service.getAllPlayers().toArray())));
    }
}
