/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vgorcinschi.concordiafootballmanager.contextconfig;

import com.vgorcinschi.concordiafootballmanager.data.DataConfig;
import com.vgorcinschi.concordiafootballmanager.model.beans.*;
import com.vgorcinschi.concordiafootballmanager.model.validators.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * @author vgorcinschi
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages={"com.vgorcinschi.concordiafootballmanager.model",
"com.vgorcinschi.concordiafootballmanager.data"},
        excludeFilters={@Filter(type = FilterType.ANNOTATION, value=EnableWebMvc.class)})
@Import(DataConfig.class)
public class RootConfig {
    
    /*
        We'll keep this bean just for now, in case we will
    be required to do some more complex currency manipulations
    in the future
    */
    @Bean
    public MoneyOutput getMoneyOutput(){
        return new MoneyOutput();
    }
    
    @Bean
    public PlayerFactory playerFactory(){
        return new PlayerFactory();
    }
    
    @Bean
    public TrainerFactory trainerFactory(){
        return new TrainerFactory();
    }
    
    @Bean
    public SoccerDudesValidator dudesValidator(){
        return new SoccerDudesValidator();
    }
    
    @Bean
    public TeamValidator teamValidator(){
        return new TeamValidator();
    }
    
    @Bean
    public TransferMarket transferMarket(){
        return new TransferMarket(playerFactory(), trainerFactory(),
        dudesValidator(), teamValidator());
    }
        
    @Bean
    public TeamFactory teamFactory(){
        return  new TeamFactory(transferMarket(), teamValidator());
    }
}
