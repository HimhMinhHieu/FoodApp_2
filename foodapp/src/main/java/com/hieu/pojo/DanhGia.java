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
@Table(name = "danh_gia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DanhGia.findAll", query = "SELECT d FROM DanhGia d"),
    @NamedQuery(name = "DanhGia.findById", query = "SELECT d FROM DanhGia d WHERE d.id = :id"),
    @NamedQuery(name = "DanhGia.findByNoiDung", query = "SELECT d FROM DanhGia d WHERE d.noiDung = :noiDung"),
    @NamedQuery(name = "DanhGia.findByDanhGia", query = "SELECT d FROM DanhGia d WHERE d.danhGia = :danhGia"),
    @NamedQuery(name = "DanhGia.findByCreatedDate", query = "SELECT d FROM DanhGia d WHERE d.createdDate = :createdDate")})
public class DanhGia implements Serializable {

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
    @JoinColumn(name = "id_cua_hang", referencedColumnName = "id")
    @ManyToOne
    private CuaHang idCuaHang;
    @JoinColumn(name = "id_nguoi_dung", referencedColumnName = "id")
    @ManyToOne
    private NguoiDung idNguoiDung;

    public DanhGia() {
    }

    public DanhGia(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public Integer getDanhGia() {
        return danhGia;
    }

    public void setDanhGia(Integer danhGia) {
        this.danhGia = danhGia;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public CuaHang getIdCuaHang() {
        return idCuaHang;
    }

    public void setIdCuaHang(CuaHang idCuaHang) {
        this.idCuaHang = idCuaHang;
    }

    public NguoiDung getIdNguoiDung() {
        return idNguoiDung;
    }

    public void setIdNguoiDung(NguoiDung idNguoiDung) {
        this.idNguoiDung = idNguoiDung;
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
        if (!(object instanceof DanhGia)) {
            return false;
        }
        DanhGia other = (DanhGia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hieu.pojo.DanhGia[ id=" + id + " ]";
    }
    
}
