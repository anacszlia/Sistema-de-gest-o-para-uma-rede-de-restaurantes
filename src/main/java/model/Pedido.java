/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author anacs
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "pedidos")
public class Pedido implements Serializable {
    @Id
    @Column(name = "id_pedido")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_hora")
    private Date dataHora;
    
    @Column(name = "status")
    private String status;
    
    @Column(name = "valor_total")
    private double valorTotal;
    
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    
    @ManyToOne
    @JoinColumn(name = "id_funcionario")
    private Funcionario funcionario;
    
    @Column(name = "local_entrega")
    private String localEntrega;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ItemPedido> itens = new ArrayList<>();
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_pagamento")
    private Pagamento pagamento;

    public boolean verificaCupom() { return true; }
    public void calculaValorTotal() {}
    public void adicionaItem() {}
    public void removeItem() {}
    public void fecharPedido() {}
    public void cancelarPedido() {}
    public void atualizaStatus() {}
    public void listarItens() {}
    public boolean confirmarRecebimento() { return true; }
    public void aplicaFrete() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Date getDataHora() { 
        return dataHora; 
    }
    
    public void setDataHora(Date dataHora) { 
        this.dataHora = dataHora; 
    }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public double getValorTotal() { return valorTotal; }
    public void setValorTotal(double valorTotal) { this.valorTotal = valorTotal; }

    public Cliente getCliente() { 
        return cliente; 
    }
    
    public void setCliente(Cliente cliente) { 
        this.cliente = cliente; 
    }

    public Funcionario getFuncionario() { 
        return funcionario; 
    }
    
    public void setFuncionario(Funcionario funcionario) { 
        this.funcionario = funcionario; 
    }
    
    public List<ItemPedido> getItens() {
        return itens;
    }
    
    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }
    
    public Pagamento getPagamento() {
        return pagamento;
    }
    
    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public String getLocalEntrega() { return localEntrega; }
    public void setLocalEntrega(String localEntrega) { this.localEntrega = localEntrega; }
}

