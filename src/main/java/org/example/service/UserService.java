package org.example.service;

import org.example.model.User;

public interface UserService {
    User check(String username, String password);
}
