/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import Entity.Bids;
import Entity.Categories;
import Entity.Users;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author mjura
 */
public class ProductsDTO {
    private int productID;
    private Users userID;
    private List<Bids> bidsList;
    private Categories categoryID;
    private String title;
    private String description;
    private BigDecimal initialPrice;
    private String photo;
    private Date startDate;
    private Date finishDate;
    private Boolean isSold;

    public ProductsDTO() {
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }
    
    public Users getUserID() {
        return userID;
    }

    public List<Bids> getBidsList() {
        return bidsList;
    }

    public Categories getCategoryID() {
        return categoryID;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getInitialPrice() {
        return initialPrice;
    }

    public String getPhoto() {
        return photo;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public Boolean getIsSold() {
        return isSold;
    }

    public void setUserID(Users userID) {
        this.userID = userID;
    }

    public void setBidsList(List<Bids> bidsList) {
        this.bidsList = bidsList;
    }

    public void setCategoryID(Categories categoryID) {
        this.categoryID = categoryID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setInitialPrice(BigDecimal initialPrice) {
        this.initialPrice = initialPrice;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public void setIsSold(Boolean isSold) {
        this.isSold = isSold;
    }
    
    
}
