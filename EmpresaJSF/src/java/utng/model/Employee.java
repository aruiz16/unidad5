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
@Table(name="tbl_employee")
public class Employee implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    @Column(name="id_employee")
    private Long idEmployee;
    
    @ManyToOne(cascade =CascadeType.REMOVE)
    @JoinColumn(name="id_company")    
    private Company company;
    
    @Column(name="name_employee")
    private String nameEmployee;
    
    @Column(name="lastname")
    private String lastname;
    
    @Column(name="age")
    private int age;

    public Employee(Long idEmployee, Company company, String nameEmployee, String lastname, int age) {
        this.idEmployee = idEmployee;
        this.company = company;
        this.nameEmployee = nameEmployee;
        this.lastname = lastname;
        this.age = age;
    }

    public Employee() {
        this.idEmployee = 0L;
    }

    public Long getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Long idEmployee) {
        this.idEmployee = idEmployee;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    
}
