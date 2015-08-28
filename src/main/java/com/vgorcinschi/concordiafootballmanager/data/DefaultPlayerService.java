/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vgorcinschi.concordiafootballmanager.data;

import com.vgorcinschi.concordiafootballmanager.customannotations.H2Schema;
import com.vgorcinschi.concordiafootballmanager.model.Player;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vgorcinschi
 */
@Service
public class DefaultPlayerService implements PlayerService {

    PlayerRepository playerRepository;

    @Autowired
    @H2Schema
    public DefaultPlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    @Transactional
    public List<Player> getAllPlayers() {
        List<Player> list = this.playerRepository.getAll();
        list.sort((p1, p2) -> p1.getSalary().compareTo(p2.getSalary()));
        return list;
    }

    @Override
    @Transactional
    public Player getPlayer(long id) {
        return this.playerRepository.get(id);
    }

    @Override
    @Transactional
    public void savePlayer(Player player) {
        if (getPlayer(player.getId()) == null) {
            this.playerRepository.add(player);
        } else {
            this.playerRepository.update(player);
        }
    }
    
    @Override
    @Transactional
    public void deletePlayer(Player player){
        this.playerRepository.delete(player);
    }
}
