/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hieu.controllers;

import com.hieu.service.CuaHangService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Thao
 */
@Controller
public class IndexController {
    @Autowired
    private CuaHangService storeService;
    
    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("stores", this.storeService.getCuaHangs(null));
        
        return "index";
    }
}
