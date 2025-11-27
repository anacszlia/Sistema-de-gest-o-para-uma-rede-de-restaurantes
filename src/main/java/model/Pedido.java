/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author anacs
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private DateTime dataHora;
    private String status;
    private double valorTotal;
    
    @ManyToOne
    @JoinColumn(name = "idCliente")
    private int idCliente;
    
    @ManyToOne
    @JoinColumn(name = "idFuncionario")
    private int idFuncionario;
    private String localEntrega;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItemPedido> itens = new ArrayList<>();

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

    public DateTime getDataHora() { return dataHora; }
    //public void setDataHora(Date dataHora) { this.dataHora = dataHora; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public double getValorTotal() { return valorTotal; }
    public void setValorTotal(double valorTotal) { this.valorTotal = valorTotal; }

    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }

    public int getIdFuncionario() { return idFuncionario; }
    public void setIdFuncionario(int idFuncionario) { this.idFuncionario = idFuncionario; }

    public String getLocalEntrega() { return localEntrega; }
    public void setLocalEntrega(String localEntrega) { this.localEntrega = localEntrega; }
}

