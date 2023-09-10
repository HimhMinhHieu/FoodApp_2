/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hieu.repository.impl;

import com.hieu.pojo.Cart;
import com.hieu.pojo.HoaDon;
import com.hieu.pojo.HoaDonChiTiet;
import com.hieu.pojo.NguoiDung;
import com.hieu.pojo.QuyDinhVanChuyen;
import com.hieu.repository.FoodRepository;
import com.hieu.repository.QuyDinhCuaHangRepository;
import com.hieu.repository.ReceiptRepository;
import com.hieu.repository.UserRepository;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Thao
 */
@Repository
@Transactional
public class ReceiptRepositoryImpl implements ReceiptRepository {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private FoodRepository foodRepo;
    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private QuyDinhCuaHangRepository ruleRepo;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean addReceipt(Map<String, Cart> carts) {

        Session s = this.factory.getObject().getCurrentSession();
        HoaDon order = new HoaDon();

        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            NguoiDung u = this.userRepo.getUserByUsername(authentication.getName());
            order.setIdNguoiDung(u);
            order.setCreatedDate(new Date());
//            order.setKhoangCach(Double.valueOf(params.get("khoangCach")));
//            order.
            s.save(order);

            for (Cart c : carts.values()) {
                HoaDonChiTiet d = new HoaDonChiTiet();
                d.setIdThucAn(this.foodRepo.getThucAnById(c.getId()));
                d.setIdHoaDon(order);
                d.setIdCuaHang(c.getIdCuaHang());
                d.setCreatedDate(new Date());
                d.setSoLuongMua(c.getQuantity());
                d.setTongTien(c.getUnitPrice());

                order.setIdCuaHang(c.getIdCuaHang());

                s.save(d);
                s.update(order);
            }
            Query q = s.createQuery("SELECT SUM(tongTien) FROM HoaDonChiTiet WHERE idHoaDon.id = :o");
            q.setParameter("o", order.getId());

            order.setTongTien(Long.parseLong(q.getSingleResult().toString()));
            s.update(order);

            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }

    }

    @Override
    public HoaDon getHoaDonLast() {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            Query q = s.createQuery("FROM HoaDon WHERE id=(SELECT MAX(id)FROM HoaDon)");
            return (HoaDon) q.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public List<HoaDon> getHoaDons() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM HoaDon");

        return q.getResultList();
    }

    @Override
    public List<HoaDon> chartMonth(Map<String, String> params, int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("SELECT SUM(tongTien), Month(createdDate) as Month FROM HoaDon WHERE idCuaHang.id = :id GROUP BY idCuaHang, Month(createdDate)");
        q.setParameter("id", id);
        if (params != null) {

            String m = params.get("m");
            if (m != null) {
                q = s.createQuery("SELECT SUM(tongTien), Month(createdDate) as Month FROM HoaDon WHERE MONTH(createdDate) = :m AND idCuaHang.id = :id GROUP BY idCuaHang, Month(createdDate)");
                q.setParameter("m", Integer.parseInt(m));
                q.setParameter("id", id);
                return q.getResultList();
            }
        } 
            
            return q.getResultList();
        
    }
}
