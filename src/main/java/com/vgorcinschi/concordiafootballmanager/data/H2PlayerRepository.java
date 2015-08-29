/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vgorcinschi.concordiafootballmanager.data;

import com.vgorcinschi.concordiafootballmanager.customannotations.H2Schema;
import com.vgorcinschi.concordiafootballmanager.model.Player;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vgorcinschi
 */
@Repository
@H2Schema
public class H2PlayerRepository implements PlayerRepository {
   
    private final SessionFactory sessionFactory;

    //Session Factory is injected into this Bean
    @Autowired
    public H2PlayerRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    //current Session object retrieved
    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Player> getAll() {
        return (List<Player>) currentSession().createCriteria(Player.class).list();
    }

    @Override
    public Player get(long id) {
        return (Player) currentSession().get(Player.class, id);
    }

    @Override
    public void add(Player player) {
        currentSession().persist(player);
        currentSession().flush();
    }

    @Override
    public void update(Player player) {
        currentSession().merge(player);
    }

    @Override
    @Transactional
    public Player findByLastName(String lastName) {
        return (Player) currentSession().createCriteria(Player.class)
                .add(Restrictions.ilike("lastName", lastName, MatchMode.ANYWHERE))
                .uniqueResult();
    }
    
    @Override
    public void delete(Player player){
        currentSession().delete(player);
    }
}
