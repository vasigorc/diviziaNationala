/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vgorcinschi.concordiafootballmanager.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 *
 * @author vgorcinschi
 */
@Controller
@RequestMapping({"/", "/home", "/main"})
public class HomeController {
    
    @RequestMapping(method=GET)
    public String home(){
        return "home";
    }
}
