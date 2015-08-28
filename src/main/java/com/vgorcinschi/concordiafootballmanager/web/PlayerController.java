/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vgorcinschi.concordiafootballmanager.web;

import com.vgorcinschi.concordiafootballmanager.data.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author vgorcinschi
 */
@Controller
@RequestMapping("/player")
public class PlayerController {
    
    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String getPlayers(Model model){        
        model.addAttribute("playerList", playerService.getAllPlayers());
        return "allPlayers";
    }
    
    @RequestMapping(value="/{playerId:\\d+}", method = RequestMethod.GET)
    public String getOnePlayer(@PathVariable long playerId, Model model){
        model.addAttribute("player", playerService.getPlayer(playerId));
        return "playerPage";
    }
}
