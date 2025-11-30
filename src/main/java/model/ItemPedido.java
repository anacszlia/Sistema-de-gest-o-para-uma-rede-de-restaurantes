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
@Table(name = "itenspedidos")
public class ItemPedido implements Serializable {
    
    @Id
    @Column(name = "id_item")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idItem;
    
    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;
    
    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;
    
    @Column(name = "quantidade")
    private int quantidade;
    
    @Column(name = "preco_unitario")
    private double precoUnitario;
    
    @Column(name = "subtotal")
    private double subtotal;

    public int getIdItem() { return idItem; }
    public void setIdItem(int idItem) { this.idItem = idItem; }

    public Pedido getPedido() { 
        return pedido; 
    }
    
    public void setPedido(Pedido pedido) { 
        this.pedido = pedido; 
    }

    public Produto getProduto() { 
        return produto; 
    }
    
    public void setProduto(Produto produto) { 
        this.produto = produto; 
    }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public double getPrecoUnitario() { return precoUnitario; }
    public void setPrecoUnitario(double precoUnitario) { this.precoUnitario = precoUnitario; }

    public double getSubtotal() { return subtotal; }
    public void setSubtotal(double subtotal) { this.subtotal = subtotal; }
}

