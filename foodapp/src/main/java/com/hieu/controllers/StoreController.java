/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hieu.controllers;

import com.hieu.pojo.ThucAn;
import com.hieu.service.CategoryService;
import com.hieu.service.CuaHangService;
import com.hieu.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author Thao
 */
@Controller
@ControllerAdvice
public class StoreController {
    @Autowired
    private FoodService foodService;
    @Autowired
    private CuaHangService storeService;
    @Autowired
    private CategoryService categoryService;
    
    @ModelAttribute
    public void commonAttr(Model model)
    {
        model.addAttribute("categories", this.categoryService.getCategorys());
        
    }
    
    @GetMapping("/stores/{id}")
    public String foodsdetail(@PathVariable("id") int id, Model model) 
    {
        model.addAttribute("stores", this.storeService.getCuaHangById(id));
        model.addAttribute("foods", this.foodService.getThucAnByCuaHang(id));
//        model.addAttribute("categories", this.categoryService.getCategorys());
        return "stores";
    }
    
    @GetMapping("/stores/{id}/foods")
    public String foodadd(Model model,@PathVariable("id") int id) 
    {
//        model.addAttribute("stores", this.storeService.getCuaHangById(id));
        ThucAn food = new ThucAn();
        food.setIdCuaHang(this.storeService.getCuaHangById(id));
        model.addAttribute("foods", food);
//        model.addAttribute("categories", this.categoryService.getCategorys());
//        model.addAttribute("categories", this.categoryService.getCategorys());
        return "foods";
    }
}
