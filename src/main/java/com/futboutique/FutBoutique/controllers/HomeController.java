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
    public String produto(){
        return "catalogo/index";
    }
}
