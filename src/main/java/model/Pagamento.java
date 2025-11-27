/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Arrays;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author anacs
 */
@Entity
@Table(name = "pagamentos")
public class Pagamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String formaPagamento;

    public boolean validaPagamento() { return true; }

    public String emitirRecibo() { return ""; }

    public List<String> listarFormasPagamento() {
        return Arrays.asList("DINHEIRO", "PIX", "DEBITO", "CREDITO", "VALE_ALIMENTACAO", "VALE_REFEICAO");
    }

    public int getId() { return id; }
    public String getFormaPagamento() { return formaPagamento; }
    public void setFormaPagamento(String formaPagamento) { this.formaPagamento = formaPagamento; }
}
