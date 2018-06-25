/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.mycompany.adminos.domain.Unidade;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *  Bean stateless de sessao da Unidade, responsavel por instanciar a entidade Unidade na
 * aplicacao.
 *
 * @author Juliana Barbosa
 */
@Stateless
public class UnidadeJpaDAO {

    /**
     *  Instancia da unidade.
     */
    private static UnidadeJpaDAO instance;
    
    /**
     *  Gerenciador de entidade.
     */
    private EntityManager entityManager;

    /**
     *  Acessa a instancia e, se ela ainda nao existir, � criada.
     * @return instance
     */
    public static UnidadeJpaDAO getInstance() {
        if (instance == null) {
            instance = new UnidadeJpaDAO();
        }

        return instance;
    }

    /**
     *  Acessa o gerenciador de entidade caso ele ja exista. Se nao, ele � criado.
     * @return entityManager
     */
    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AdminosPU");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }

        return entityManager;
    }

    /**
     * 
     * @param id
     * @return 
     */
    public Unidade getById(final int id) {
        return entityManager.find(Unidade.class, id);
    }

    /**
     * 
     * @return 
     */
    public List<Unidade> findAll() {
        return entityManager.createQuery("FROM" + Unidade.class.getName()).getResultList();
    }

    /**
     * 
     * @param unidade 
     */
    public void persist(Unidade unidade) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(unidade);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    /**
     * 
     * @param unidade 
     */
    public void merge(Unidade unidade) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(unidade);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    /**
     * 
     * @param unidade 
     */
    public void remove(Unidade unidade) {
        try {
            entityManager.getTransaction().begin();
            unidade = entityManager.find(Unidade.class, unidade.getId());
            entityManager.remove(unidade);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    /**
     * 
     * @param id 
     */
    public void removeById(final int id) {
        try {
            Unidade unidade = getById(id);
            remove(unidade);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
