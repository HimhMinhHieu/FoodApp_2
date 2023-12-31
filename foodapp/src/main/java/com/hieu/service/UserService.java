/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hieu.service;

import com.hieu.pojo.NguoiDung;
import java.util.List;
import java.util.Map;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Thao
 */
public interface UserService extends UserDetailsService{
    NguoiDung getUserByUn(String username);
    boolean authUser(String username, String password);
    NguoiDung addUser(Map<String, String> params, MultipartFile avatar);
    NguoiDung getUserById(int id);
    boolean UpdateUser(NguoiDung user);
    List<NguoiDung> getUsers();
}
