
package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {

    User registerUser(User user);   // ✅ ADD THIS

    User getUserByEmail(String email);
}
