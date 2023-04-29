package com.works.days2.props;

import lombok.Data;

@Data
public class User {

    private int uid;
    private String name;
    private String surname;
    private String password;
    private String email;
    private int age;
}
