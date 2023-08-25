/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hieu.controllers;

import com.hieu.pojo.ThucAn;
import com.hieu.service.FoodService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Thao
 */
@RestController
@RequestMapping("/api")
public class ApiFoodController {
    @Autowired
    private FoodService foodService;
    
    @DeleteMapping("/stores/{id}/foods/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFood(@PathVariable(value = "id") int id)
    {
        this.foodService.deleteFood(id);
    }
    
    @GetMapping("/stores/{id}/")
    @CrossOrigin
    public ResponseEntity<List<ThucAn>> list(@PathVariable("id") int id){
        return new ResponseEntity<>(this.foodService.getThucAnByCuaHang(id), HttpStatus.OK);
    }
}
