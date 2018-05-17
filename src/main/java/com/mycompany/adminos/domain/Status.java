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
@Table(name = "status")

/**
 *
 * @author johnnylee
 */
public class Status {
    
    @Id
    private int id;
    @Column
    private char descricao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getDescricao() {
        return descricao;
    }

    public void setDescricao(char descricao) {
        this.descricao = descricao;
    }
    
    

}
