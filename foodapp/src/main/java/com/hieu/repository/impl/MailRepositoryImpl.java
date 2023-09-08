/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hieu.repository.impl;

import com.hieu.repository.MailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Thao
 */
@Repository
@Transactional
public class MailRepositoryImpl implements MailRepository{
    @Autowired
    private JavaMailSender javaMailSender;
    
    @Override
    public void sendMail(String email, String name) {
        SimpleMailMessage newEmail =  new SimpleMailMessage();
        newEmail.setTo(email);
        newEmail.setSubject(name + " oi! Ban da dang ky nguoi dung thanh cong");
        newEmail.setText("Chuc mung "  + name + " da dang ky thanh cong tai khoan, \nChuc ban co mot trai nghiem vui ve tai FoodApp");
        
        javaMailSender.send(newEmail);
    }

    @Override
    public void sendMailaddStoreWait(String email) {
        SimpleMailMessage newEmail =  new SimpleMailMessage();
        newEmail.setTo(email);
        newEmail.setSubject("Nhan yeu cau tu nguoi dung");
        newEmail.setText("He thong da gui yeu cau ve phia quan tri xin vui long cho doi, \nChuc ban co mot trai nghiem vui ve tai FoodApp");
        
        javaMailSender.send(newEmail);
    }

    @Override
    public void sendMailaddStore(String email) {
        SimpleMailMessage newEmail =  new SimpleMailMessage();
        newEmail.setTo(email);
        newEmail.setSubject("Duyet");
        newEmail.setText("Quan tri vien da duyet yeu cau cua ban,\nXin vui long dang xuat va dang nhap lai khi thay email nay, \nChuc ban co mot trai nghiem vui ve tai FoodApp");
        
        javaMailSender.send(newEmail);
    }

    @Override
    public void sendMaildeleteStore(String email) {
        SimpleMailMessage newEmail =  new SimpleMailMessage();
        newEmail.setTo(email);
        newEmail.setSubject("Tu Choi");
        newEmail.setText("Quan tri vien da tu choi yeu cau cua ban,\nYeu cau cua ban khong phu hop voi he thong, \nChuc ban co mot trai nghiem vui ve tai FoodApp");
        
        javaMailSender.send(newEmail);
    }

    @Override
    public void sendMailAddFood(String email, String name, String nameFood, String nameStore) {
        SimpleMailMessage newEmail =  new SimpleMailMessage();
        newEmail.setTo(email);
        newEmail.setSubject("Chao "+ name + " !");
        newEmail.setText("Cua Hang " + nameStore + " da dang san pham moi co ten " + nameFood + " roi kia, \nHay mau nhanh chan huong thuc di nao");
        
        javaMailSender.send(newEmail);
    }
    
}
