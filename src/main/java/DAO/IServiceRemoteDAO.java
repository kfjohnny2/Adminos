/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import javax.ejb.Remote;
import javax.persistence.EntityManager;

/**
 *  M�todos recorrentes no DAO.
 * 
 * @author Johnnylee Bryan
 */
@Remote
public interface IServiceRemoteDAO {

    public EntityManager getEntityManager();

    public void removeById(final int id);

}
