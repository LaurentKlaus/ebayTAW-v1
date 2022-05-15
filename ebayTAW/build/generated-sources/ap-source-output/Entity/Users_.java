package Entity;

import Entity.Bids;
import Entity.Categoriesuser;
import Entity.Followbids;
import Entity.Products;
import Entity.Studies;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-15T21:39:57")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile ListAttribute<Users, Products> productsList;
    public static volatile ListAttribute<Users, Followbids> followbidsList;
    public static volatile SingularAttribute<Users, String> gender;
    public static volatile SingularAttribute<Users, String> city;
    public static volatile ListAttribute<Users, Studies> studiesList;
    public static volatile SingularAttribute<Users, Integer> postalCode;
    public static volatile ListAttribute<Users, Bids> bidsList;
    public static volatile SingularAttribute<Users, Integer> userID;
    public static volatile SingularAttribute<Users, String> rol;
    public static volatile SingularAttribute<Users, Integer> number;
    public static volatile SingularAttribute<Users, String> password;
    public static volatile ListAttribute<Users, Categoriesuser> categoriesuserList;
    public static volatile SingularAttribute<Users, String> surname;
    public static volatile SingularAttribute<Users, String> street;
    public static volatile SingularAttribute<Users, String> name;
    public static volatile SingularAttribute<Users, String> region;
    public static volatile SingularAttribute<Users, String> email;
    public static volatile SingularAttribute<Users, String> username;

}