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
import utng.data.ClientDAO;
import utng.model.Client;

@ManagedBean(name = "clientBean")
@SessionScoped
public class ClientBean implements Serializable{
    private List<Client> clients;
    private Client client;

    public ClientBean () {
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String list(){
        ClientDAO dao = new ClientDAO();
        try {
            clients=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Clients";
    }
    
    public String delete(){
         ClientDAO dao = new ClientDAO();
        try {
            dao.delete(client);
            clients=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Delete";
    }
    
    public String start(){
        client= new Client();
        return "Start";
    }

    public String save(){
        ClientDAO dao = new ClientDAO();
        try {
            if(client.getIdClient()!= 0){
                dao.update(client);
            }else {
                dao.insert(client);
            }
            clients=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Save";
    }
    
    public String cancel(){
        return "Cancel";
    }
    
    public String edit(Client client){
        this.client=client;
        return "Edit";
    }   
}
