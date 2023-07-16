package com.futboutique.FutBoutique.Models;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "camisa")
public class ProductModel {
    public ProductModel(){}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    @Column
    @NotNull
    private String club;
    @NotNull
    @Column
    private String description;
    @Column
    private String size;
    @Column
    @NotNull
    private String price;
    @Column
    @NotNull
    private Integer qtd;
    @Column
    @NotNull
    private String imagem;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String  getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }
    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

}
