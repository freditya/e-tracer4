/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etracer.com.projectetracer.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Relion31
 */
@Entity
@Table(name = "report_problem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReportProblem.findAll", query = "SELECT r FROM ReportProblem r")
    , @NamedQuery(name = "ReportProblem.findByReportId", query = "SELECT r FROM ReportProblem r WHERE r.reportId = :reportId")
    , @NamedQuery(name = "ReportProblem.findByReportMessage", query = "SELECT r FROM ReportProblem r WHERE r.reportMessage = :reportMessage")
    , @NamedQuery(name = "ReportProblem.findByReportDate", query = "SELECT r FROM ReportProblem r WHERE r.reportDate = :reportDate")
    , @NamedQuery(name = "ReportProblem.findByIsDelete", query = "SELECT r FROM ReportProblem r WHERE r.isDelete = :isDelete")})
public class ReportProblem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
//    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "reportId")
    private String reportId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "reportMessage")
    private String reportMessage;
    @Basic(optional = false)
    @NotNull
    @Column(name = "reportDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reportDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "isDelete")
    private String isDelete;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reportId", fetch = FetchType.LAZY)
    private List<RespondProblem> respondProblemList;
    @JoinColumn(name = "employeeId", referencedColumnName = "employeeId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employee employeeId;

    public ReportProblem() {
    }

    public ReportProblem(String reportId) {
        this.reportId = reportId;
    }

    public ReportProblem(String reportId, String reportMessage, Date reportDate, String isDelete) {
        this.reportId = reportId;
        this.reportMessage = reportMessage;
        this.reportDate = reportDate;
        this.isDelete = isDelete;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getReportMessage() {
        return reportMessage;
    }

    public void setReportMessage(String reportMessage) {
        this.reportMessage = reportMessage;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    @XmlTransient
    public List<RespondProblem> getRespondProblemList() {
        return respondProblemList;
    }

    public void setRespondProblemList(List<RespondProblem> respondProblemList) {
        this.respondProblemList = respondProblemList;
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
        hash += (reportId != null ? reportId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReportProblem)) {
            return false;
        }
        ReportProblem other = (ReportProblem) object;
        if ((this.reportId == null && other.reportId != null) || (this.reportId != null && !this.reportId.equals(other.reportId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "etracer.com.projectetracer.entities.ReportProblem[ reportId=" + reportId + " ]";
    }
    
}
