/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hieu.controllers;

import com.hieu.pojo.CuaHang;
import com.hieu.pojo.ThucAn;
import com.hieu.service.CategoryService;
import com.hieu.service.CuaHangService;
import com.hieu.service.FoodService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Thao
 */
@RestController
@RequestMapping("/api")
public class ApiFoodController {
    @Autowired
    private FoodService foodService;
    @Autowired
    private CategoryService cateService;
    @Autowired
    private CuaHangService storeService;
    
    @DeleteMapping("/stores/foods/{id}/")
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
    
    @GetMapping("/stores/foods/")
    @CrossOrigin
    public ResponseEntity<List<ThucAn>> listFood(@RequestParam Map<String, String> params){
        return new ResponseEntity<>(this.foodService.getThucAns(params), HttpStatus.OK);
    }
    
    @PostMapping(path = "/stores/{id}/foods", consumes = {
        MediaType.MULTIPART_FORM_DATA_VALUE,
        MediaType.APPLICATION_JSON_VALUE
    })
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestParam Map<String, String> params, @RequestPart MultipartFile[] file) {
        ThucAn f = new ThucAn();
        f.setName(params.get("name"));
        f.setSoLuong(Integer.parseInt(params.get("soLuong")));
        f.setPrice(Long.parseLong(params.get("price")));
        f.setIdLoai(this.cateService.getCateById(Integer.parseInt(params.get("categoryId"))));
        f.setIdCuaHang(this.storeService.getCuaHangById(Integer.parseInt(params.get("storeId"))));
        if (file.length > 0)
            f.setFile(file[0]);
        this.foodService.addOrUpdateFood(f);
    }
}
