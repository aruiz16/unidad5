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
import utng.data.ProviderDAO;
import utng.model.Company;
import utng.model.Provider;

@ManagedBean(name = "providerBean")
@SessionScoped
public class ProviderBean implements Serializable {
    private List<Provider> providers;
    private Provider provider;
    private List<Company> companies;
    
    public ProviderBean() {
        provider = new Provider();
        provider.setCompany(new Company());
    }

    public List<Provider> getProviders() {
        return providers;
    }

    public void setProviders(List<Provider> providers) {
        this.providers = providers;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }
    
    public String list() {
        ProviderDAO dao = new ProviderDAO();
        try {
            providers = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Providers";
    }
    
    public String delete() {
        ProviderDAO dao = new ProviderDAO();
        try {
            dao.delete(provider);
            providers = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Delete";
    }

    public String start() {
        provider= new Provider();
        provider.setCompany(new Company());
        try {
            companies = new CompanyDAO().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Start";
    }

    public String save() {
        ProviderDAO dao = new ProviderDAO();
        try {
            if (provider.getIdProvider() != 0) {
                dao.update(provider);
            } else {
                dao.insert(provider);
            }
            providers = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Save";
    }

    public String cancel() {
        return "Cancel";
    }

    public String edit(Provider provider) {
        this.provider = provider;
        try {
            companies = new CompanyDAO().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Edit";
    }
}
