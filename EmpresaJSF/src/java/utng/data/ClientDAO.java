/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.data;

import org.hibernate.HibernateException;
import utng.model.Client;

/**
 *
 * @author Alejandro RG
 */
public class ClientDAO extends DAO<Client>{
    
    public ClientDAO() {
        super(new Client());
    }
    
    public Client getOneById(Client client)
            throws HibernateException {
        return super.getOneById(client.getIdClient());
    }
}
