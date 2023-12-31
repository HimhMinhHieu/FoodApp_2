/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hieu.service;

import com.hieu.pojo.DanhGia;
import com.hieu.pojo.DanhGiaFood;
import java.util.List;

/**
 *
 * @author Thao
 */
public interface CommentService {
    List<DanhGia> getComments(int storeId);
    DanhGia addComment(DanhGia c);
    
    List<DanhGiaFood> getCommentsFood(int foodId);
    DanhGiaFood addCommentFood(DanhGiaFood c);
}
