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
import utng.data.ClientDAO;
import utng.data.ProductDAO;
import utng.data.EmployeeDAO;
import utng.data.SaleDAO;
import utng.model.Client;
import utng.model.Product;
import utng.model.Employee;
import utng.model.Sale;

@ManagedBean(name = "saleBean")
@SessionScoped
public class SaleBean implements Serializable {
    private List<Sale> sales;
    private Sale sale;
    private List<Client> clients;
    private List<Employee> employees;
    private List<Product> products;
    
    public SaleBean() {
        sale = new Sale();
        sale.setClient(new Client());
        sale.setEmployee(new Employee());
        sale.setProduct(new Product());
    }

    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String list() {
        SaleDAO dao = new SaleDAO();
        try {
            sales = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Sales";
    }
    
    public String delete() {
        SaleDAO dao = new SaleDAO();
        try {
            dao.delete(sale);
            sales = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Delete";
    }

    public String start() {
        sale = new Sale();
        sale.setClient(new Client());
        sale.setEmployee(new Employee());
        sale.setProduct(new Product());
        try {
            clients = new ClientDAO().getAll();
            employees = new EmployeeDAO().getAll();
            products = new ProductDAO().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Start";
    }

    public String save() {
        SaleDAO dao = new SaleDAO();
        try {
            if (sale.getIdSale() != 0) {
                dao.update(sale);
            } else {
                dao.insert(sale);
            }
            sales = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Save";
    }

    public String cancel() {
        return "Cancel";
    }

    public String edit(Sale sale) {
        this.sale = sale;
        try {
            clients = new ClientDAO().getAll();
            employees = new EmployeeDAO().getAll();
            products = new ProductDAO().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Edit";
    }
}
