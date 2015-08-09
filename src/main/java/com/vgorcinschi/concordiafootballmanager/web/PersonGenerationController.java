/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vgorcinschi.concordiafootballmanager.web;

import com.vgorcinschi.concordiafootballmanager.model.beans.TransferMarket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
/**
 *
 * @author vgorcinschi
 */
@Controller
public class PersonGenerationController {
    
    private final TransferMarket generator;

    @Autowired
    public PersonGenerationController(TransferMarket generator) {
        this.generator = generator;
    }
    
    @RequestMapping(value = "createplayer", method = GET)
    public String createPlayer(){
        return "createplayer";
    }
}
