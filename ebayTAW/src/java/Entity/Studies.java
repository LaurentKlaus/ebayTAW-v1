/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mjura
 */
@Entity
@Table(name = "studies")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Studies.findAll", query = "SELECT s FROM Studies s")
    , @NamedQuery(name = "Studies.findByStudyID", query = "SELECT s FROM Studies s WHERE s.studyID = :studyID")})
public class Studies implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "studyID")
    private Integer studyID;
    @JoinColumn(name = "userID", referencedColumnName = "userID")
    @ManyToOne(optional = false)
    private Users userID;

    public Studies() {
    }

    public Studies(Integer studyID) {
        this.studyID = studyID;
    }

    public Integer getStudyID() {
        return studyID;
    }

    public void setStudyID(Integer studyID) {
        this.studyID = studyID;
    }

    public Users getUserID() {
        return userID;
    }

    public void setUserID(Users userID) {
        this.userID = userID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studyID != null ? studyID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Studies)) {
            return false;
        }
        Studies other = (Studies) object;
        if ((this.studyID == null && other.studyID != null) || (this.studyID != null && !this.studyID.equals(other.studyID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Studies[ studyID=" + studyID + " ]";
    }
    
}
