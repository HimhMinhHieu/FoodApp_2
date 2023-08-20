/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hieu.service;

import com.hieu.pojo.ThucAn;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Thao
 */
public interface FoodService {
    List<ThucAn> getThucAns(Map<String, String> params);
    List<ThucAn> getThucAnByCuaHang(int id);
    ThucAn getThucAnById(int id);
    boolean addOrUpdateFood(ThucAn f);
}
