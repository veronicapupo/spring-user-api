package br.com.api.service;

import br.com.api.model.Produto;
import br.com.api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public Produto save (Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> findAllProduto(){
        return Optional.ofNullable(produtoRepository.findAll()).orElse(new ArrayList<>());
    }
}
