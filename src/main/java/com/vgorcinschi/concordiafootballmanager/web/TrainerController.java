/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vgorcinschi.concordiafootballmanager.web;

import com.vgorcinschi.concordiafootballmanager.data.TrainerService;
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
@RequestMapping("/trainer")
public class TrainerController {
    
    private final TrainerService trainerService;

    @Autowired
    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }
    
    @RequestMapping(value="/{trainerId:\\d+}", method = RequestMethod.GET)
    public String getOneTrainer(@PathVariable long trainerId, Model model){
        model.addAttribute("trainer", trainerService.getTrainer(trainerId));
        return "trainerPage";
    }
}
