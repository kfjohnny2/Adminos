/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.mycompany.adminos.domain.Processo;
import java.util.Calendar;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Bean stateless de sessao do Processo, responsavel por instanciar a entidade
 * Processo na aplicacao.
 *
 * @author Juliana Barbosa
 */
@Stateless
public class ProcessoJpaDAO {//implements IServiceRemoteDAO {

    /**
     * Instancia do interessado.
     */
    private static ProcessoJpaDAO instance;

    /**
     * Gerenciador de entidade.
     */
    private EntityManager entityManager;

    /**
     * Acessa a instancia e, se ela ainda nao existir, � criada.
     *
     * @return instance
     */
    public static ProcessoJpaDAO getInstance() {
        if (instance == null) {
            instance = new ProcessoJpaDAO();
        }

        return instance;
    }

    /**
     * Acessa o gerenciador de entidade caso ele ja exista. Se nao, ele �
     * criado.
     *
     * @return entityManager
     */
    public EntityManager getEntityManager() {
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
    public Processo getById(final int id) {
        return entityManager.find(Processo.class, id);
    }

    /**
     *
     * @return
     */
    public List<Processo> findAll() {
        return entityManager.createQuery("FROM" + Processo.class.getName()).getResultList();
    }

    /**
     *
     * @param processo
     */
    public void persist(Processo processo) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(processo);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    /**
     *
     * @param processo
     */
    public void update(Processo processo) {
        try {
            entityManager.getTransaction().begin();
            entityManager
                    .createQuery("update historico set data = " + Calendar.getInstance().getTimeInMillis() + ", set idprocesso = " + processo.getId()
                            + "where id= " + processo.getId())
                    .executeUpdate();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    /**
     *
     * @param processo
     */
    public void merge(Processo processo) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(processo);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    /**
     *
     * @param processo
     */
    public void remove(Processo processo) {
        try {
            entityManager.getTransaction().begin();
            processo = entityManager.find(Processo.class, processo.getId());
            entityManager.remove(processo);
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
            Processo processo = getById(id);
            remove(processo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
