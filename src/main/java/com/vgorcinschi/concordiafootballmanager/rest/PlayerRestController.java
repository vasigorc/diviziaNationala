/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vgorcinschi.concordiafootballmanager.rest;

import com.vgorcinschi.concordiafootballmanager.customannotations.H2Schema;
import com.vgorcinschi.concordiafootballmanager.data.PlayerRepository;
import com.vgorcinschi.concordiafootballmanager.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author vgorcinschi
 */
@RestController
@RequestMapping("/resources/player")
public class PlayerRestController {
    
    private final PlayerRepository repository;

    @Autowired
    @H2Schema
    public PlayerRestController(PlayerRepository repository) {
        this.repository = repository;
    }
    
    @RequestMapping(value = "/{lastName}", method=RequestMethod.GET, produces="application/json")
    public Player playerByLastName(@PathVariable String lastName){
        return this.repository.findByLastName(lastName);
    }
}
