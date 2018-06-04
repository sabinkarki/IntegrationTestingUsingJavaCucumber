package com.user.api.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by sabin on 5/6/2018.
 */

@Getter
@Setter
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String state;

    public User(){};

    public User(long id) {
        this.id = id;
    }
}
