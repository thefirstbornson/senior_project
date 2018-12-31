import datasets.*;
import dbservice.DBService;
import dbservice.DBServiceHibernateImpl;

import javax.persistence.EntityManager;
import java.util.List;


public class Main {
    public static void main(String[] args) throws Exception {
        DBService dbService = new DBServiceHibernateImpl("seniorproject.jpa.hibernate.mysql" );

    }

}
