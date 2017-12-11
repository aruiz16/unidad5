/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.data;

import org.hibernate.HibernateException;
import utng.model.Provider;

/**
 *
 * @author Alejandro RG
 */
public class ProviderDAO extends DAO<Provider>{
    
    public ProviderDAO() {
        super(new Provider());
    }
    
    public Provider getOneById(Provider provider)
            throws HibernateException {
        return super.getOneById(provider.getIdProvider());
    }
}
