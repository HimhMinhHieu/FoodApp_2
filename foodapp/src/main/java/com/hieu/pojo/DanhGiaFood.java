/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hieu.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Thao
 */
@Entity
@Table(name = "danh_gia_food")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DanhGiaFood.findAll", query = "SELECT d FROM DanhGiaFood d"),
    @NamedQuery(name = "DanhGiaFood.findById", query = "SELECT d FROM DanhGiaFood d WHERE d.id = :id"),
    @NamedQuery(name = "DanhGiaFood.findByNoiDung", query = "SELECT d FROM DanhGiaFood d WHERE d.noiDung = :noiDung"),
    @NamedQuery(name = "DanhGiaFood.findByDanhGia", query = "SELECT d FROM DanhGiaFood d WHERE d.danhGia = :danhGia"),
    @NamedQuery(name = "DanhGiaFood.findByCreatedDate", query = "SELECT d FROM DanhGiaFood d WHERE d.createdDate = :createdDate")})
public class DanhGiaFood implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "noi_dung")
    private String noiDung;
    @Column(name = "danh_gia")
    private Integer danhGia;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @JoinColumn(name = "id_thuc_an", referencedColumnName = "id")
    @ManyToOne
    private ThucAn idThucAn;
    @JoinColumn(name = "id_nguoi_dung", referencedColumnName = "id")
    @ManyToOne
    private NguoiDung idNguoiDung;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the noiDung
     */
    public String getNoiDung() {
        return noiDung;
    }

    /**
     * @param noiDung the noiDung to set
     */
    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    /**
     * @return the danhGia
     */
    public Integer getDanhGia() {
        return danhGia;
    }

    /**
     * @param danhGia the danhGia to set
     */
    public void setDanhGia(Integer danhGia) {
        this.danhGia = danhGia;
    }

    /**
     * @return the createdDate
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * @param createdDate the createdDate to set
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * @return the idThucAn
     */
    public ThucAn getIdThucAn() {
        return idThucAn;
    }

    /**
     * @param idThucAn the idThucAn to set
     */
    public void setIdThucAn(ThucAn idThucAn) {
        this.idThucAn = idThucAn;
    }

    /**
     * @return the idNguoiDung
     */
    public NguoiDung getIdNguoiDung() {
        return idNguoiDung;
    }

    /**
     * @param idNguoiDung the idNguoiDung to set
     */
    public void setIdNguoiDung(NguoiDung idNguoiDung) {
        this.idNguoiDung = idNguoiDung;
    }
}
