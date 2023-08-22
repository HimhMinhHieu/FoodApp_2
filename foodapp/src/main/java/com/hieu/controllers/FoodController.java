/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hieu.controllers;

import com.hieu.pojo.ThucAn;
import com.hieu.service.CategoryService;
import com.hieu.service.CuaHangService;
import com.hieu.service.FoodService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Thao
 */
@Controller
public class FoodController {
    @Autowired
    private FoodService foodService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CuaHangService storeService;
    
    @ModelAttribute
    public void commonAttr(Model model)
    {
        model.addAttribute("categories", this.categoryService.getCategorys());
        
    }
    
    @GetMapping("/stores/{id}/foods")
    public String foodlist(Model model,@PathVariable("id") int id) 
    {

        ThucAn food = new ThucAn();
        food.setIdCuaHang(this.storeService.getCuaHangById(id));
        
        model.addAttribute("foods", food);
//        model.addAttribute("stores", this.storeService.getCuaHangById(id));
//        model.addAttribute("categories", this.categoryService.getCategorys());
//        model.addAttribute("categories", this.categoryService.getCategorys());
        return "foods";
    }
    
     @PostMapping("/stores/{id}/foods")
    public String foodadd(@ModelAttribute(value = "foods") @Valid ThucAn f, BindingResult rs)
    {
//        ThucAn food = new ThucAn();
//        food.setIdCuaHang(this.storeService.getCuaHangById(id));
//        model.addAttribute("foods", food);
        if(!rs.hasErrors()){
            
            if(this.foodService.addOrUpdateFood(f) == true)
                return "redirect:/stores/{id}";
        }
        return "foods";
    }
    
    @GetMapping("/stores/{id}/foods/{id}")
    public String updateFood(Model model, @PathVariable(value = "id") int id)
    {
        model.addAttribute("foods", this.foodService.getThucAnById(id));
        return "foods";
    }
}
