/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.adminos.src;

import DAO.InteressadoJpaDAO;
import DAO.ProcessoJpaDAO;
import com.mycompany.adminos.domain.Interessado;
import com.mycompany.adminos.domain.Processo;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author johnnylee
 */
@ManagedBean(name = "processoManagedBean")
@RequestScoped
public class ProcessoMB {

    @EJB
    private static ProcessoJpaDAO dao;
    private static InteressadoJpaDAO daoInteressado;

    //Auxiliary fields for JSF
    private List<Processo> processoList = new ArrayList<>();
    public Processo processo = new Processo();
    private List<Interessado> interessadosList = new ArrayList<>();

    public String addNewProcesso() {
        dao.persist(processo);
        processoList = dao.findAll();
        return "employeelist";
    }

    private void setup() {
        interessadosList.add(new Interessado("Johnnylee", "DISCENTE", "2015035848"));
        daoInteressado.persistAll(interessadosList);
    }
}
