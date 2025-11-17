/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author anacs
 */


@Entity
@Table(name = "clientes")
public class Cliente implements Serializable{
    @Column(name = "nome", columnDefinition = "text")
    private String nome;
    
    private String cpf;
    private String endereco;
    private char telefone;

    @Id
    @Column(name = "cliente_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos;
    
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public char getTelefone() { return telefone; }
    public void setTelefone(char telefone) { this.telefone = telefone; }

    public void historicoPedidos() {}
}
