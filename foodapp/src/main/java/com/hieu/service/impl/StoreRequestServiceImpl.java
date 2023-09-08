/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hieu.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.hieu.pojo.StoreRequest;
import com.hieu.repository.StoreRequestRepository;
import com.hieu.service.StoreRequestService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Thao
 */
@Service
public class StoreRequestServiceImpl implements StoreRequestService{

    @Autowired
    private Cloudinary cloudinary;
    @Autowired
    private StoreRequestRepository storeRequestRepo;
    
    @Override
    public StoreRequest addRequest(StoreRequest request) {
        if (!request.getFile().isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(request.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                request.setImage(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(StoreRequestServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return this.storeRequestRepo.addRequest(request);
    }

    @Override
    public List<StoreRequest> getStoreReqs() {
        return this.storeRequestRepo.getStoreReqs();
    }

    @Override
    public StoreRequest getStoreReqById(int id) {
        return this.storeRequestRepo.getStoreReqById(id);
    }

    @Override
    public boolean deleteStoreReq(int id) {
        return this.storeRequestRepo.deleteStoreReq(id);
    }
    
}
