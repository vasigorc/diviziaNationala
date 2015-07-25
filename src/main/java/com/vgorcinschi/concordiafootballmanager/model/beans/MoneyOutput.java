/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vgorcinschi.concordiafootballmanager.model.beans;

import java.text.NumberFormat;
import java.util.Currency;
import static java.util.Locale.GERMANY;

/**
 *
 * @author vgorcinschi
 */
public class MoneyOutput {
    private final NumberFormat euroFormatter = NumberFormat.getCurrencyInstance(GERMANY);
    
    public Currency returnCurrency(){
        return euroFormatter.getCurrency();
    }
    
    public String getCurrencyString(){
        return euroFormatter.getCurrency().getDisplayName();
    }
    
    //returns formatted double of any wage
    public String meSalary(double amount){
        return euroFormatter.format(amount);
    }
}
