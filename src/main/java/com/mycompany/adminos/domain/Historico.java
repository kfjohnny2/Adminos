/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adminos.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author johnnylee
 */
@Entity
@Table(name = "historico")
public class Historico implements Serializable {

    @Id
    private int id;
    @Column
    private long idProcesso;
    @Column
    private long data;
    @Column
    private int idUnidade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getData() {
        return data;
    }

    public void setData(long data) {
        this.data = data;
    }

    public int getIdUnidade() {
        return idUnidade;
    }

    public void setIdUnidade(int idUnidade) {
        this.idUnidade = idUnidade;
    }

}
