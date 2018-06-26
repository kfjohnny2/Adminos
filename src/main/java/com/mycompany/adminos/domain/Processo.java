/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adminos.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author johnnylee
 */
@Entity
@Table(name = "processo")
public class Processo implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    @Column
    private String processo;
    @Column
    private String observacao;
    @Column
    private String assunto;
    @Column
    private Long data;
    @Column
    private int idTipo;
    @Column
    private int idStatus;
    @Column
    private int idInteressado;
    @Column
    private String usuarioEnvio;
    @Column
    private int idUnidadeOrigem;

    public int getId() {
        return id;
    }

    public String getProcesso() {
        return processo;
    }

    public String getObservacao() {
        return observacao;
    }

    public String getAssunto() {
        return assunto;
    }

    public Long getData() {
        return data;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public int getIdStatus() {
        return idStatus;
    }

    public int getIdInteressado() {
        return idInteressado;
    }

    public int getIdUnidadeOrigem() {
        return idUnidadeOrigem;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProcesso(String processo) {
        this.processo = processo;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public void setData(Long data) {
        this.data = data;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    public void setUsuarioEnvio(String usuarioEnvio) {
        this.usuarioEnvio = usuarioEnvio;
    }

    public String getUsuarioEnvio() {
        return this.usuarioEnvio;
    }

    public void setIdInteressado(int idInteressado) {
        this.idInteressado = idInteressado;
    }

    public void setIdUnidadeOrigem(int idUnidadeOrigem) {
        this.idUnidadeOrigem = idUnidadeOrigem;
    }

}
