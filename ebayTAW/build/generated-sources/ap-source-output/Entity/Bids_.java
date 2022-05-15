package Entity;

import Entity.Products;
import Entity.Users;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-13T19:21:21")
@StaticMetamodel(Bids.class)
public class Bids_ { 

    public static volatile SingularAttribute<Bids, Products> productID;
    public static volatile SingularAttribute<Bids, BigDecimal> price;
    public static volatile SingularAttribute<Bids, Users> userID;
    public static volatile SingularAttribute<Bids, Integer> bidID;

}