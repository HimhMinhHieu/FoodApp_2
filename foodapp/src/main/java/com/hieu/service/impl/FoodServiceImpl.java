/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hieu.service.impl;

import com.hieu.pojo.ThucAn;
import com.hieu.repository.FoodRepository;
import com.hieu.service.FoodService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Thao
 */
@Service
public class FoodServiceImpl implements FoodService{

    @Autowired
    private FoodRepository foodRepo;
    
    @Override
    public List<ThucAn> getThucAns(Map<String, String> params) {
        return this.foodRepo.getThucAns(params);
    }

//    @Override
//    public ThucAn getThucAnByCuaHang(int id) {
//        return this.foodRepo.getThucAnByCuaHang(id);
//    }

    @Override
    public List<ThucAn> getThucAnByCuaHang(int id) {
        return this.foodRepo.getThucAnByCuaHang(id);
    }

    @Override
    public ThucAn getThucAnById(int id) {
        return this.foodRepo.getThucAnById(id);
    }

    @Override
    public boolean addOrUpdateFood(ThucAn f) {
        return this.foodRepo.addOrUpdateFood(f);
    }

    @Override
    public boolean deleteFood(int id) {
        return this.foodRepo.deleteFood(id);
    }
    
}
