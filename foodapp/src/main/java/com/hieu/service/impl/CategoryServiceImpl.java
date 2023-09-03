/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hieu.service.impl;

import com.hieu.pojo.Category;
import com.hieu.repository.CategoryRepository;
import com.hieu.service.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Thao
 */
@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository cateRepo;

    @Override
    public List<Category> getCategorys() {
        return this.cateRepo.getCategorys();
    }

    @Override
    public Category getCateById(int id) {
        return this.cateRepo.getCateById(id);
    }
    
    
}
