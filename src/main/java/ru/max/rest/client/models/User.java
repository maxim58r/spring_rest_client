package ru.max.rest.client.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class User {
    private Long id;
    private String username;
    private String password;
    private String role;
    private BigDecimal salary;
    private boolean enabled;

    public User(String username, String password, String role, BigDecimal salary, boolean enabled) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.salary = salary;
        this.enabled = enabled;
    }

    //    private Map<String, String> roles;
//    private Map<String, Boolean> enableds;
//
//    {
//        roles = new HashMap<>();
//        roles.put("Employee", "EMPLOYEE");
//        roles.put("Client", "CLIENT");
//
//        enableds = new HashMap<>();
//        enableds.put("False", false);
//        enableds.put("True", true);
//    }
}
