/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hieu.repository.impl;

import com.hieu.pojo.NguoiDung;
import com.hieu.repository.UserRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Thao
 */
@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private BCryptPasswordEncoder passEncoder;

    @Override
    public NguoiDung getUserByUsername(String username) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM NguoiDung WHERE taiKhoan = :un");
        q.setParameter("un", username);

        return (NguoiDung) q.getSingleResult();
    }

    @Override
    public boolean authUser(String username, String password) {
        NguoiDung u = this.getUserByUsername(username);
        
        return this.passEncoder.matches(password, u.getMatKhau());
    }

    @Override
    public NguoiDung addUser(NguoiDung user) {
        Session s = this.factory.getObject().getCurrentSession();
        user.setActive(Boolean.TRUE);
        s.save(user);
        
        return user;
    }

    @Override
    public NguoiDung getUserById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(NguoiDung.class, id);
    }

    @Override
    public boolean UpdateUser(NguoiDung user) {
        Session s = this.factory.getObject().getCurrentSession();
        s.update(user);
        return true;
    }

    @Override
    public List<NguoiDung> getUsers() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM NguoiDung");
        
        return q.getResultList();
    }

}
