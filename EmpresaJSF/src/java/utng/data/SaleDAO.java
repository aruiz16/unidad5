/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.data;

import org.hibernate.HibernateException;
import utng.model.Sale;

/**
 *
 * @author Alejandro RG
 */
public class SaleDAO extends DAO<Sale>{
    
    public SaleDAO() {
        super(new Sale());
    }
    
    public Sale getOneById(Sale sale)
            throws HibernateException {
        return super.getOneById(sale.getIdSale());
    }
}
