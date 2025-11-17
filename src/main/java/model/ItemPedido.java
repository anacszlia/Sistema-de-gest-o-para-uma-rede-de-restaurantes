/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import javax.annotation.processing.Generated;
import javax.persistence.*;
/**
 *
 * @author anacs
 */
@Entity
@Table(name="itenspedidos")
public class ItemPedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY  )
    private int idItem;
    
    @ManyToOne
    @JoinColumn(name = "idPedido")
    private Pedido idPedido;
    
    @ManyToOne
    @JoinColumn(name = "idProduto")
    private Produto produto;
    
    private int quantidade;
    private double precoUnitario;
    private double subtotal;

    public int getIdItem() { return idItem; }
    public void setIdItem(int idItem) { this.idItem = idItem; }

    public Pedido getIdPedido() { return idPedido; }
    public void setIdPedido(Pedido idPedido) { this.idPedido = idPedido; }

    public Produto getIdProduto() { return produto; }
    public void setIdProduto(Produto idProduto) { this.produto = idProduto; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public double getPrecoUnitario() { return precoUnitario; }
    public void setPrecoUnitario(double precoUnitario) { this.precoUnitario = precoUnitario; }

    public double getSubtotal() { return subtotal; }
    public void setSubtotal(double subtotal) { this.subtotal = subtotal; }
}

