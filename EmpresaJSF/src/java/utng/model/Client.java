/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_client")
public class Client implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    @Column(name="id_client")
    private Long idClient;
    
    @Column(name="name_client")
    private String nameClient;
    
    @Column(name="lastname")
    private String lastname;
    
    @Column(name="age")
    private int age;

    public Client(Long idClient, String nameClient, String lastname, int age) {
        super();
        this.idClient = idClient;
        this.nameClient = nameClient;
        this.lastname = lastname;
        this.age = age;
    }

    

    public Client() {
        this.idClient = 0L;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
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
