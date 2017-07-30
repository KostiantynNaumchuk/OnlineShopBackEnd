package com.myname.repository;

import com.myname.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    @Query("select u from User u where u.username = :username")
    Optional<UserDetails> loadUserByUsername(@Param("username")String username);

    @Query("select u from User u where u.username = :username")
    User findUserByUsername(@Param("username")String username);
}
