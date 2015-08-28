/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vgorcinschi.concordiafootballmanager.web.views;

import com.vgorcinschi.concordiafootballmanager.contextconfig.RootConfig;
import com.vgorcinschi.concordiafootballmanager.customexceptions.InvalidSoccerDudeException;
import com.vgorcinschi.concordiafootballmanager.data.DefaultPlayerService;
import com.vgorcinschi.concordiafootballmanager.data.DefaultTrainerService;
import com.vgorcinschi.concordiafootballmanager.data.PlayerRepository;
import com.vgorcinschi.concordiafootballmanager.data.PlayerService;
import com.vgorcinschi.concordiafootballmanager.data.TrainerRepository;
import com.vgorcinschi.concordiafootballmanager.data.TrainerService;
import com.vgorcinschi.concordiafootballmanager.model.Player;
import com.vgorcinschi.concordiafootballmanager.model.Trainer;
import com.vgorcinschi.concordiafootballmanager.model.beans.TransferMarket;
import com.vgorcinschi.concordiafootballmanager.web.WebConfig;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @author vgorcinschi
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class, RootConfig.class})
@WebAppConfiguration
public class IntegrationRepositoryStubTest {

    private Player dummy;
    private PlayerRepositoryStub prs;
    private PlayerService playerService;
    
    private Trainer tester;
    private TrainerRepositoryStub trs;
    private TrainerService trainerService;
    
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext wac;

    @Autowired
    TransferMarket generator;

    private class PlayerRepositoryStub implements PlayerRepository {

        @Override
        public List<Player> getAll() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Player get(long id) {
            return dummy;
        }

        @Override
        public void add(Player player) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void update(Player player) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void delete(Player player) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Player findByLastName(String lastName) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }
    
    private class TrainerRepositoryStub implements TrainerRepository{

        @Override
        public List<Trainer> getAll() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Trainer get(long id) {
            return tester;
        }

        @Override
        public void add(Trainer trainer) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void update(Trainer trainer) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }

    public IntegrationRepositoryStubTest() {
    }

    @Before
    public void setUp() throws InvalidSoccerDudeException {
        //set-up fake repository with one hard-coded player, add them to service
        dummy = generator.playerGenerator("Forward", "Bunny", "Bugs", 30, "Canada", 1000000);
        dummy.setId(2);
        prs = new PlayerRepositoryStub();
        playerService = new DefaultPlayerService(prs);
        
        //set-up fake repository with one hard-coded trainer, add them to service
        tester = generator.trainerGenerator("Stefan", "Stoica", 50, 60000);
        tester.setId(2);
        trs = new TrainerRepositoryStub();
        trainerService = new DefaultTrainerService(trs);
        
        mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void expectPlayerIdPage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/player/" + playerService.getPlayer(2).getId())).andExpect(view().name("playerPage"));
    }
    
    @Test
    public void epectTrainerIdPage() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/trainer/" + trainerService.getTrainer(2).getId())).andExpect(view().name("trainerPage"));
    }
}
