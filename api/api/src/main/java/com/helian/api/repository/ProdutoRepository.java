package com.helian.api.repository;

import java.util.Optional;

import com.helian.api.model.Produto;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Integer> {

    
}
