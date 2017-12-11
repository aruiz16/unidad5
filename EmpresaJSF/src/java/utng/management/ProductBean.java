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
import utng.data.ProductDAO;
import utng.data.ProviderDAO;
import utng.model.Product;
import utng.model.Provider;

@ManagedBean(name = "productBean")
@SessionScoped
public class ProductBean implements Serializable {
    private List<Product> products;
    private Product product;
    private List<Provider> providers;
    
    public ProductBean() {
        product = new Product();
        product.setProvider(new Provider());
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Provider> getProviders() {
        return providers;
    }

    public void setProviders(List<Provider> providers) {
        this.providers = providers;
    }

    public String list() {
        ProductDAO dao = new ProductDAO();
        try {
            products = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Products";
    }
    
    public String delete() {
        ProductDAO dao = new ProductDAO();
        try {
            dao.delete(product);
            products = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Delete";
    }

    public String start() {
        product = new Product();
        product.setProvider(new Provider());
        try {
            providers = new ProviderDAO().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Start";
    }

    public String save() {
        ProductDAO dao = new ProductDAO();
        try {
            if (product.getIdProduct() != 0) {
                dao.update(product);
            } else {
                dao.insert(product);
            }
            products = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Save";
    }

    public String cancel() {
        return "Cancel";
    }

    public String edit(Product product) {
        this.product = product;
        try {
            providers = new ProviderDAO().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Edit";
    }
}
