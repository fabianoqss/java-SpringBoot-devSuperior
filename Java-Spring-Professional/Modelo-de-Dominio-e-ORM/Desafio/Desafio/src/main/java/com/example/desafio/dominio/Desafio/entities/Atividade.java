package com.example.desafio.dominio.Desafio.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "tb_atividade")
public class Atividade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String descricao;
    private Double preco;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;




}
