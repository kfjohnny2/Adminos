/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adminos.src;

import DAO.ProcessoJpaDAO;
import com.mycompany.adminos.domain.Processo;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author johnnylee
 */
@ManagedBean(name = "processoManagedBean")
@RequestScoped
public class ProcessoMB {

    @Inject
    ProcessoJpaDAO dao;

    //Auxiliary fields for JSF
    private List<Processo> processoList = new ArrayList<>();
    private Processo processo = new Processo();

    public String addNewProcesso() {
        dao.persist(processo);
        processoList = dao.findAll();
        return "employeelist";
    }
}
