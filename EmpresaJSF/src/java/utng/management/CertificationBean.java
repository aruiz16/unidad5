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
import utng.data.CertificationDAO;
import utng.model.Certification;
import utng.model.Company;

@ManagedBean(name = "certificationBean")
@SessionScoped
public class CertificationBean implements Serializable {
    private List<Certification> certifications;
    private Certification certification;
    private Company company;
    
    
    public CertificationBean() {
    }

    public List<Certification> getCertifications() {
        return certifications;
    }

    public void setCertifications(List<Certification> certifications) {
        this.certifications = certifications;
    }

    public Certification getCertification() {
        return certification;
    }

    public void setCertification(Certification certification) {
        this.certification = certification;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    
    public String list() {
        CertificationDAO dao = new CertificationDAO();
        try {
            certifications = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Certifications";
    }
    
    public String delete() {
        CertificationDAO dao = new CertificationDAO();
        try {
            dao.delete(certification);
            certifications = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Delete";
    }

    public String start() {
        certification= new Certification();
        return "Start";
    }

    public String save() {
        CertificationDAO dao = new CertificationDAO();
        try {
            if (certification.getIdCertification() != 0) {
                dao.update(certification);
            } else {
                dao.insert(certification);
            }
            certifications = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Save";
    }

    public String cancel() {
        return "Cancel";
    }

    public String edit(Certification certification) {
        this.certification=certification;
        return "Edit";
    }
}
