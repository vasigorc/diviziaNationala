/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vgorcinschi.concordiafootballmanager.data;

import com.vgorcinschi.concordiafootballmanager.model.Trainer;
import java.util.List;

/**
 *
 * @author vgorcinschi
 */
public interface TrainerService {
    List<Trainer> getAllTrainers();
    Trainer getTrainer(long id);
    void saveTraier(Trainer trainer);
    
}
