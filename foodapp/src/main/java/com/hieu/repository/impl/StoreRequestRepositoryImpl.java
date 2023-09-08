/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hieu.repository.impl;

import com.hieu.pojo.StoreRequest;
import com.hieu.repository.StoreRequestRepository;
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
public class StoreRequestRepositoryImpl implements StoreRequestRepository{

    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Override
    public StoreRequest addRequest(StoreRequest request) {
        Session s = this.factory.getObject().getCurrentSession();
        
        s.save(request);
        
        return request;
    }

    @Override
    public List<StoreRequest> getStoreReqs() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM StoreRequest");
        
        return q.getResultList();
    }

    @Override
    public StoreRequest getStoreReqById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(StoreRequest.class, id);
    }

    @Override
    public boolean deleteStoreReq(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        StoreRequest sr = this.getStoreReqById(id);
        try{
            s.delete(sr);
            return true;
        }catch(HibernateException ex)
        {
            ex.printStackTrace();
            return false;
        }
    }
    
}
