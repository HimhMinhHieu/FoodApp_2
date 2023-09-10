/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hieu.repository.impl;

import com.hieu.pojo.QuyDinhVanChuyen;
import com.hieu.repository.QuyDinhCuaHangRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Thao
 */
@Repository
@Transactional
public class QuyDinhCuaHangRepositoryImpl implements QuyDinhCuaHangRepository{

    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Override
    public List<QuyDinhVanChuyen> ruleStore(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM QuyDinhVanChuyen WHERE idCuaHang = :id");
        q.setParameter("id", id);

        return q.getResultList();
    }
    
}
