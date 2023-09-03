/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hieu.repository;

import com.hieu.pojo.CuaHang;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Thao
 */
public interface CuaHangRepository {
    List<CuaHang> getCuaHangs(Map<String, String> params);
    CuaHang getCuaHangById(int id);
    boolean deleteStore(int id);
    CuaHang getCuaHangByUser(String username);
}
