/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hieu.service.impl;

import com.hieu.pojo.Cart;
import com.hieu.pojo.HoaDon;
import com.hieu.repository.ReceiptRepository;
import com.hieu.service.ReceiptService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Thao
 */
@Service
public class ReceiptServiceImpl implements ReceiptService{
    @Autowired
    private ReceiptRepository receiptRepo;

    @Override
    public boolean addReceipt(Map<String, Cart> carts) {
        return this.receiptRepo.addReceipt(carts);
    }

    @Override
    public HoaDon getHoaDonLast() {
        return this.receiptRepo.getHoaDonLast();
    }

    @Override
    public List<HoaDon> getHoaDons() {
        return this.receiptRepo.getHoaDons();
    }

    @Override
    public List<HoaDon> chartMonth(Map<String, String> params, int id) {
        return this.receiptRepo.chartMonth(params, id);
    }
}
