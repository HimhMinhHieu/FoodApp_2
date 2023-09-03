/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hieu.repository;

import com.hieu.pojo.Category;
import java.util.List;

/**
 *
 * @author Thao
 */
public interface CategoryRepository {
    List<Category> getCategorys();
    Category getCateById(int id);
}
