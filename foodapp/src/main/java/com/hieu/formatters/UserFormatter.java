/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hieu.formatters;

import com.hieu.pojo.NguoiDung;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Thao
 */
public class UserFormatter implements Formatter<NguoiDung>{

    @Override
    public String print(NguoiDung u, Locale locale) {
        return String.valueOf(u.getId());
    }

    @Override
    public NguoiDung parse(String uId, Locale locale) throws ParseException {
        int id = Integer.parseInt(uId);
        return new NguoiDung(id);
    }
    
}
