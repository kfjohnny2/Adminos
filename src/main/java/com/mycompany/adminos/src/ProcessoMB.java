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
import java.util.Calendar;
import java.util.List;
import javax.annotation.PostConstruct;
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
    private static ProcessoJpaDAO daoProcesso;
    @EJB
    private static InteressadoJpaDAO daoInteressado;

    //Auxiliary fields for JSF
    private List<Processo> processoList = new ArrayList<>();
    public Processo processo = new Processo();
    public Interessado interessado = new Interessado();

    public String addNewProcesso() {
        processo.setData(Calendar.getInstance().getTimeInMillis());
        daoProcesso.persist(processo);
        processoList = daoProcesso.findAll();
        return "employeelist";
    }

    @PostConstruct
    public void init() {
        interessado = (new Interessado("Johnnylee", "DISCENTE", "2015035848"));
        daoInteressado.persist(interessado);
    }
}
