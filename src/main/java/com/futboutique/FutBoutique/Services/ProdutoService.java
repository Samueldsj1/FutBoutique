package com.futboutique.FutBoutique.Services;
import com.futboutique.FutBoutique.Models.ProductModel;
import com.futboutique.FutBoutique.Repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;


    public ProductModel saveProduct(ProductModel productModel){
        return produtoRepository.save(productModel);
    }

    public List<ProductModel> findAll(){
        return produtoRepository.findAll();
    }


    public Optional<ProductModel> findById(Integer id){
        return produtoRepository.findById(id);
    }

    public void deleteById(Integer id){
        produtoRepository.deleteById(id);}
}