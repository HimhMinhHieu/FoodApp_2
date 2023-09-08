/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hieu.repository;

import com.hieu.pojo.NguoiDung;
import java.util.List;

/**
 *
 * @author Thao
 */
public interface UserRepository {
    NguoiDung getUserByUsername(String username);
    boolean authUser(String username, String password);
    NguoiDung addUser(NguoiDung user);
    NguoiDung getUserById(int id);
    boolean UpdateUser(NguoiDung user);
    List<NguoiDung> getUsers();
}
