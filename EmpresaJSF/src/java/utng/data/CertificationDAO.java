/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.data;

import org.hibernate.HibernateException;
import utng.model.Certification;

/**
 *
 * @author Alejandro RG
 */
public class CertificationDAO extends DAO<Certification>{
    
    public CertificationDAO() {
        super(new Certification());
    }
    
    public Certification getOneById(Certification certification)
            throws HibernateException {
        return super.getOneById(certification.getIdCertification());
    }
}
