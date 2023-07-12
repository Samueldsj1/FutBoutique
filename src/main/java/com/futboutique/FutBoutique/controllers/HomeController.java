package com.futboutique.FutBoutique.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class HomeController {
    @GetMapping
    public String index(){
        return "home/index";
    }
    @GetMapping(value = "/sobre")
    public String sobre(){
        return "sobre/sobre";
    }
    @GetMapping(value = "/catalogo")
    public String catalogoProduto(){
        return "catalogo/listaProduto";
    }
    @GetMapping("registroProduto")
    public String indexcadastroProduto() {
        return "catalogo/cadastroProduto";
    }
    @GetMapping(value = "/loginUser")
    public String loginUser(){
        return "login/login";
    }
    @GetMapping(value = "/cadastroUser")
    public String cadastroUser(){
        return "login/cadastro";
    }

    @GetMapping(value = "/usuario")
    public String usuarios(){
        return "login/usuarios";
    }

}
