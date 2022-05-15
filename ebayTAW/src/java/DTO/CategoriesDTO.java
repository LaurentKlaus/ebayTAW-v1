/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import Entity.Categoriesuser;
import Entity.Products;
import java.util.List;

/**
 *
 * @author 34637
 */
public class CategoriesDTO {
    private Integer categoryID;
    private String name;
    private List<Categoriesuser> categoriesuserList;
    private List<Products> productsList;

    public Integer getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Integer categoryID) {
        this.categoryID = categoryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Categoriesuser> getCategoriesuserList() {
        return categoriesuserList;
    }

    public void setCategoriesuserList(List<Categoriesuser> categoriesuserList) {
        this.categoriesuserList = categoriesuserList;
    }

    public List<Products> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Products> productsList) {
        this.productsList = productsList;
    }
    
    
}
