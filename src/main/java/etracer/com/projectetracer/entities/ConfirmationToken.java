/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etracer.com.projectetracer.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Relion31
 */
@Entity
@Table(name = "confirmation_token")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConfirmationToken.findAll", query = "SELECT c FROM ConfirmationToken c")
    , @NamedQuery(name = "ConfirmationToken.findById", query = "SELECT c FROM ConfirmationToken c WHERE c.id = :id")
    , @NamedQuery(name = "ConfirmationToken.findByToken", query = "SELECT c FROM ConfirmationToken c WHERE c.token = :token")
    , @NamedQuery(name = "ConfirmationToken.findByCreateDate", query = "SELECT c FROM ConfirmationToken c WHERE c.createDate = :createDate")})
public class ConfirmationToken implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "token")
    private String token;
    @Basic(optional = false)
    @NotNull
    @Column(name = "create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @JoinColumn(name = "employeeId", referencedColumnName = "employeeId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employee employeeId;

    public ConfirmationToken() {
    }

    public ConfirmationToken(Integer id) {
        this.id = id;
    }

    public ConfirmationToken(Integer id, String token, Date createDate) {
        this.id = id;
        this.token = token;
        this.createDate = createDate;
    }
    
     public ConfirmationToken(Employee employeeId) {
        this.employeeId = employeeId;
        createDate = new Date();
        token = UUID.randomUUID().toString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
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
        if (!(object instanceof ConfirmationToken)) {
            return false;
        }
        ConfirmationToken other = (ConfirmationToken) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "etracer.com.projectetracer.entities.ConfirmationToken[ id=" + id + " ]";
    }
    
}
