/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vgorcinschi.concordiafootballmanager.model;

import com.vgorcinschi.concordiafootballmanager.model.players.Forward;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author vgorcinschi
 */
public class TestExperiencedPlayer {
    
    private Player player;
    private final Pattern pattern = Pattern.compile("^\\D{2,20}$");
    
    
    @Before
    public void setUp() {
        player = new Forward("Reis", "Edivandio", 24, 2000, "Kap Verde");
        player.addTeam(2014, 2015, new Team("Zimbru", 1951));
    }

    @Test
    public void nameIsFine() {        
        Matcher firstNameMatcher = pattern.matcher(player.getFirstName());
        Matcher lastNameMatcher = pattern.matcher(player.getLastName());
        assertTrue(firstNameMatcher.matches() & lastNameMatcher.matches());
    }
    
    @Test
    public void salaryIsAlright(){
        System.out.println(player.getFirstName()
                +" "+player.getLastName()+"'s salary is "+player.getSalary());
        assertEquals("2.000,00 €", player.getSalary());
    }
    
    @Test
    public void ageWithinRange(){
        assertTrue(player.getAge()>=17&player.getAge()<=38);
    }
    
    @Test
    public void positionIsValid(){
        assertEquals("Forward", player.getPosition());
    }
    
    @Test
    public void checkCurrentTeam(){
        assertEquals("Zimbru",player.getCurrentTeam().toString());
        System.out.println(player.getLastName()+" "+"from "+
                player.getBirthCountry()+" has moved to "+
                player.getCurrentTeam());
    }
}
