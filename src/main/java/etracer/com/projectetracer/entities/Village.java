/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etracer.com.projectetracer.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Relion31
 */
@Entity
@Table(name = "village")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Village.findAll", query = "SELECT v FROM Village v")
    , @NamedQuery(name = "Village.findByVillageId", query = "SELECT v FROM Village v WHERE v.villageId = :villageId")
    , @NamedQuery(name = "Village.findByVillageName", query = "SELECT v FROM Village v WHERE v.villageName = :villageName")
    , @NamedQuery(name = "Village.findBySubDistrictId", query = "SELECT v FROM Village v WHERE v.subDistrictId = :subDistrictId")
    , @NamedQuery(name = "Village.findByIsDelete", query = "SELECT v FROM Village v WHERE v.isDelete = :isDelete")})
public class Village implements Serializable {

    @Basic(optional = false)
//    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "villageName")
    private String villageName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "subDistrictId")
    private String subDistrictId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "isDelete")
    private String isDelete;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "villageId", fetch = FetchType.LAZY)
    private List<Site> siteList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "villageId")
    private String villageId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "villageId", fetch = FetchType.LAZY)
    private List<Department> departmentList;

    public Village() {
    }

    public Village(String villageId) {
        this.villageId = villageId;
    }

    public Village(String villageId, String villageName, String subDistrictId, String isDelete) {
        this.villageId = villageId;
        this.villageName = villageName;
        this.subDistrictId = subDistrictId;
        this.isDelete = isDelete;
    }

    public String getVillageId() {
        return villageId;
    }

    public void setVillageId(String villageId) {
        this.villageId = villageId;
    }


    @XmlTransient
    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (villageId != null ? villageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Village)) {
            return false;
        }
        Village other = (Village) object;
        if ((this.villageId == null && other.villageId != null) || (this.villageId != null && !this.villageId.equals(other.villageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "etracer.com.projectetracer.entities.Village[ villageId=" + villageId + " ]";
    }


    @XmlTransient
    public List<Site> getSiteList() {
        return siteList;
    }

    public void setSiteList(List<Site> siteList) {
        this.siteList = siteList;
    }

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }

    public String getSubDistrictId() {
        return subDistrictId;
    }

    public void setSubDistrictId(String subDistrictId) {
        this.subDistrictId = subDistrictId;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }
    
}
