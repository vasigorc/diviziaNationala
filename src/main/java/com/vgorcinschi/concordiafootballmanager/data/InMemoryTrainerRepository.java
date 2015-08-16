/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vgorcinschi.concordiafootballmanager.data;

import com.vgorcinschi.concordiafootballmanager.model.Trainer;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 *
 * @author vgorcinschi
 */
@Repository
public class InMemoryTrainerRepository implements TrainerRepository {

    private final Map<Long, Trainer> database = new Hashtable<>();
    private volatile long trainerIdSequence = 1L;

    @Override
    public List<Trainer> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Trainer get(long id) {
        return this.database.get(id);
    }

    @Override
    public void add(Trainer trainer) {
        trainer.setId(this.getNextId());
        this.database.put(trainer.getId(), trainer);
    }

    @Override
    public void update(Trainer trainer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private synchronized long getNextId(){
        return this.trainerIdSequence++;
    } 

}
