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
@Table(name="tbl_provider")
public class Provider implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    @Column(name="id_provider")
    private Long idProvider;
    
    @ManyToOne(cascade =CascadeType.REMOVE)
    @JoinColumn(name="id_company")    
    private Company company;
    
    @Column(name="provider_name", length=100)
    private String providerName;
    
    @Column(name="city")
    private String city;

    public Provider(Long idProvider, Company company, String providerName, String city) {
        super();
        this.idProvider = idProvider;
        this.company = company;
        this.providerName = providerName;
        this.city = city;
    }

   
    public Provider() {
        this.idProvider = 0L;
    }

    public Long getIdProvider() {
        return idProvider;
    }

    public void setIdProvider(Long idProvider) {
        this.idProvider = idProvider;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
}
