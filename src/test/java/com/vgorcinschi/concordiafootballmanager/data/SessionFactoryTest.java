/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vgorcinschi.concordiafootballmanager.data;

import com.vgorcinschi.concordiafootballmanager.contextconfig.RootConfig;
import com.vgorcinschi.concordiafootballmanager.customannotations.H2Schema;
import com.vgorcinschi.concordiafootballmanager.customexceptions.InvalidSoccerDudeException;
import com.vgorcinschi.concordiafootballmanager.model.Player;
import com.vgorcinschi.concordiafootballmanager.model.beans.TransferMarket;
import org.junit.After;
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
public class SessionFactoryTest {
    
    @Autowired
    PlayerService service;
    private Player dummy;
    
    @Autowired
    TransferMarket generator;
    
    @Autowired
    @H2Schema
    PlayerRepository repository;
    
    public SessionFactoryTest() {
        
    }
    
    @Before
    public void setUp() throws InvalidSoccerDudeException {
        dummy = generator.playerGenerator("Forward", "Bunny", "Bugs", 30, "Canada", 1000000);
        this.service.savePlayer(dummy);        
    }
    
    @After
    public void clearUp(){
        this.service.deletePlayer(dummy);
    }

    @Test
    public void repositoryIsThere(){
        assertNotNull(repository);
    }
    
    @Test
    public void playerIsSaved(){
        long id = dummy.getId();
        assertEquals(service.getPlayer(id), dummy);
    }
    
    @Test
    public void findPlayerByName(){
        assertNotNull(this.repository.findByLastName("Bugs"));
    }
    
    @Test
    public void playerSuccessfullyUpdated(){
        dummy.setFirstName("Donald");
        dummy.setLastName("Duck");
        this.service.savePlayer(dummy);
        assertEquals("Donald", this.service.getPlayer(dummy.getId()).getFirstName());
    }
}
