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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Thao
 */
@Entity
@Table(name = "hoa_don_chi_tiet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HoaDonChiTiet.findAll", query = "SELECT h FROM HoaDonChiTiet h"),
    @NamedQuery(name = "HoaDonChiTiet.findById", query = "SELECT h FROM HoaDonChiTiet h WHERE h.id = :id"),
    @NamedQuery(name = "HoaDonChiTiet.findBySoLuongMua", query = "SELECT h FROM HoaDonChiTiet h WHERE h.soLuongMua = :soLuongMua"),
    @NamedQuery(name = "HoaDonChiTiet.findByGiaVanChuyen", query = "SELECT h FROM HoaDonChiTiet h WHERE h.giaVanChuyen = :giaVanChuyen"),
    @NamedQuery(name = "HoaDonChiTiet.findByTongTien", query = "SELECT h FROM HoaDonChiTiet h WHERE h.tongTien = :tongTien"),
    @NamedQuery(name = "HoaDonChiTiet.findByCreatedDate", query = "SELECT h FROM HoaDonChiTiet h WHERE h.createdDate = :createdDate")})
public class HoaDonChiTiet implements Serializable {

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "khoang_cach")
    private Double khoangCach;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "so_luong_mua")
    private int soLuongMua;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gia_van_chuyen")
    private long giaVanChuyen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tong_tien")
    private long tongTien;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @JoinColumn(name = "id_hoa_don", referencedColumnName = "id")
    @ManyToOne
    private HoaDon idHoaDon;
    @JoinColumn(name = "id_thuc_an", referencedColumnName = "id")
    @ManyToOne
    private ThucAn idThucAn;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(Integer id) {
        this.id = id;
    }

    public HoaDonChiTiet(Integer id, int soLuongMua, long giaVanChuyen, long tongTien) {
        this.id = id;
        this.soLuongMua = soLuongMua;
        this.giaVanChuyen = giaVanChuyen;
        this.tongTien = tongTien;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getSoLuongMua() {
        return soLuongMua;
    }

    public void setSoLuongMua(int soLuongMua) {
        this.soLuongMua = soLuongMua;
    }

    public long getGiaVanChuyen() {
        return giaVanChuyen;
    }

    public void setGiaVanChuyen(long giaVanChuyen) {
        this.giaVanChuyen = giaVanChuyen;
    }

    public long getTongTien() {
        return tongTien;
    }

    public void setTongTien(long tongTien) {
        this.tongTien = tongTien;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public HoaDon getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(HoaDon idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public ThucAn getIdThucAn() {
        return idThucAn;
    }

    public void setIdThucAn(ThucAn idThucAn) {
        this.idThucAn = idThucAn;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HoaDonChiTiet)) {
            return false;
        }
        HoaDonChiTiet other = (HoaDonChiTiet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hieu.pojo.HoaDonChiTiet[ id=" + id + " ]";
    }

    public Double getKhoangCach() {
        return khoangCach;
    }

    public void setKhoangCach(Double khoangCach) {
        this.khoangCach = khoangCach;
    }
    
}
