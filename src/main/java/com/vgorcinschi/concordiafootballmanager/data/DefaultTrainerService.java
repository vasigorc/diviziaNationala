/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vgorcinschi.concordiafootballmanager.data;

import com.vgorcinschi.concordiafootballmanager.model.Trainer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vgorcinschi
 */
@Service
public class DefaultTrainerService implements TrainerService {
    
    TrainerRepository trainerRepository;

    @Autowired
    public DefaultTrainerService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    @Override
    public List<Trainer> getAllTrainers() {
        List<Trainer> list = this.trainerRepository.getAll();
        list.sort((p1, p2)-> p1.getSalary().compareTo(p2.getSalary()));
        return list;
    }

    @Override
    public Trainer getTrainer(long id) {
        return this.trainerRepository.get(id);
    }

    @Override
    public void saveTraier(Trainer trainer) {
        this.trainerRepository.add(trainer);
    }
       
}
