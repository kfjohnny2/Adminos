/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.mycompany.adminos.domain.Interessado;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Bean stateless de sessao do Interessado, responsavel por instanciar a
 * entidade Interessado na aplicacao.
 *
 * @author Juliana Barbosa
 */
@Stateless
public class InteressadoJpaDAO {

    /**
     * Instancia do Interessado.
     */
    private static UnidadeJpaDAO instance;

    /**
     * Gerenciador de entidade
     */
    private EntityManager entityManager;

    /**
     * Acessa a instancia e, se ela ainda nao existir, � criada.
     *
     * @return instance
     */
    public static UnidadeJpaDAO getInstance() {
        if (instance == null) {
            instance = new UnidadeJpaDAO();
        }

        return instance;
    }

    /**
     * Acessa o gerenciador de entidade caso ele ja exista. Se nao, ele �
     * criado.
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

    /**
     *
     * @param id
     * @return
     */
    public Interessado getById(final int id) {
        return entityManager.find(Interessado.class, id);
    }

    /**
     *
     * @return
     */
    public List<Interessado> findAll() {
        return entityManager.createQuery("FROM" + Interessado.class.getName()).getResultList();
    }

    /**
     *
     * @param interessado
     */
    public void persist(Interessado interessado) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(interessado);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    /**
     * Insere uma lista de interessados para persistência
     *
     * @param interessado
     */
    public void persistAll(List<Interessado> interessado) {
        try {
            for (Interessado interessado1 : interessado) {
                entityManager.getTransaction().begin();
                entityManager.persist(interessado1);
                entityManager.getTransaction().commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    /**
     *
     * @param interessado
     */
    public void merge(Interessado interessado) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(interessado);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    /**
     *
     * @param interessado
     */
    public void remove(Interessado interessado) {
        try {
            entityManager.getTransaction().begin();
            interessado = entityManager.find(Interessado.class, interessado.getId());
            entityManager.remove(interessado);
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
            Interessado interessado = getById(id);
            remove(interessado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
