import java.util.*;
package com.example.demo.service;
package com.example.demo.model.User;

public interface UserService extends User
{
   User register(User user);
   User findByEmail(String email);
}