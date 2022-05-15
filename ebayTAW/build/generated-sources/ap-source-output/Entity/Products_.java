package Entity;

import Entity.Bids;
import Entity.Categories;
import Entity.Users;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-15T21:39:57")
@StaticMetamodel(Products.class)
public class Products_ { 

    public static volatile SingularAttribute<Products, Integer> productID;
    public static volatile SingularAttribute<Products, BigDecimal> initialPrice;
    public static volatile SingularAttribute<Products, Boolean> isSold;
    public static volatile SingularAttribute<Products, String> description;
    public static volatile SingularAttribute<Products, String> photo;
    public static volatile SingularAttribute<Products, Date> finishDate;
    public static volatile ListAttribute<Products, Bids> bidsList;
    public static volatile SingularAttribute<Products, String> title;
    public static volatile SingularAttribute<Products, Users> userID;
    public static volatile SingularAttribute<Products, Date> startDate;
    public static volatile SingularAttribute<Products, Categories> categoryID;

}