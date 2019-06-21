/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etracer.com.projectetracer.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Relion31
 */
@Entity
@Table(name = "sub_district")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubDistrict.findAll", query = "SELECT s FROM SubDistrict s")
    , @NamedQuery(name = "SubDistrict.findBySubDistrictId", query = "SELECT s FROM SubDistrict s WHERE s.subDistrictId = :subDistrictId")
    , @NamedQuery(name = "SubDistrict.findBySubDistrictName", query = "SELECT s FROM SubDistrict s WHERE s.subDistrictName = :subDistrictName")
    , @NamedQuery(name = "SubDistrict.findByIsDelete", query = "SELECT s FROM SubDistrict s WHERE s.isDelete = :isDelete")})
public class SubDistrict implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
//    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "subDistrictId")
    private String subDistrictId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "subDistrictName")
    private String subDistrictName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "isDelete")
    private String isDelete;
    @JoinColumn(name = "districtId", referencedColumnName = "districtId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private District districtId;

    public SubDistrict() {
    }

    public SubDistrict(String subDistrictId) {
        this.subDistrictId = subDistrictId;
    }

    public SubDistrict(String subDistrictId, String subDistrictName, String isDelete) {
        this.subDistrictId = subDistrictId;
        this.subDistrictName = subDistrictName;
        this.isDelete = isDelete;
    }

    public String getSubDistrictId() {
        return subDistrictId;
    }

    public void setSubDistrictId(String subDistrictId) {
        this.subDistrictId = subDistrictId;
    }

    public String getSubDistrictName() {
        return subDistrictName;
    }

    public void setSubDistrictName(String subDistrictName) {
        this.subDistrictName = subDistrictName;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public District getDistrictId() {
        return districtId;
    }

    public void setDistrictId(District districtId) {
        this.districtId = districtId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subDistrictId != null ? subDistrictId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubDistrict)) {
            return false;
        }
        SubDistrict other = (SubDistrict) object;
        if ((this.subDistrictId == null && other.subDistrictId != null) || (this.subDistrictId != null && !this.subDistrictId.equals(other.subDistrictId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "etracer.com.projectetracer.entities.SubDistrict[ subDistrictId=" + subDistrictId + " ]";
    }
    
}
