/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vgorcinschi.concordiafootballmanager.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vgorcinschi
 */
public class TestTrainer {
    
    //fictious trainer to be set up in this test    
    private Trainer tr;
    /*
        both first and last name should not be shorter
        than 2 letters, longer than 20 (unrealistic)
        and contain any digits
    */
    private final Pattern pattern = Pattern.compile("^\\D{2,20}$");
    
    public TestTrainer() {
    }

//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
    @Before
    public void setUpTrainer() {
        tr = new Trainer("Franck","Vercauteren", 45);
        tr.setSalary(5000);
        tr.addTeam(2014, 2015, new Team("Krylya Sovetov Samara", 1952));
    }
//    
//    @After
//    public void tearDown() {
//    }
    @Test
    public void nameIsFine() {        
        Matcher firstNameMatcher = pattern.matcher(tr.getFirstName());
        Matcher lastNameMatcher = pattern.matcher(tr.getLastName());
        assertTrue(firstNameMatcher.matches() & lastNameMatcher.matches());
    }
    
    @Test
    public void salaryIsAlright(){
        System.out.println("Franck's Salaray is "+tr.getSalary());
        assertEquals("5.000,00 €", tr.getSalary());
    }
    
    @Test
    public void ageWithinRange(){
        assertTrue(tr.getAge()>=40);
    }
    
    @Test
    public void validateCurrentTeam(){
        assertEquals("Krylya Sovetov Samara", tr.currentTeam().toString());
    }
}
