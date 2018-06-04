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
    private static long i = 0;

    static {

        users = new ArrayList<>();
        User user1 = new User(++i);
        user1.setFirstName("Nikita");
        user1.setLastName("Master");
        user1.setState("California");

        User user2 = new User(++i);
        user2.setFirstName("Sabin");
        user2.setLastName("Branch");
        user2.setState("California");
        users.add(user1);
        users.add(user2);
    }

    public void addUser(User user) {
        long i = users.size();
        user.setId(++i);
        users.add(user);
    }

    public boolean removeUser(int i) {

        List<User> usersTemp = users.stream()
                .filter(user -> user.getId() == i)
                .collect(Collectors.toList());

        if (usersTemp.size() == 1) {
            users.remove(usersTemp.get(0));
            return true;
        }
        return false;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<User> getUsersExceptDefault() {
        return users.stream()
                .filter(user -> user.getId() != 1)
                .filter(user -> user.getId() != 2)
                .collect(Collectors.toList());
    }

    public boolean removeUserExceptDefaultData() {
    	
        if (users.size() > 2) {
        	users = users.subList(0,2);
        }
    	
        return true;
    }
    
    public User findUserById(long id){
    	 if(id > users.size()){
    		 return null;
    	 }
    	 List<User> tempUsers=      users.stream()
    	        .filter(user->user.getId()==id)
    	        .collect(Collectors.toList());
          return tempUsers.get(0);			          
    }

}
