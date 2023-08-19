/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hieu.service;

import com.hieu.pojo.CuaHang;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Thao
 */
public interface CuaHangService {

    List<CuaHang> getCuaHangs(Map<String, String> params);

    CuaHang getCuaHangById(int id);
}
