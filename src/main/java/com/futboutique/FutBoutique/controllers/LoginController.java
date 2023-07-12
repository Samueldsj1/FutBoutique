package com.futboutique.FutBoutique.controllers;


import com.futboutique.FutBoutique.Models.UserModel;
import com.futboutique.FutBoutique.Services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;

@Controller

public class LoginController {

    @Autowired(required = true)
    private LoginService loginService;

    @GetMapping(value = "/login")
    public String indexLogin(){
        return "login/login";
    }
    @PostMapping(value = "/logar")
    public String logOn(UserModel userModel, Model model, HttpServletResponse response){
        UserModel user = loginService.logar(userModel);

        if(user != null){
            return "redirect:/";
        } else{
            model.addAttribute("erro","Usuario ou senha invalidos!");
            return "redirect:/login";
        }
    }
}
