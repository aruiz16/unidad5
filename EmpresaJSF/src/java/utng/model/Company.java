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
@Table(name="tbl_company")
public class Company {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_company")
    private Long idCompany;
    
    @ManyToOne(cascade=CascadeType.REMOVE)
    @JoinColumn(name="id_certification")    
    private Certification certification;
    
    @Column(name="name_company")
    private String nameCompany;
    
    @Column(name="employees_number")
    private int employeesNum;
    
    @Column(name="state")
    private String state;
    
    @Column(name="home")
    private String home;

    public Company(Long idCompany, Certification certification, String nameCompany, int employeesNum, String state, String home) {
        super();
        this.idCompany = idCompany;
        this.certification = certification;
        this.nameCompany = nameCompany;
        this.employeesNum = employeesNum;
        this.state = state;
        this.home = home;
    }

    
    public Company() {
        this.idCompany = 0L;
    }

    public Long getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Long idCompany) {
        this.idCompany = idCompany;
    }

    public Certification getCertification() {
        return certification;
    }

    public void setCertification(Certification certification) {
        this.certification = certification;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public int getEmployeesNum() {
        return employeesNum;
    }

    public void setEmployeesNum(int employeesNum) {
        this.employeesNum = employeesNum;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    
}
