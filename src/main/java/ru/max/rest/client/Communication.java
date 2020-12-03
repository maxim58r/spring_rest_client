package ru.max.rest.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.max.rest.client.models.User;

import java.util.List;

/**
 * @author Serov Maxim
 */
@Component
public class Communication {
    @Autowired
    RestTemplate restTemplate;
    private final String URL = "http://localhost:8082/api/users";

    public List<User> getAllUsers() {
        ResponseEntity<List<User>> listResponseEntity = restTemplate.exchange(URL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                });
        return listResponseEntity.getBody();
    }

    public User getUser(long id) {
        User user = restTemplate.getForObject(URL + "/" + id, User.class);
        return user;
    }

    public void saveUser(User user) {
        long id = user.getId();
        if (id == 0) {
            ResponseEntity<String> entity = restTemplate.postForEntity(URL, user, String.class);
            System.out.println("New user was added to DB");
            System.out.println(entity.getBody());
        } else {
            restTemplate.put(URL, user);
            System.out.println("User with id = " + id + " was added to DB");
        }
    }

    public void deleteUser(long id) {
        restTemplate.delete(URL + "/" + id);
        System.out.println("User with id = " + id + " was deleted from DB");
    }

}
