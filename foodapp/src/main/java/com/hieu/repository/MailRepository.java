/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hieu.repository;

/**
 *
 * @author Thao
 */
public interface MailRepository {
    void sendMail(String email, String name);
    void sendMailaddStoreWait(String email);
    void sendMailaddStore(String email);
    void sendMaildeleteStore(String email);
    void sendMailAddFood(String email, String name, String nameFood, String nameStore);
}
