package com.helian.api.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import com.helian.api.model.Produto;
import com.helian.api.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/produtos")
public class ClienteController {

    @Autowired
    private ProdutoRepository  produtoRepository;
    
    // add produto
    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public Produto novoProduto(@RequestParam int id,String nome, int estoque){
        
        Produto produto = new Produto(id,nome,estoque);
        return produtoRepository.save(produto);

    }


    //all produtos
    @GetMapping
    public Iterable<Produto> obtProdutos(){
        return produtoRepository.findAll();
    }

    @PutMapping("/estoque/{prodId}/{qntd}")
    public Produto addEstoque(@PathVariable("prodId") Integer prodId, @PathVariable("qntd") Integer qntd){
    Optional<Produto> prod = produtoRepository.findById(prodId);
    prod.get().setEstoque(prod.get().getEstoque()-qntd);
    return produtoRepository.save(prod);
    }
}

