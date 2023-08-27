/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hieu.controllers;

import com.hieu.pojo.CuaHang;
import com.hieu.pojo.ThucAn;
import com.hieu.service.CuaHangService;
import com.hieu.service.FoodService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Chung Vu
 */
@RestController
@RequestMapping("/api")
public class ApiStoreController {
    @Autowired
    private CuaHangService storeService;
    @Autowired
    private FoodService foodService;
    
    @GetMapping("/stores/")
    @CrossOrigin
    public ResponseEntity<List<CuaHang>> list(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.storeService.getCuaHangs(params), HttpStatus.OK);
    }
    
    @DeleteMapping("/stores/{id}/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFood(@PathVariable(value = "id") int id)
    {
        List<ThucAn> food = this.foodService.getThucAnByCuaHang(id);
        if(food != null)
        {
            this.foodService.deleteAllFood(id);
        }
        
        this.storeService.deleteStore(id);
    }
}
