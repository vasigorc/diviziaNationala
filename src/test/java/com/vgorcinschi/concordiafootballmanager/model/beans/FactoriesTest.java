/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vgorcinschi.concordiafootballmanager.model.beans;

import com.vgorcinschi.concordiafootballmanager.contextconfig.RootConfig;
import com.vgorcinschi.concordiafootballmanager.model.Person;
import com.vgorcinschi.concordiafootballmanager.model.Player;
import com.vgorcinschi.concordiafootballmanager.model.Trainer;
import com.vgorcinschi.concordiafootballmanager.model.players.Defender;
import static org.hamcrest.CoreMatchers.instanceOf;
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
@ContextConfiguration(classes={RootConfig.class})
public class FactoriesTest {
    
    Person goodMan;
    Player orlovschi;
    
    @Autowired
    TrainerFactory trF;
    
    @Autowired
    PlayerFactory plF;
    
    @Before
    public void launchFactory(){
        goodMan = trF.gettrainer();
        orlovschi = plF.getPlayer("Defender");
    }
    
    @Test
    public void playerFactorySThere(){
        assertNotNull(plF);
    }
    
    @Test
    public void playerIsNotNull(){
        assertNotNull(orlovschi);
    }
    
    @Test
    public void trainerIsNotNull(){
        assertNotNull(goodMan);
    }
    
    @Test
    public void playerIsInstanceOf(){
        assertThat(orlovschi, instanceOf(Defender.class));
    }
    
    @Test
    public void trainerIsInstanceOf(){
        assertThat(goodMan, instanceOf(Trainer.class));
    }
}
