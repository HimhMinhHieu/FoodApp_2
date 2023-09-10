/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hieu.service.impl;

import com.hieu.pojo.QuyDinhVanChuyen;
import com.hieu.repository.QuyDinhCuaHangRepository;
import com.hieu.service.QuyDinhCuaHangService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Thao
 */
@Service
public class QuyDinhCuaHangServiceImpl implements QuyDinhCuaHangService{

    @Autowired
    private QuyDinhCuaHangRepository ruleRepo;
    
    @Override
    public List<QuyDinhVanChuyen> ruleStore(int id) {
        return this.ruleRepo.ruleStore(id);
    }
    
}
