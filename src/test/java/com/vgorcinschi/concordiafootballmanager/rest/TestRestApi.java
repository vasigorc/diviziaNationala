/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vgorcinschi.concordiafootballmanager.rest;

import com.vgorcinschi.concordiafootballmanager.contextconfig.RootConfig;
import com.vgorcinschi.concordiafootballmanager.customexceptions.InvalidSoccerDudeException;
import com.vgorcinschi.concordiafootballmanager.data.PlayerService;
import com.vgorcinschi.concordiafootballmanager.model.beans.TransferMarket;
import com.vgorcinschi.concordiafootballmanager.web.WebConfig;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 *
 * @author vgorcinschi
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class, RestServletContextConfiguration.class, RootConfig.class})
@WebAppConfiguration
public class TestRestApi {
    
    private MockMvc mockMvc;
    
    @Autowired
    private WebApplicationContext wac;
    
    @Autowired
    private PlayerService service;
    
    @Autowired
    private TransferMarket generator;
   
    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        
    }
    
    @Test
    public void serviceNotNull(){
        assertNotNull(this.service);
    }

     @Test
     @Rollback(true)
     public void samplePlayerRepresentationReturned() throws InvalidSoccerDudeException, Exception {
         this.service.savePlayer(generator.playerGenerator("Forward", "Alexandr", "Kokorin", 24, "Russia", 3000000));
         mockMvc.perform(get("/resources/player/Kokorin"))
                 .andDo(print())
                 .andExpect(status().isOk())
                 .andExpect((ResultMatcher) content().contentType("application/json"))
                 .andExpect(jsonPath("$.lastName").value("Kokorin"));
     }
}
