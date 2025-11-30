/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author anacs
 */
@Entity
@Table(name = "produtos")
public class Produto implements Serializable {
    
    @Id
    @Column(name = "id_produto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProduto;
    
    @Column(name = "nome")
    private String nome;
    
    @Column(name = "descricao")
    private String descricao;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "categoria")
    private CategoriasCardapio categoria;
    
    @Column(name = "preco")
    private double preco;

    public int getIdProduto() { return idProduto; }
    public void setIdProduto(int idProduto) { this.idProduto = idProduto; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public CategoriasCardapio getCategoria() { 
        return categoria; 
    }
    
    public void setCategoria(CategoriasCardapio categoria) { 
        this.categoria = categoria; 
    }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }
    
    @Override
    public String toString() {
        return nome + " - R$ " + String.format("%.2f", preco);
    }
}
