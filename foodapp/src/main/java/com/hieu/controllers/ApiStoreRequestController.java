/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hieu.controllers;

import com.hieu.pojo.StoreRequest;
import com.hieu.service.LoaiCuaHangService;
import com.hieu.service.MailService;
import com.hieu.service.StoreRequestService;
import com.hieu.service.UserService;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Thao
 */
@RestController
@RequestMapping("/api")
public class ApiStoreRequestController {
    @Autowired
    private StoreRequestService storeRequestServicer;
    @Autowired
    private UserService userService;
    @Autowired
    private LoaiCuaHangService storecateService;
    @Autowired
    private MailService mailService;
    
    @PostMapping(path = "/stores/request/", 
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, 
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    public void addRequest(@RequestParam Map<String, String> params, @RequestPart MultipartFile[] file) {
        StoreRequest sr = new StoreRequest();
        sr.setName(params.get("name"));
        sr.setDiaChi(params.get("diaChi"));
        sr.setCreatedDate(new Date());
        sr.setIdNguoiDung(this.userService.getUserById(Integer.parseInt(params.get("idNguoiDung"))));
        sr.setIdLoaiCuaHang(this.storecateService.getLoaiCuaHangById(Integer.parseInt(params.get("idLoaiCuaHang"))));
        sr.setGiaVanChuyen(Long.parseLong(params.get("giaVanChuyen")));
        if (file.length > 0) {
            sr.setFile(file[0]);
        }
        
        this.storeRequestServicer.addRequest(sr);
        mailService.sendMailaddStoreWait(sr.getIdNguoiDung().getEmail());
    }

}
