/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vgorcinschi.concordiafootballmanager.data;

import com.vgorcinschi.concordiafootballmanager.model.Player;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 *
 * @author vgorcinschi
 */
@Repository
public class InMemoryPlayerRepository implements PlayerRepository {
    private final Map<Long, Player> database = new Hashtable<>();
    private volatile long playerIdSequence = 1L;

    @Override
    public List<Player> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Player get(long id) {
        return this.database.get(id);
    }

    @Override
    public void add(Player player) {
        player.setId(this.getNextId());
        this.database.put(player.getId(), player);
    }

    @Override
    public void update(Player player) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private synchronized long getNextId(){
        return this.playerIdSequence++;
    }    
}
