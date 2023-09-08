/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hieu.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.hieu.pojo.CuaHang;
import com.hieu.repository.CuaHangRepository;
import com.hieu.service.CuaHangService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Thao
 */
@Service
public class CuaHangServiceImpl implements CuaHangService{
    @Autowired
    private CuaHangRepository storeRepo;
    @Autowired
    private Cloudinary cloudinary;
    
    @Override
    public List<CuaHang> getCuaHangs(Map<String, String> params) {
        return this.storeRepo.getCuaHangs(params);
    }

    @Override
    public CuaHang getCuaHangById(int id) {
        return this.storeRepo.getCuaHangById(id);
    }

    @Override
    public boolean deleteStore(int id) {
        return this.storeRepo.deleteStore(id);
    }

    @Override
    public CuaHang getCuaHangByUser(String username) {
        return this.storeRepo.getCuaHangByUser(username);
    }

    @Override
    public boolean addOrUpdateStore(CuaHang f) {
//        if (!f.getFile().isEmpty()) {
//            try {
//                Map res = this.cloudinary.uploader().upload(f.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
//                f.setImage(res.get("secure_url").toString());
//            } catch (IOException ex) {
//                Logger.getLogger(CuaHangServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } 
        return this.storeRepo.addOrUpdateStore(f);
    }
    
}
