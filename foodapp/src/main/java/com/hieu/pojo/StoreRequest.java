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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Thao
 */
@Entity
@Table(name = "store_request")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StoreRequest.findAll", query = "SELECT c FROM StoreRequest c"),
    @NamedQuery(name = "StoreRequest.findById", query = "SELECT c FROM StoreRequest c WHERE c.id = :id"),
    @NamedQuery(name = "StoreRequest.findByName", query = "SELECT c FROM StoreRequest c WHERE c.name = :name"),
    @NamedQuery(name = "StoreRequest.findByDiaChi", query = "SELECT c FROM StoreRequest c WHERE c.diaChi = :diaChi"),
    @NamedQuery(name = "StoreRequest.findByImage", query = "SELECT c FROM StoreRequest c WHERE c.image = :image"),
    @NamedQuery(name = "StoreRequest.findByCreatedDate", query = "SELECT c FROM StoreRequest c WHERE c.createdDate = :createdDate")})
public class StoreRequest implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "dia_chi")
    private String diaChi;
    @Size(max = 255)
    @Column(name = "image")
    private String image;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @JoinColumn(name = "id_nguoi_dung", referencedColumnName = "id")
    @ManyToOne
    
    private NguoiDung idNguoiDung;
    
    @JoinColumn(name = "id_loai_cua_hang", referencedColumnName = "id")
    @ManyToOne
    
    private LoaiCuaHang idLoaiCuaHang;
    
    @Transient
    private MultipartFile file;
    
    public StoreRequest() {
    }

    public StoreRequest(Integer id) {
        this.id = id;
    }

    public StoreRequest(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the diaChi
     */
    public String getDiaChi() {
        return diaChi;
    }

    /**
     * @param diaChi the diaChi to set
     */
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
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

    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
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
        if (!(object instanceof StoreRequest)) {
            return false;
        }
        StoreRequest other = (StoreRequest) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hieu.pojo.StoreRequest[ id=" + id + " ]";
    }

    /**
     * @return the idLoaiCuaHang
     */
    public LoaiCuaHang getIdLoaiCuaHang() {
        return idLoaiCuaHang;
    }

    /**
     * @param idLoaiCuaHang the idLoaiCuaHang to set
     */
    public void setIdLoaiCuaHang(LoaiCuaHang idLoaiCuaHang) {
        this.idLoaiCuaHang = idLoaiCuaHang;
    }
}
