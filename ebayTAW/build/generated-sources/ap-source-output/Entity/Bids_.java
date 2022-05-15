package Entity;

import Entity.Followbids;
import Entity.Products;
import Entity.Users;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-15T21:39:57")
@StaticMetamodel(Bids.class)
public class Bids_ { 

    public static volatile ListAttribute<Bids, Followbids> followbidsList;
    public static volatile SingularAttribute<Bids, Products> productID;
    public static volatile SingularAttribute<Bids, BigDecimal> priceBid;
    public static volatile SingularAttribute<Bids, Users> userID;
    public static volatile SingularAttribute<Bids, Integer> bidID;

}