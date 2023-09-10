/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hieu.repository;

import com.hieu.pojo.Cart;
import com.hieu.pojo.HoaDon;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Thao
 */
public interface ReceiptRepository {
    boolean addReceipt(Map<String, Cart> carts);
    HoaDon getHoaDonLast();
    List<HoaDon> getHoaDons();
    List<HoaDon> chartMonth(Map<String, String> params, int id);
}
