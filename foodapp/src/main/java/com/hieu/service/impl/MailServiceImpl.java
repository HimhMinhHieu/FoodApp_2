/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hieu.service.impl;

import com.hieu.repository.MailRepository;
import com.hieu.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Thao
 */
@Service
public class MailServiceImpl implements MailService{
    @Autowired
    private MailRepository mailRepo;
    
    @Override
    public void sendMail(String email, String name) {
        this.mailRepo.sendMail(email, name);
    }

    @Override
    public void sendMailaddStoreWait(String email) {
        this.mailRepo.sendMailaddStoreWait(email);
    }

    @Override
    public void sendMailaddStore(String email) {
        this.mailRepo.sendMailaddStore(email);
    }

    @Override
    public void sendMaildeleteStore(String email) {
        this.mailRepo.sendMaildeleteStore(email);
    }

    @Override
    public void sendMailAddFood(String email, String name, String nameFood, String nameStore) {
        this.mailRepo.sendMailAddFood(email, name, nameFood, nameStore);
    }
}
