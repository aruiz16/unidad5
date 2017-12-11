/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.data;

import org.hibernate.HibernateException;
import utng.model.Company;

/**
 *
 * @author Alejandro RG
 */
public class CompanyDAO extends DAO<Company>{

    public CompanyDAO() {
        super(new Company());
    }
    
    public Company getOneById(Company company)
            throws HibernateException {
        return super.getOneById(company.getIdCompany());
    }
}
