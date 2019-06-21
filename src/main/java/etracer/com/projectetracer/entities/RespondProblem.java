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
@Table(name = "respond_problem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RespondProblem.findAll", query = "SELECT r FROM RespondProblem r")
    , @NamedQuery(name = "RespondProblem.findByRespondId", query = "SELECT r FROM RespondProblem r WHERE r.respondId = :respondId")
    , @NamedQuery(name = "RespondProblem.findByRespondMessage", query = "SELECT r FROM RespondProblem r WHERE r.respondMessage = :respondMessage")
    , @NamedQuery(name = "RespondProblem.findByIsDelete", query = "SELECT r FROM RespondProblem r WHERE r.isDelete = :isDelete")})
public class RespondProblem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
//    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "respondId")
    private String respondId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "respondMessage")
    private String respondMessage;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "isDelete")
    private String isDelete;
    @JoinColumn(name = "reportId", referencedColumnName = "reportId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ReportProblem reportId;
    @JoinColumn(name = "employeeId", referencedColumnName = "employeeId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employee employeeId;

    public RespondProblem() {
    }

    public RespondProblem(String respondId) {
        this.respondId = respondId;
    }

    public RespondProblem(String respondId, String respondMessage, String isDelete) {
        this.respondId = respondId;
        this.respondMessage = respondMessage;
        this.isDelete = isDelete;
    }

    public String getRespondId() {
        return respondId;
    }

    public void setRespondId(String respondId) {
        this.respondId = respondId;
    }

    public String getRespondMessage() {
        return respondMessage;
    }

    public void setRespondMessage(String respondMessage) {
        this.respondMessage = respondMessage;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public ReportProblem getReportId() {
        return reportId;
    }

    public void setReportId(ReportProblem reportId) {
        this.reportId = reportId;
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
        hash += (respondId != null ? respondId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RespondProblem)) {
            return false;
        }
        RespondProblem other = (RespondProblem) object;
        if ((this.respondId == null && other.respondId != null) || (this.respondId != null && !this.respondId.equals(other.respondId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "etracer.com.projectetracer.entities.RespondProblem[ respondId=" + respondId + " ]";
    }
    
}
