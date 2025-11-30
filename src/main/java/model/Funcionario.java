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
@Table(name = "funcionarios")
public class Funcionario extends Cliente {
    
    @Column(name = "cargo")
    private String cargo;

    public String getCargo() { 
        return cargo; 
    }
    
    public void setCargo(String cargo) { 
        this.cargo = cargo; 
    }
}
