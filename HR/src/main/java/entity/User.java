package entity;

import entity.types.Role;

public class User {

    private long id;
    private String name;
    private Role userRole;

    private static long ID = 1;

    public User(String userName, Role role){
        name = userName;
        userRole = role;
        id = ID++;
    }



}
