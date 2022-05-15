package Entity;

import Entity.Bids;
import Entity.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-15T21:39:57")
@StaticMetamodel(Followbids.class)
public class Followbids_ { 

    public static volatile SingularAttribute<Followbids, Integer> followBidID;
    public static volatile SingularAttribute<Followbids, Users> userID;
    public static volatile SingularAttribute<Followbids, Bids> bidID;

}