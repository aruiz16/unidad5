/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.data;

import org.hibernate.HibernateException;
import utng.model.Employee;

/**
 *
 * @author Alejandro RG
 */
public class EmployeeDAO extends DAO<Employee>{
    
    public EmployeeDAO() {
        super(new Employee());
    }
    
    public Employee getOneById(Employee employee)
            throws HibernateException {
        return super.getOneById(employee.getIdEmployee());
    }
}
