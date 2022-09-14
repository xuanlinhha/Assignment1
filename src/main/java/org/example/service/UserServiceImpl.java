package org.example.service;

import org.example.model.User;
import org.example.storage.DB;

public class UserServiceImpl implements UserService {
    private DB db;

    public UserServiceImpl() {}

    public UserServiceImpl(DB db) {
        this.db = db;
    }

    @Override
    public User check(String username, String password) {
        User result = null;
        if (db.getUsersMap().containsKey(username)) {
            User user = db.getUsersMap().get(username);
            if (user.getPassword().equals(password)) {
                result = user;
            }
        }
        return result;
    }

    public DB getDb() {
        return db;
    }

    public void setDb(DB db) {
        this.db = db;
    }
}
