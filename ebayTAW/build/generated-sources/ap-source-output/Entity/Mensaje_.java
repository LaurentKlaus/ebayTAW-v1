package Entity;

import Entity.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-15T10:42:39")
@StaticMetamodel(Mensaje.class)
public class Mensaje_ { 

    public static volatile SingularAttribute<Mensaje, String> texto;
    public static volatile SingularAttribute<Mensaje, Integer> id;
    public static volatile SingularAttribute<Mensaje, Users> userID;

}