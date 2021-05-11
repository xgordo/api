package com.helian.api.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
 
@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String nome;
    private int estoque;



     

    public Produto() {
    }

    
    // update estoque
    public Produto(int id, String nome, int estoque) {
        this.id = id;
        this.nome = nome;
        this.estoque = estoque;
    }
    // add produto
    public Produto(String nome,int estoque) {

        this.nome = nome;
        this.estoque = estoque;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEstoque() {
        return this.estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Produto)) {
            return false;
        }
        Produto produto = (Produto) o;
        return id == produto.id && Objects.equals(nome, produto.nome) && estoque == produto.estoque;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, estoque);
    }


}