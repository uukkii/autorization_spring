package ru.netology.authorization_spring.repository;

import org.springframework.stereotype.Repository;
import ru.netology.authorization_spring.authorities.Authorities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class UserRepository {

    public List<Authorities> getUserAuthorities(String user, String password) {
        List<Authorities> authorities = new ArrayList<>();
        String ADMIN_PASS = "admin";
        String MODERATOR_PASS = "moderator";
        String USER_PASS = "user";

        switch (user) {
            case "admin" :
                if (password.equals(ADMIN_PASS)) {
                    Collections.addAll(authorities, Authorities.READ, Authorities.WRITE, Authorities.DELETE);
                }
                break;
            case "moderator" :
                if (password.equals(MODERATOR_PASS)) {
                    Collections.addAll(authorities, Authorities.READ, Authorities.DELETE);
                }
                break;
            case "user" :
                if (password.equals(USER_PASS)) {
                    Collections.addAll(authorities, Authorities.READ, Authorities.WRITE);
                }
                break;
        }
        return authorities;
    }
}