package com.learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer>{

}
