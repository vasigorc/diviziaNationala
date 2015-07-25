/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vgorcinschi.concordiafootballmanager.model;

import java.text.NumberFormat;
import static java.util.Locale.GERMANY;

/**
 *interface used to define methods
 * common to both Players and Trainers
 * @author vgorcinschi
 */
public interface Person {
    final NumberFormat euroFormatter = NumberFormat.getCurrencyInstance(GERMANY);
    
    String getFirstName();
    
    String getLastName();
    
    int getAge();
    
    String getSalary();
}
