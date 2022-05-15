/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import Entity.Bids;
import Entity.Users;

/**
 *
 * @author 34637
 */
public class FollowbidsDTO {
    private Integer followBidID;
    private Bids bidID;
    private Users userID;

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
    
    
}
