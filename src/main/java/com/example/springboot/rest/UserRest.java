package com.example.springboot.rest;

import com.example.springboot.Dao.UserRepo;
import com.example.springboot.bean.User;
import com.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserRest {
    @Autowired
    UserService userService;


    @PostMapping("/register")
    public String save(@ModelAttribute("user") User user,Model model) {
        String err = userService.validate(user);
        if (!err.isEmpty()) {
            model.addAttribute("errorMessage"," failed");
            return  "index";
        }else{
            model.addAttribute("errorMessage"," success");
            return  userService.save(user);
        }

    }

    @RequestMapping("/")
    public String submitForm(Model model) {

      model.addAttribute("user", new User());
        return "index";
    }
}
