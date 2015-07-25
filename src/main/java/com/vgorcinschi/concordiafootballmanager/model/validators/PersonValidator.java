/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vgorcinschi.concordiafootballmanager.model.validators;

import com.vgorcinschi.concordiafootballmanager.model.Person;
import java.util.regex.Pattern;

/**
 *
 * @author vgorcinschi
 */
public interface PersonValidator {
    
    final Pattern pattern = Pattern.compile("^\\D{2,20}$");
    
    public boolean salaryNotEmpty(Person pr);
    
    public boolean nameIsValid(Person pr);
}
