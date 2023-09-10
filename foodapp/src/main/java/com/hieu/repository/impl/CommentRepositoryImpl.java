/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hieu.repository.impl;

import com.hieu.pojo.DanhGia;
import com.hieu.pojo.DanhGiaFood;
import com.hieu.repository.CommentRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.HibernateException;
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
public class CommentRepositoryImpl implements CommentRepository{
    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<DanhGia> getComments(int storeId) {
         Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("From DanhGia Where idCuaHang.id=:id");
        q.setParameter("id", storeId);
        
        return q.getResultList();
    }

    @Override
    public DanhGia addComment(DanhGia c) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            s.save(c);
            return c;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<DanhGiaFood> getCommentsFood(int foodId) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("From DanhGiaFood Where idThucAn.id=:id");
        q.setParameter("id", foodId);
        
        return q.getResultList();
    }

    @Override
    public DanhGiaFood addCommentFood(DanhGiaFood c) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            s.save(c);
            return c;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
}
