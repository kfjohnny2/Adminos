/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adminos.src;

import DAO.ProcessoJpaDAO;
import com.mycompany.adminos.domain.Processo;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author johnnylee
 */
@ManagedBean(name = "updateProcessoManagedBean")
@RequestScoped
public class AtualizaProcessoMB {

    @EJB
    private static ProcessoJpaDAO daoProcesso;

    public Processo processo = new Processo();

    public String updateNewProcesso() {
        daoProcesso.update(processo);
        return "employeelist";
    }
}
