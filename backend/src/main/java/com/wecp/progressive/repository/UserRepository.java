package com.wecp.progressive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wecp.progressive.entity.User;
import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Integer>{

    User findByUsername(String userName);
}
