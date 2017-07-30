package com.myname.service.impl;

import com.myname.entity.User;
import com.myname.repository.UserRepository;
import com.myname.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userRepository.loadUserByUsername(username)
                .orElseThrow(()->new UsernameNotFoundException("User "+username+" not found"));
    }


    public Optional<User> findUserByID(int id) {
        return Optional.ofNullable(userRepository.findOne(id));
    }

    @Override
    public User findOneByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }
}