package com.user.api.service;

import com.user.api.domain.User;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by sabin on 5/6/2018.
 */

@Service
public class UserService {

    private static List<User> users;
    private static int i = 0;

    static {

        users = new ArrayList<>();
        User user1 = new User(++i);
        user1.setFirstName("Test");
        user1.setLastName("Test");
        user1.setState("California");

        User user2 = new User(++i);
        user2.setFirstName("Integration");
        user2.setLastName("Integration");
        user2.setState("California");
        users.add(user1);
        users.add(user2);
    }

    public void addUser(User user) {
        int i = users.size();
        user.setId(++i);
        users.add(user);
    }

    public boolean removeUser(int i) {

        List<User> usersTemp = users.stream()
                .filter(user -> user.getId() == i)
                .collect(Collectors.toList());

        if (usersTemp.size() == 1) {
            users.remove(usersTemp.get(0));
        }
        return false;
    }

    public List<User> getUsers() {
        return users;
    }

}
