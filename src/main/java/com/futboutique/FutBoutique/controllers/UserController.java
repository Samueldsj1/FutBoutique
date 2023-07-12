package com.futboutique.FutBoutique.controllers;
import com.futboutique.FutBoutique.Models.UserModel;
import com.futboutique.FutBoutique.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/usuarios")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String getAllUsers(Model model){
        List<UserModel> listUser = userService.findAll();
        model.addAttribute("users",listUser);
        return "login/usuarios";
    }

    @GetMapping(value = "/registro")
    public String formInsertUser(){
        return "login/cadastro";
    }

    @PostMapping(value = "/cadastrar")
    public String saveUser(UserModel userModel){
        userService.save(userModel);
        return "redirect:/usuarios";
    }

    @GetMapping(value = "/{id}")
    public String getUserById( @PathVariable Integer id,Model model){
        Optional<UserModel> user = userService.findById(id);
        if(user.isPresent()) {
            model.addAttribute("user", user.get());
            return "user/update";
        } else{
            return "redirect:/usuarios";
        }
    }


    @PostMapping(value = "/alterar/{id}")
    public String updateUser( @PathVariable Integer id, UserModel userModel){
        Optional<UserModel> user = userService.findById(id);
        if(user.isPresent()){
            userService.save(userModel);
            return "redirect:/listaUsuario";
        } else{
            return "redirect:/listaUsuario";
        }
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteUserById( @PathVariable Integer id){
        userService.deleteById(id);
        return "redirect:/listaUsuario";
    }

}