package com.myname.service;


import com.myname.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService extends UserDetailsService {

    Optional<User> findUserByID(int id);
    User findOneByUsername(String username);
}
