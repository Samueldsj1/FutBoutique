package com.futboutique.FutBoutique.controllers;

import com.futboutique.FutBoutique.Models.ProductModel;
import com.futboutique.FutBoutique.Services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public String getAllProduct(Model model) {
        List<ProductModel> Listproduct = produtoService.findAll();
        model.addAttribute("produtos", Listproduct);
        return "catalogo/listaProduto";
    }


    @PostMapping("/cadastrarProduto")
    public String saveProduct(@ModelAttribute("produtoModel") ProductModel productModel) {
        produtoService.saveProduct(productModel);
        return "redirect:/produto";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteProductById( @PathVariable Integer id){
        produtoService.deleteById(id);
        return "redirect:/listaProduto";
    }
}
