/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hieu.service.impl;

import com.hieu.pojo.LoaiCuaHang;
import com.hieu.repository.LoaiCuaHangRepository;
import com.hieu.service.LoaiCuaHangService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Thao
 */
@Service
public class LoaiCuaHangServiceImpl implements LoaiCuaHangService {

    @Autowired
    private LoaiCuaHangRepository catestoreRepo;
    
    @Override
    public List<LoaiCuaHang> getLoaiCuaHangs() {
        return this.catestoreRepo.getLoaiCuaHangs();
    }

    @Override
    public LoaiCuaHang getLoaiCuaHangById(int id) {
        return this.catestoreRepo.getLoaiCuaHangById(id);
    }
    
}
