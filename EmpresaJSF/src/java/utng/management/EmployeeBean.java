/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.management;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import utng.data.CompanyDAO;
import utng.data.EmployeeDAO;
import utng.model.Company;
import utng.model.Employee;

@ManagedBean(name = "employeeBean")
@SessionScoped
public class EmployeeBean implements Serializable {
    private List<Employee> employees;
    private Employee employee;
    private List<Company> companies;
    
    public EmployeeBean() {
        employee = new Employee();
        employee.setCompany(new Company());
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    public String list() {
        EmployeeDAO dao = new EmployeeDAO();
        try {
            employees = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Employees";
    }
    
    public String delete() {
        EmployeeDAO dao = new EmployeeDAO();
        try {
            dao.delete(employee);
            employees = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Delete";
    }

    public String start() {
        employee = new Employee();
        employee.setCompany(new Company());
        try {
            companies = new CompanyDAO().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Start";
    }

    public String save() {
        EmployeeDAO dao = new EmployeeDAO();
        try {
            if (employee.getIdEmployee() != 0) {
                dao.update(employee);
            } else {
                dao.insert(employee);
            }
            employees = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Save";
    }

    public String cancel() {
        return "Cancel";
    }

    public String edit(Employee employee) {
        this.employee = employee;
        try {
            companies = new CompanyDAO().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Edit";
    }
}
