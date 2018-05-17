/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adminos.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "interessado")

/**
 *
 * @author johnnylee
 */
public class Interessado {
    
    @Id
    private int id;
    @Column
    private char nome;
    @Column
    private char tipo;
    @Column
    private char matricula;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getNome() {
        return nome;
    }

    public void setNome(char nome) {
        this.nome = nome;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public char getMatricula() {
        return matricula;
    }

    public void setMatricula(char matricula) {
        this.matricula = matricula;
    }
    
    

}
