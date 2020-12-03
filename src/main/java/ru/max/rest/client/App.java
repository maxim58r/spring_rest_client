package ru.max.rest.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.max.rest.client.configuration.Config;
import ru.max.rest.client.models.User;

import java.math.BigDecimal;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);
        Communication communication = context.getBean("communication", Communication.class);
//      List<User> allUsers = communication.getAllUsers();
//        System.out.println(allUsers);

        User userNew = new User("Vasiliy", "zxcv11122233b", "CLIENT",
                BigDecimal.valueOf(23000), true);
//        userNew.setId(3l);
        communication.saveUser(userNew);

//        communication.deleteUser(3);

//        User user = communication.getUser(1);
//        System.out.println(user);
    }
}
