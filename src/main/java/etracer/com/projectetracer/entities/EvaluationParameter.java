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
@Table(name = "evaluation_parameter")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EvaluationParameter.findAll", query = "SELECT e FROM EvaluationParameter e")
    , @NamedQuery(name = "EvaluationParameter.findByEvaluationId", query = "SELECT e FROM EvaluationParameter e WHERE e.evaluationId = :evaluationId")
    , @NamedQuery(name = "EvaluationParameter.findByEvaluationName", query = "SELECT e FROM EvaluationParameter e WHERE e.evaluationName = :evaluationName")
    , @NamedQuery(name = "EvaluationParameter.findByIsDelete", query = "SELECT e FROM EvaluationParameter e WHERE e.isDelete = :isDelete")})
public class EvaluationParameter implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
//    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "evaluationId")
    private String evaluationId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "evaluationName")
    private String evaluationName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "isDelete")
    private String isDelete;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaluationId", fetch = FetchType.LAZY)
    private List<Score> scoreList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaluationId", fetch = FetchType.LAZY)
    private List<Category> categoryList;

    public EvaluationParameter() {
    }

    public EvaluationParameter(String evaluationId) {
        this.evaluationId = evaluationId;
    }

    public EvaluationParameter(String evaluationId, String evaluationName, String isDelete) {
        this.evaluationId = evaluationId;
        this.evaluationName = evaluationName;
        this.isDelete = isDelete;
    }

    public String getEvaluationId() {
        return evaluationId;
    }

    public void setEvaluationId(String evaluationId) {
        this.evaluationId = evaluationId;
    }

    public String getEvaluationName() {
        return evaluationName;
    }

    public void setEvaluationName(String evaluationName) {
        this.evaluationName = evaluationName;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    @XmlTransient
    public List<Score> getScoreList() {
        return scoreList;
    }

    public void setScoreList(List<Score> scoreList) {
        this.scoreList = scoreList;
    }

    @XmlTransient
    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (evaluationId != null ? evaluationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaluationParameter)) {
            return false;
        }
        EvaluationParameter other = (EvaluationParameter) object;
        if ((this.evaluationId == null && other.evaluationId != null) || (this.evaluationId != null && !this.evaluationId.equals(other.evaluationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "etracer.com.projectetracer.entities.EvaluationParameter[ evaluationId=" + evaluationId + " ]";
    }
    
}
