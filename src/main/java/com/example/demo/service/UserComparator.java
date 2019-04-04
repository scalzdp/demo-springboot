package com.example.demo.service;

import com.example.demo.model.User;

public class UserComparator {

    public int compareByUserByUserID(User user1, User user2){
        return user1.getUserId() - user2.getUserId();
    }
}
