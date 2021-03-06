/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import DTO.BidsDTO;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mjura
 */
@Entity
@Table(name = "bids")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bids.findAll", query = "SELECT b FROM Bids b")
    , @NamedQuery(name = "Bids.findByBidID", query = "SELECT b FROM Bids b WHERE b.bidID = :bidID")})
public class Bids implements Serializable {

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "priceBid")
    private BigDecimal priceBid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bidID", fetch = FetchType.LAZY)
    private List<Followbids> followbidsList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bidID")
    private Integer bidID;
    @JoinColumn(name = "productID", referencedColumnName = "productID")
    @ManyToOne(optional = false)
    private Products productID;
    @JoinColumn(name = "userID", referencedColumnName = "userID")
    @ManyToOne(optional = false)
    private Users userID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private BigDecimal price;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Bids() {
    }

    public Bids(Integer bidID) {
        this.bidID = bidID;
    }

    public Integer getBidID() {
        return bidID;
    }

    public void setBidID(Integer bidID) {
        this.bidID = bidID;
    }

    public Products getProductID() {
        return productID;
    }

    public void setProductID(Products productID) {
        this.productID = productID;
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
        hash += (bidID != null ? bidID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bids)) {
            return false;
        }
        Bids other = (Bids) object;
        if ((this.bidID == null && other.bidID != null) || (this.bidID != null && !this.bidID.equals(other.bidID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Bids[ bidID=" + bidID + " ]";
    }

    public BigDecimal getPriceBid() {
        return priceBid;
    }

    public void setPriceBid(BigDecimal priceBid) {
        this.priceBid = priceBid;
    }

    @XmlTransient
    public List<Followbids> getFollowbidsList() {
        return followbidsList;
    }

    public void setFollowbidsList(List<Followbids> followbidsList) {
        this.followbidsList = followbidsList;
    }
    
    public BidsDTO toDTO() {
        BidsDTO dto = new BidsDTO();
        
        dto.setBidID(bidID);
        dto.setProductID(productID);
        dto.setUserID(userID);
        dto.setPriceBid(priceBid);
        dto.setFollowbidsList(followbidsList);
        
        return dto;
    }
}
