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
    private int idInteressado;
    @Column
    private String nome;
    @Column
    private String tipo;
    @Column
    private String matricula;

    public Interessado(String nome, String tipo, String matricula) {
        this.nome = nome;
        this.tipo = tipo;
        this.matricula = matricula;
    }

    public Interessado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdInteressado() {
        return idInteressado;
    }

    public void setIdInteressado(int idInteressado) {
        this.idInteressado = idInteressado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

}
