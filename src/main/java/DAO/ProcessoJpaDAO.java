/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import com.mycompany.adminos.domain.Processo;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author jubss
 */
public class ProcessoJpaDAO {
    
    private static ProcessoJpaDAO instance;
    private EntityManager entityManager;
    
    public static ProcessoJpaDAO getInstance(){
        if(instance == null){
            instance = new ProcessoJpaDAO();
        }
        
        return instance;
    }
    
    private EntityManager getEntityManager(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudHibernatePU");
        if(entityManager == null){
            entityManager = factory.createEntityManager();
        }
        
        return entityManager;
    }
    
    public Processo getById(final int id){
        return entityManager.find(Processo.class, id);
    }
    
    public List<Processo> findAll(){
        return entityManager.createQuery("FROM" + Processo.class.)
    }
    
}
