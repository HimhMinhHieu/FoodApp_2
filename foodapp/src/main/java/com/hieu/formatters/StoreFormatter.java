/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hieu.formatters;

import com.hieu.pojo.CuaHang;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Thao
 */
public class StoreFormatter implements Formatter<CuaHang>{

    @Override
    public String print(CuaHang store, Locale locale) {
        return String.valueOf(store.getId());
    }

    @Override
    public CuaHang parse(String storeId, Locale locale) throws ParseException {
        int id = Integer.parseInt(storeId);
        return new CuaHang(id);
    }
    
    
}
