package com.example.springboot.Dao;

import com.example.springboot.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    User findUserByCin(String cin);
}
