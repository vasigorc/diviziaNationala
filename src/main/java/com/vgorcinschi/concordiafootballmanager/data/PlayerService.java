/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vgorcinschi.concordiafootballmanager.data;

import com.vgorcinschi.concordiafootballmanager.model.Player;
import java.util.List;

/**
 *
 * @author vgorcinschi
 */
public interface PlayerService {
    List<Player> getAllPlayers();
    Player getPlayer(long id);
    void savePlayer(Player player);
    void deletePlayer(Player player);
}
