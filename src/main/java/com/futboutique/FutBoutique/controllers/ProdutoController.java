package com.futboutique.FutBoutique.controllers;
import com.futboutique.FutBoutique.Models.ProdutoModel;
import com.futboutique.FutBoutique.Services.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.UUID;
import java.nio.file.Paths;


@Controller
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }
    @GetMapping
    public String indexCadastro(){
        return "cadastroProduto/index";
    }

    @GetMapping("/cadastro")
    public String FormularioCadastro(Model model) {
        model.addAttribute("produto", new ProdutoModel());
        return "cadastroProduto/index";
    }

    @PostMapping("/cadastro")
    public String cadastrarProduto(ProdutoModel produto, @RequestParam("imagem") MultipartFile imagem) {
        if (!imagem.isEmpty()) {
            try {
                byte[] bytes = imagem.getBytes();
                String nomeArquivo = UUID.randomUUID().toString() + "." + getFileExtension(imagem.getOriginalFilename());
                produto.setImagem(nomeArquivo);

                Path path = Paths.get("C:\\Users\\samue\\IdeaProjects\\FutBoutique\\src\\main\\resources\\static\\img\\img_upload" + nomeArquivo);
                Files.write(path, bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        produtoService.salvarProduto(produto);
        return "redirect:/catalogo";
    }

    private String getFileExtension(String filename) {
        if (StringUtils.hasText(filename)) {
            int dotIndex = filename.lastIndexOf(".");
            if (dotIndex >= 0 && dotIndex < filename.length() - 1) {
                return filename.substring(dotIndex + 1);
            }
        }
        return "";
    }

    @GetMapping("/catalogo")
    public String exibirCatalogo(Model model) {
        List<ProdutoModel> produtos = produtoService.listarProdutos();
        for (ProdutoModel produto : produtos) {
            produto.setImagem("/images/" + produto.getImagem());
        }
        model.addAttribute("produtos", produtos);
        return "catalogo/index";
    }

}
