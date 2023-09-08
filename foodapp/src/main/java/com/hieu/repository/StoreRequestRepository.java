/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hieu.repository;

import com.hieu.pojo.StoreRequest;
import java.util.List;

/**
 *
 * @author Thao
 */
public interface StoreRequestRepository {
    StoreRequest addRequest(StoreRequest request);
    List<StoreRequest> getStoreReqs();
    StoreRequest getStoreReqById(int id);
    boolean deleteStoreReq(int id);
}
