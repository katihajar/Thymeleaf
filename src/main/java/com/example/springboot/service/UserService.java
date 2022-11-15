package com.example.springboot.service;

import com.example.springboot.Dao.UserRepo;
import com.example.springboot.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public String validate(User us){
        String error="";
        if(userRepo.findUserByCin(us.getCin())!=null){
            error="erreur";
            return error;
        }
        return error;
    }

    public String save(User us){

            userRepo.save(us);
            return "register_success";

    }
}
