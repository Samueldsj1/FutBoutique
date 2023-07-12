package com.futboutique.FutBoutique.controllers;

import com.futboutique.FutBoutique.Models.ProdutoModel;
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
        List<ProdutoModel> Listproduct = produtoService.findAll();
        model.addAttribute("catalogo", Listproduct);
        return "catalogo/listaProduto";
    }


    @PostMapping("/cadastrarProduto")
    public String saveProduct(@ModelAttribute("produtoModel") ProdutoModel produtoModel) {
        produtoService.saveProduct(produtoModel);
        return "redirect:/produto";
    }
    @GetMapping(value = "/{id}")
    public String getUserById( @PathVariable Integer id,Model model){
        Optional<ProdutoModel> produto = produtoService.findById(id);
        if(produto.isPresent()) {
            model.addAttribute("produto", produto.get());
            return "catalogo/update";
        } else{
            return "redirect:/produto";
        }
    }


    @PostMapping(value = "/alterar/{id}")
    public String updateProduct( @PathVariable Integer id, ProdutoModel produtoModel){
        Optional<ProdutoModel> user = produtoService.findById(id);
        if(user.isPresent()){
            produtoService.saveProduct(produtoModel);
             return "redirect:/produto";

        } else{
            return "redirect:/produto";
        }
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteProductById( @PathVariable Integer id){
        produtoService.deleteById(id);
        return "redirect:/listaProduto";
    }
}
