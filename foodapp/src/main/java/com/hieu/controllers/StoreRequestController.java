/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hieu.controllers;

import com.hieu.service.StoreRequestService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Thao
 */
@Controller
public class StoreRequestController {
    @Autowired
    private StoreRequestService storeReqService;
    
    @GetMapping("/stores/request")
    public String storerequest(Model model) {
        model.addAttribute("req", this.storeReqService.getStoreReqs());
        return "signupstores";
    }
    

}
