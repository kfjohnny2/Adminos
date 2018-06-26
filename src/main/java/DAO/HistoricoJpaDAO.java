/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.mycompany.adminos.domain.Historico;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Bean stateless de sessao do historico, responsavel por instanciar a entidade
 * Historico na aplicacao.
 *
 * @author Juliana Barbosa
 */
@Stateless
public class HistoricoJpaDAO {

    /**
     * Instancia do historico.
     */
    private static HistoricoJpaDAO instance;

    /**
     * Gerenciador de entidade.
     */
    private EntityManager entityManager;

    /**
     * Acessa a instancia e, se ela ainda nao existir, � criada.
     *
     * @return instance
     */
    public static HistoricoJpaDAO getInstance() {
        if (instance == null) {
            instance = new HistoricoJpaDAO();
        }

        return instance;
    }

    /**
     * Acessa o gerenciador de entidade caso ele ja exista. Se nao, � criado.
     *
     * @return
     */
    public EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AdminosPU");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }

        return entityManager;
    }

    public Historico getById(final int id) {
        return entityManager.find(Historico.class, id);
    }

    public List<Historico> findAll() {
        return entityManager.createQuery("FROM" + Historico.class.getName()).getResultList();
    }

    public void persist(Historico historico) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(historico);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(Historico historico) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(historico);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(Historico historico) {
        try {
            entityManager.getTransaction().begin();
            historico = entityManager.find(Historico.class, historico.getId());
            entityManager.remove(historico);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void removeById(final int id) {
        try {
            Historico historico = getById(id);
            remove(historico);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
