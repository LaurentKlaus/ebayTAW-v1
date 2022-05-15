/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import DTO.FollowbidsDTO;
import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 34637
 */
@Entity
@Table(name = "followbids")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Followbids.findAll", query = "SELECT f FROM Followbids f")
    , @NamedQuery(name = "Followbids.findByFollowBidID", query = "SELECT f FROM Followbids f WHERE f.followBidID = :followBidID")})
public class Followbids implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "followBidID")
    private Integer followBidID;
    @JoinColumn(name = "bidID", referencedColumnName = "bidID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Bids bidID;
    @JoinColumn(name = "userID", referencedColumnName = "userID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Users userID;

    public Followbids() {
    }

    public Followbids(Integer followBidID) {
        this.followBidID = followBidID;
    }

    public Integer getFollowBidID() {
        return followBidID;
    }

    public void setFollowBidID(Integer followBidID) {
        this.followBidID = followBidID;
    }

    public Bids getBidID() {
        return bidID;
    }

    public void setBidID(Bids bidID) {
        this.bidID = bidID;
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
        hash += (followBidID != null ? followBidID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Followbids)) {
            return false;
        }
        Followbids other = (Followbids) object;
        if ((this.followBidID == null && other.followBidID != null) || (this.followBidID != null && !this.followBidID.equals(other.followBidID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Followbids[ followBidID=" + followBidID + " ]";
    }
    
    public FollowbidsDTO toDTO() {
        FollowbidsDTO dto = new FollowbidsDTO();
        
        dto.setFollowBidID(followBidID);
        dto.setBidID(bidID);
        dto.setUserID(userID);
        
        return dto;
    }
}
