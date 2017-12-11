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
@Table(name="tbl_certification")
public class Certification implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)  
    
    @Column(name="id_certification")
    private Long idCertification;
        
    @Column(name="name_certification",length=100)
    private String nameCertification;

    public Certification(Long idCertification, String nameCertification) {
        this.idCertification = idCertification;
        this.nameCertification = nameCertification;
    }

    public Certification() {
        this.idCertification = 0L;
    }

    public Long getIdCertification() {
        return idCertification;
    }

    public void setIdCertification(Long idCertification) {
        this.idCertification = idCertification;
    }

    public String getNameCertification() {
        return nameCertification;
    }

    public void setNameCertification(String nameCertification) {
        this.nameCertification = nameCertification;
    }

       
}
