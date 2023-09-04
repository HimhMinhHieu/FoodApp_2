/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hieu.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.hieu.pojo.ThucAn;
import com.hieu.repository.FoodRepository;
import com.hieu.service.CategoryService;
import com.hieu.service.CuaHangService;
import com.hieu.service.FoodService;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Thao
 */
@Service
public class FoodServiceImpl implements FoodService{

    @Autowired
    private FoodRepository foodRepo;
    @Autowired
    private Cloudinary cloudinary;
    @Autowired
    private CategoryService cateService;
    @Autowired
    private CuaHangService storeService;
    
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
        if (!f.getFile().isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(f.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                f.setImage(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(FoodServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        return this.foodRepo.addOrUpdateFood(f);
    }

    @Override
    public boolean deleteFood(int id) {
        return this.foodRepo.deleteFood(id);
    }

    @Override
    public boolean deleteAllFood(int id) {
        return this.foodRepo.deleteAllFood(id);
    }

    @Override
    public ThucAn addFood(Map<String, String> params, MultipartFile file) {
        ThucAn f = new ThucAn();
        f.setName(params.get("name"));
        f.setSoLuong(Integer.parseInt(params.get("soLuong")));
        f.setPrice(Long.parseLong(params.get("price")));
        f.setIdLoai(this.cateService.getCateById(Integer.parseInt(params.get("idLoai"))));
        f.setIdCuaHang(this.storeService.getCuaHangById(Integer.parseInt(params.get("idCuaHang"))));
        f.setCreatedDate(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
        if (!f.getFile().isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(f.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                f.setImage(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(FoodServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return f;
    }
    
}
