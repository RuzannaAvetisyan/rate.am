package am.rate.server;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.resource.transaction.backend.jdbc.internal.DdlTransactionIsolatorNonJtaImpl;

import javax.validation.*;

import java.util.ArrayList;
import java.util.List;

import static am.rate.server.Currency.EUR_BUY;
import static am.rate.server.Currency.EUR_SELL;


public class EmailManager {
    private static final SessionFactory sessionFactori = new Configuration().configure().buildSessionFactory();
    private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    public static void addUser() {
        Session session = sessionFactori.openSession();
        Validator validator = factory.getValidator();
        Services service = new Services();
        Services service2 = new Services();
        UserMail user = new UserMail();
        service.setCurrency(EUR_BUY);
        service.setValueThatInterests(12.3f);
        service.setUserMail(user);
        user.getServices().add(service);
        user.setEmail("anmey@gmail.ru");
        user.setName("Ruzanna");
        session.getTransaction().begin();
        session.saveOrUpdate(user);
        if (validator.validate(user).isEmpty()) {
            System.out.println(1);
            session.getTransaction().commit();
        } else {
            System.out.println(2);
            session.getTransaction().rollback();
        }
        session.close();


    }
}
