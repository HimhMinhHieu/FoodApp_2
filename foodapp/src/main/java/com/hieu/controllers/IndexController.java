/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hieu.controllers;

import com.hieu.service.CuaHangService;
import com.hieu.service.FoodService;
import com.hieu.service.LoaiCuaHangService;
import java.util.Map;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Thao
 */
@Controller
@ControllerAdvice
@PropertySource("classpath:configs.properties")
public class IndexController {

    @Autowired
    private CuaHangService storeService;

    @Autowired
    private LoaiCuaHangService catestoreService;

    @Autowired
    private FoodService foodService;
    
    @ModelAttribute
    public void commonAttr(Model model, @RequestParam Map<String, String> params) {
//        model.addAttribute("catestores", this.catestoreService.getLoaiCuaHangs());
        model.addAttribute("stores", this.storeService.getCuaHangs(params));
    }

    @RequestMapping("/")
    public String index(Model model, @RequestParam Map<String, String> params) {

        model.addAttribute("catestores", this.catestoreService.getLoaiCuaHangs());
        model.addAttribute("foods", this.foodService.getThucAns(params));
        
        return "index";
    }
}
