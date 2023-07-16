package com.futboutique.FutBoutique.controllers;

import com.futboutique.FutBoutique.Models.ProductModel;
import com.futboutique.FutBoutique.Services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/")
public class HomeController {
    @Autowired
    private ProdutoService produtoService;
    @GetMapping
    public String getAllProduct(Model model) {
        List<ProductModel> Listproduct = produtoService.findAll();
        model.addAttribute("produtos", Listproduct);
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
