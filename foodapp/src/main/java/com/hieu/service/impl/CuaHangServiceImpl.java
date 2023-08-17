/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hieu.service.impl;

import com.hieu.pojo.CuaHang;
import com.hieu.repository.CuaHangRepository;
import com.hieu.service.CuaHangService;
import java.util.List;
import java.util.Map;
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
    
    @Override
    public List<CuaHang> getCuaHangs(Map<String, String> params) {
        return this.storeRepo.getCuaHangs(params);
    }
    
}
