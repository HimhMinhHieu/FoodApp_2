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
@Table(name = "cua_hang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CuaHang.findAll", query = "SELECT c FROM CuaHang c"),
    @NamedQuery(name = "CuaHang.findById", query = "SELECT c FROM CuaHang c WHERE c.id = :id"),
    @NamedQuery(name = "CuaHang.findByName", query = "SELECT c FROM CuaHang c WHERE c.name = :name"),
    @NamedQuery(name = "CuaHang.findByDiaChi", query = "SELECT c FROM CuaHang c WHERE c.diaChi = :diaChi"),
    @NamedQuery(name = "CuaHang.findByImage", query = "SELECT c FROM CuaHang c WHERE c.image = :image"),
    @NamedQuery(name = "CuaHang.findByCreatedDate", query = "SELECT c FROM CuaHang c WHERE c.createdDate = :createdDate")})
public class CuaHang implements Serializable {

//    @Column(name = "gia_van_chuyen")
//    private Long giaVanChuyen;
    @OneToMany(mappedBy = "idCuaHang")
    @JsonIgnore
    private Set<QuyDinhVanChuyen> quyDinhVanChuyenSet;

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
    @OneToMany(mappedBy = "idCuaHang")
    @JsonIgnore
    private Set<ThucAn> thucAnSet;
    @OneToMany(mappedBy = "idCuaHang")
    @JsonIgnore
    private Set<DanhGia> danhGiaSet;
    @JoinColumn(name = "id_loai_cua_hang", referencedColumnName = "id")
    @ManyToOne
    
    private LoaiCuaHang idLoaiCuaHang;
    @JoinColumn(name = "id_nguoi_dung", referencedColumnName = "id")
    @ManyToOne
    
    private NguoiDung idNguoiDung;
    
    @Basic(optional = false)
    @Column(name = "gia_van_chuyen")
    private long giaVanChuyen;
    
    @Transient
    private MultipartFile file;


    public CuaHang() {
    }

    public CuaHang(Integer id) {
        this.id = id;
    }

    public CuaHang(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
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

    @XmlTransient
    public Set<ThucAn> getThucAnSet() {
        return thucAnSet;
    }

    public void setThucAnSet(Set<ThucAn> thucAnSet) {
        this.thucAnSet = thucAnSet;
    }

    @XmlTransient
    public Set<DanhGia> getDanhGiaSet() {
        return danhGiaSet;
    }

    public void setDanhGiaSet(Set<DanhGia> danhGiaSet) {
        this.danhGiaSet = danhGiaSet;
    }

    public LoaiCuaHang getIdLoaiCuaHang() {
        return idLoaiCuaHang;
    }

    public void setIdLoaiCuaHang(LoaiCuaHang idLoaiCuaHang) {
        this.idLoaiCuaHang = idLoaiCuaHang;
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
        if (!(object instanceof CuaHang)) {
            return false;
        }
        CuaHang other = (CuaHang) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hieu.pojo.CuaHang[ id=" + id + " ]";
    }

//    public Long getGiaVanChuyen() {
//        return giaVanChuyen;
//    }
//
//    public void setGiaVanChuyen(Long giaVanChuyen) {
//        this.giaVanChuyen = giaVanChuyen;
//    }

    @XmlTransient
    public Set<QuyDinhVanChuyen> getQuyDinhVanChuyenSet() {
        return quyDinhVanChuyenSet;
    }

    public void setQuyDinhVanChuyenSet(Set<QuyDinhVanChuyen> quyDinhVanChuyenSet) {
        this.quyDinhVanChuyenSet = quyDinhVanChuyenSet;
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

    /**
     * @return the giaVanChuyen
     */
    public long getGiaVanChuyen() {
        return giaVanChuyen;
    }

    /**
     * @param giaVanChuyen the giaVanChuyen to set
     */
    public void setGiaVanChuyen(long giaVanChuyen) {
        this.giaVanChuyen = giaVanChuyen;
    }
    
}
