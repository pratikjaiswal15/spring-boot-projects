package com.spring.boot_rest.api.spring_boot_rest_api.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {

    public static List<User> users = new ArrayList<>();
    public static int usersCount = 0;
    static {
        users.add(new User(++usersCount, "pratik", LocalDate.now().minusYears(29)));
        users.add(new User(++usersCount, "aditya", LocalDate.now().minusYears(9)));
        users.add(new User(+usersCount, "ayush", LocalDate.now().minusYears(8)));
        users.add(new User(++usersCount, "shrutika", LocalDate.now().minusYears(21)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public User save(User user) {
        user.setId(++usersCount);
        users.add(user);
        return user;
    }

    public void deleteById(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        users.removeIf(predicate);
    }

}
