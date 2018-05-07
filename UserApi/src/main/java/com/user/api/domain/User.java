package com.user.api.domain;

import lombok.Data;

/**
 * Created by sabin on 5/6/2018.
 */

@Data
public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String state;

    public User(int id) {
        this.id = id;
    }
}
