/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hieu.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Thao
 */
@Entity
@Table(name = "thuc_an")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ThucAn.findAll", query = "SELECT t FROM ThucAn t"),
    @NamedQuery(name = "ThucAn.findById", query = "SELECT t FROM ThucAn t WHERE t.id = :id"),
    @NamedQuery(name = "ThucAn.findByName", query = "SELECT t FROM ThucAn t WHERE t.name = :name"),
    @NamedQuery(name = "ThucAn.findBySoLuong", query = "SELECT t FROM ThucAn t WHERE t.soLuong = :soLuong"),
    @NamedQuery(name = "ThucAn.findByPrice", query = "SELECT t FROM ThucAn t WHERE t.price = :price"),
    @NamedQuery(name = "ThucAn.findByImage", query = "SELECT t FROM ThucAn t WHERE t.image = :image"),
    @NamedQuery(name = "ThucAn.findByCreatedDate", query = "SELECT t FROM ThucAn t WHERE t.createdDate = :createdDate")})
public class ThucAn implements Serializable {

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

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull(message = "{food.name.notNullMsg}")
    @Size(min = 1, max = 45, message = "{food.name.lenErr}")
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull(message = "{food.amout.notNull}")
    @Column(name = "so_luong")
    private int soLuong;
    @Basic(optional = false)
    @NotNull(message = "{food.price.notNull}")
    @Column(name = "price")
    private long price;
    @Size(max = 255)
    @Column(name = "image")
    private String image;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @JoinColumn(name = "id_loai", referencedColumnName = "id")
    @ManyToOne
    @JsonIgnore
    private Category idLoai;
    @JoinColumn(name = "id_cua_hang", referencedColumnName = "id")
    @ManyToOne
    @JsonIgnore
    private CuaHang idCuaHang;
    @OneToMany(mappedBy = "idThucAn")
    @JsonIgnore
    private Set<HoaDonChiTiet> hoaDonChiTietSet;
    @Transient
    private MultipartFile file;

    public ThucAn() {
    }

    public ThucAn(Integer id) {
        this.id = id;
    }

    public ThucAn(Integer id, String name, int soLuong, long price) {
        this.id = id;
        this.name = name;
        this.soLuong = soLuong;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Category getIdLoai() {
        return idLoai;
    }

    public void setIdLoai(Category idLoai) {
        this.idLoai = idLoai;
    }

    public CuaHang getIdCuaHang() {
        return idCuaHang;
    }

    public void setIdCuaHang(CuaHang idCuaHang) {
        this.idCuaHang = idCuaHang;
    }

    @XmlTransient
    public Set<HoaDonChiTiet> getHoaDonChiTietSet() {
        return hoaDonChiTietSet;
    }

    public void setHoaDonChiTietSet(Set<HoaDonChiTiet> hoaDonChiTietSet) {
        this.hoaDonChiTietSet = hoaDonChiTietSet;
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
        if (!(object instanceof ThucAn)) {
            return false;
        }
        ThucAn other = (ThucAn) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hieu.pojo.ThucAn[ id=" + id + " ]";
    }
    
}
