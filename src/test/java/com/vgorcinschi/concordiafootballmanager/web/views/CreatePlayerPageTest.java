/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vgorcinschi.concordiafootballmanager.web.views;

import com.vgorcinschi.concordiafootballmanager.contextconfig.RootConfig;
import com.vgorcinschi.concordiafootballmanager.data.PlayerService;
import com.vgorcinschi.concordiafootballmanager.data.TrainerService;
import com.vgorcinschi.concordiafootballmanager.model.beans.TransferMarket;
import com.vgorcinschi.concordiafootballmanager.web.PersonGenerationController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 *
 * @author vgorcinschi
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
public class CreatePlayerPageTest {

    @Autowired
    TransferMarket generator;
    
    @Autowired
    PlayerService playerService;
    
    @Autowired
    TrainerService trainerService;

    private MockMvc mockMvc;

    @Before
    public void setUp() {

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        mockMvc = MockMvcBuilders.standaloneSetup(new PersonGenerationController(
                generator, playerService, trainerService))
                .setViewResolvers(viewResolver)
                .build();
    }
    
    @Test
    public void testCreatePlayer() throws Exception {
        mockMvc.perform(get("/createplayer")).andExpect(view().name("playerForm"));
    }
}
