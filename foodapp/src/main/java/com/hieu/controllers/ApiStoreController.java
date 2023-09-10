/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hieu.controllers;

import com.hieu.pojo.CuaHang;
import com.hieu.pojo.DanhGia;
import com.hieu.pojo.NguoiDung;
import com.hieu.pojo.StoreRequest;
import com.hieu.pojo.ThucAn;
import com.hieu.service.CommentService;
import com.hieu.service.CuaHangService;
import com.hieu.service.FoodService;
import com.hieu.service.MailService;
import com.hieu.service.StoreRequestService;
import com.hieu.service.UserService;
import java.security.Principal;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Chung Vu
 */
@RestController
@RequestMapping("/api")
public class ApiStoreController {
    @Autowired
    private CuaHangService storeService;
    @Autowired
    private FoodService foodService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private StoreRequestService storeReqService;
    @Autowired
    private UserService userService;
    @Autowired
    private MailService mailService;
    
    @GetMapping("/stores/")
    @CrossOrigin
    public ResponseEntity<List<CuaHang>> list(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.storeService.getCuaHangs(params), HttpStatus.OK);
    }
    
    @GetMapping(path = "/current-user/stores/details/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<CuaHang> detailsStore(Principal user) {
        CuaHang s = this.storeService.getCuaHangByUser(user.getName());
        return new ResponseEntity<>(s, HttpStatus.OK);
    }
    
    @DeleteMapping("/stores/{id}/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFood(@PathVariable(value = "id") int id)
    {
        List<ThucAn> food = this.foodService.getThucAnByCuaHang(id);
        if(food != null)
        {
            this.foodService.deleteAllFood(id);
        }
        
        this.storeService.deleteStore(id);
    }
    
    @PostMapping("/stores/request/{id}/")
    @ResponseStatus(HttpStatus.CREATED)
    public void addStore(@PathVariable(value = "id") int id)
    {
        StoreRequest sr = this.storeReqService.getStoreReqById(id);
        NguoiDung user = this.userService.getUserById(sr.getIdNguoiDung().getId());
        CuaHang s = new CuaHang();
        s.setName(sr.getName());
        s.setDiaChi(sr.getDiaChi());
        s.setImage(sr.getImage());
        s.setCreatedDate(sr.getCreatedDate());
        s.setIdNguoiDung(sr.getIdNguoiDung());
        s.setIdLoaiCuaHang(sr.getIdLoaiCuaHang());
        s.setGiaVanChuyen(sr.getGiaVanChuyen());
        user.setVaiTro("owner");
        this.storeService.addOrUpdateStore(s);
        this.userService.UpdateUser(user);
        this.storeReqService.deleteStoreReq(id);
        mailService.sendMailaddStore(user.getEmail());
    }
    
    @DeleteMapping("/stores/request/{id}/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReq(@PathVariable(value = "id") int id) {
        StoreRequest sr = this.storeReqService.getStoreReqById(id);
        mailService.sendMaildeleteStore(sr.getIdNguoiDung().getEmail());
        this.storeReqService.deleteStoreReq(id);  
    }
    
    @GetMapping("/stores/{storeId}/comments/")
    @CrossOrigin
    public ResponseEntity<List<DanhGia>> listComments(@PathVariable(value = "storeId") int id) {
        return new ResponseEntity<>(this.commentService.getComments(id), HttpStatus.OK);
    }
    
    @PostMapping(path="/comments/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<DanhGia> addComment(@RequestBody DanhGia comment) {
        DanhGia c = this.commentService.addComment(comment);
        
        return new ResponseEntity<>(c, HttpStatus.CREATED);
    }
}
