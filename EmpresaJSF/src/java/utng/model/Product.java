/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.model;

import javax.persistence.CascadeType;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_product")
public class Product implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    @Column(name="id_product")
    private Long idProduct;
    
    @ManyToOne(cascade =CascadeType.REMOVE)
    @JoinColumn(name="id_provider")    
    private Provider provider;
    
    @Column(name="product_name")
    private String productName;
    
    @Column(name="product_number")
    private int productNum;

    public Product(Long idProduct, Provider provider, String productName, int productNum) {
        this.idProduct = idProduct;
        this.provider = provider;
        this.productName = productName;
        this.productNum = productNum;
    }

    public Product() {
        this.idProduct = 0L;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductNum() {
        return productNum;
    }

    public void setProductNum(int productNum) {
        this.productNum = productNum;
    }
    
    
}
