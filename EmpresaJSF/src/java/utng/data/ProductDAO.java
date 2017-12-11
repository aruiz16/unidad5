/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.data;

import org.hibernate.HibernateException;
import utng.model.Product;

/**
 *
 * @author Alejandro RG
 */
public class ProductDAO extends DAO<Product>{
    
    public ProductDAO() {
        super(new Product());
    }
    
    public Product getOneById(Product product)
            throws HibernateException {
        return super.getOneById(product.getIdProduct());
    }
}
