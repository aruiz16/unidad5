/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_sale")
public class Sale {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)    
    @Column(name="id_sale")
    private Long idSale;
    
    @ManyToOne(cascade =CascadeType.REMOVE)
    @JoinColumn(name="id_client")    
    private Client client;
    
    @ManyToOne(cascade =CascadeType.REMOVE)
    @JoinColumn(name="id_employee")    
    private Employee employee;
    
    @ManyToOne(cascade =CascadeType.REMOVE)
    @JoinColumn(name="id_product")    
    private Product product;
    
    @Column(name="price")
    private double price;
    
    @Column(name="description", length=100)
    private String description;

    public Sale(Long idSale, Client client, Employee employee, Product product, double price, String description) {
        this.idSale = idSale;
        this.client = client;
        this.employee = employee;
        this.product = product;
        this.price = price;
        this.description = description;
    }

    public Sale() {
        this.idSale=0L;
    }

    public Long getIdSale() {
        return idSale;
    }

    public void setIdSale(Long idSale) {
        this.idSale = idSale;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
