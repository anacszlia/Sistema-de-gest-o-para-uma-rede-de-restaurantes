/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author anacs
 */
@Entity
@Table(name = "pagamentos")
public class Pagamento implements Serializable {
    
    @Id
    @Column(name = "id_pagamento")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "forma_pagamento")
    private String formaPagamento;
    
    @OneToOne(mappedBy = "pagamento")
    private Pedido pedido;

    public boolean validaPagamento() { return true; }

    public String emitirRecibo() { return ""; }

    public static List<String> listarFormasPagamento() {
        return Arrays.asList("DINHEIRO", "PIX", "DEBITO", "CREDITO", "VALE_ALIMENTACAO", "VALE_REFEICAO");
    }

    public int getId() { 
        return id; 
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getFormaPagamento() { 
        return formaPagamento; 
    }
    
    public void setFormaPagamento(String formaPagamento) { 
        this.formaPagamento = formaPagamento; 
    }
    
    public Pedido getPedido() {
        return pedido;
    }
    
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
