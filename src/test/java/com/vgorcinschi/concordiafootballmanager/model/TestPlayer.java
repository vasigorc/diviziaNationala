/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vgorcinschi.concordiafootballmanager.model;

import com.vgorcinschi.concordiafootballmanager.model.players.Goalkeeper;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vgorcinschi
 */
public class TestPlayer {

    //fictious playerainer to be set up in this test    
    private Player player;
    /*
     both first and last name should not be shorter
     than 2 letters, longer than 20 (unrealistic)
     and contain any digits
     */
    private final Pattern pattern = Pattern.compile("^\\D{2,20}$");
//    public TestPlayer() {
//    }
//    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }

    @Before
    public void setUp() {
        player = new Goalkeeper("Radu", "Mitu", 20, 2000, "Moldova");
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
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
        assertTrue(player.getAge()>=20&player.getAge()<=23);
    }
    
    @Test
    public void positionIsValid(){
        assertEquals("Goalkeeper", player.getPosition());
    }
}
