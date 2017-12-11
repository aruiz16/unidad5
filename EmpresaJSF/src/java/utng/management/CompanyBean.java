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
import utng.data.CertificationDAO;
import utng.data.CompanyDAO;
import utng.model.Certification;
import utng.model.Company;

@ManagedBean(name = "companyBean")
@SessionScoped
public class CompanyBean implements Serializable{
    private List<Company> companies;
    private Company company;
    private List<Certification> certifications;
    private Certification certification;

    public CompanyBean () {
        company = new Company();
        company.setCertification(new Certification());
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
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

    
    public String list(){
        CompanyDAO dao = new CompanyDAO();
        try {
            companies=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Companies";
    }
    
    public String delete(){
         CompanyDAO dao = new CompanyDAO();
        try {
            dao.delete(company);
            companies=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Delete";
    }
    
    public String start(){
        company = new Company();
        company.setCertification(new Certification());
        try {
            certifications = new CertificationDAO().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Start";
    }

    public String save(){
        CompanyDAO dao = new CompanyDAO();
        try {
            if(company.getIdCompany()!= 0){
                dao.update(company);
            }else {
                dao.insert(company);
            }
            companies=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Save";
    }
    
    public String cancel(){
        return "Cancel";
    }
    
    public String edit(Company company){
        this.company = company;
        try {
            certifications = new CertificationDAO().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Edit";
    }   
}
