package com.futboutique.FutBoutique.Services;
import com.futboutique.FutBoutique.Models.ProdutoModel;
import com.futboutique.FutBoutique.Repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;


    public ProdutoModel saveProduct(ProdutoModel produtoModel) {
        return produtoRepository.save(produtoModel);
    }

    public List<ProdutoModel> findAll() {
        return produtoRepository.findAll();
    }


    public Optional<ProdutoModel> findById(Integer id) {
        return produtoRepository.findById(id);
    }

    public void deleteById(Integer id) {
        produtoRepository.deleteById(id);
    }
}