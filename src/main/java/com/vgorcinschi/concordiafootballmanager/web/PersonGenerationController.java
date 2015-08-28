/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vgorcinschi.concordiafootballmanager.web;

import com.vgorcinschi.concordiafootballmanager.customexceptions.InvalidSoccerDudeException;
import com.vgorcinschi.concordiafootballmanager.data.PlayerService;
import com.vgorcinschi.concordiafootballmanager.data.TrainerService;
import com.vgorcinschi.concordiafootballmanager.model.Player;
import com.vgorcinschi.concordiafootballmanager.model.Trainer;
import com.vgorcinschi.concordiafootballmanager.model.beans.TransferMarket;
import com.vgorcinschi.concordiafootballmanager.web.forms.PlayerForm;
import com.vgorcinschi.concordiafootballmanager.web.forms.TrainerForm;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 *
 * @author vgorcinschi
 */
@Controller
public class PersonGenerationController {

    private final TransferMarket generator;
    private final PlayerService playerService;
    private final TrainerService trainerService;

    @Autowired
    public PersonGenerationController(TransferMarket generator, 
            PlayerService playerService, TrainerService trainerService) {
        this.generator = generator;
        this.playerService = playerService;
        this.trainerService = trainerService;
    }

    @RequestMapping(value = "/createplayer", method = GET)
    public String createPlayerForm(Model model) {
        model.addAttribute(new PlayerForm());
        return "playerForm";
    }

    @RequestMapping(value = "/createplayer", method = POST)
    public String processForm(
            @Valid PlayerForm playerForm,
            Errors errors) throws InvalidSoccerDudeException {
        if (errors.hasErrors()) {
            return "playerForm";
        }
        Player aPlayer = generator.playerGenerator(playerForm.getPosition(),
                playerForm.getFirstName(), playerForm.getLastName(),
                playerForm.getAge(), playerForm.getBirthCountry(), playerForm.getSalary());
        aPlayer.setStats(playerForm.getStats());
        playerService.savePlayer(aPlayer);
        return "redirect:/player/" + aPlayer.getId();
    }

    @RequestMapping(value = "/createtrainer", method = GET)
    public String createTrainerForm(Model model) {
        model.addAttribute(new TrainerForm());
        return "trainerForm";
    }

    @RequestMapping(value = "/createtrainer", method = POST)
    public String processTrainerForm(
            @Valid TrainerForm trainerForm,
            Errors errors) throws InvalidSoccerDudeException {
        if (errors.hasErrors()) {
            return "trainerForm";
        }
        Trainer aTrainer = generator.trainerGenerator(trainerForm.getFirstName(),
                trainerForm.getLastName(), trainerForm.getAge(), trainerForm.getSalary());
        trainerService.saveTraier(aTrainer);
        return "redirect:/trainer/" + aTrainer.getId();
    }
}
