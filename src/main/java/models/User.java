package models;

import java.util.Date;

public class User {
    Integer id;
    String name;
    Date createdAt;
    Date updatedAt;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
