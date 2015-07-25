/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vgorcinschi.concordiafootballmanager.model.validators;

import com.vgorcinschi.concordiafootballmanager.model.*;
import java.util.regex.Matcher;

/**
 *
 * @author vgorcinschi
 */
public class SoccerDudesValidator implements PersonValidator {

    private Player pl = null;
    private Trainer tr = null;

    public SoccerDudesValidator() {        
    }

    @Override
    public boolean salaryNotEmpty(Person pr) {
        return pr.getSalary()!=null&pr.getSalary().length()>0;
    }
    
    @Override
    public boolean nameIsValid(Person pr) {
        Matcher firstNameMatcher = pattern.matcher(pr.getFirstName());
        Matcher lastNameMatcher = pattern.matcher(pr.getLastName());
        return firstNameMatcher.matches() && lastNameMatcher.matches();
    }
    
    private boolean playerAgeIsValid(){
        return (pl.getAge()>=17 && pl.getAge()<=37);
    }
    
    private boolean statsAreFine(){
        return pl.getStats().getGames()>=0 && pl.getStats().getGoals()>=0 ;
    }
    
    private boolean trainerAgeIsValid(){
        return tr.getAge()>=40 && tr.getAge()<=80;
    }
    
    private boolean birthcountryIsValid(){
        Matcher birthcountryMatcher = pattern.matcher(pl.getBirthCountry());
        return birthcountryMatcher.matches();
    }

    public boolean playerIsValid(Player pl) {
        this.pl = pl;
        return (pl!=null && salaryNotEmpty(pl) && nameIsValid(pl) && playerAgeIsValid()&& birthcountryIsValid() && statsAreFine());
    }
    
    public boolean trainerIsValid(Trainer tr){
        this.tr= tr;
        return (tr!=null && salaryNotEmpty(tr) && nameIsValid(tr) && trainerAgeIsValid() && birthcountryIsValid());
    }
}
