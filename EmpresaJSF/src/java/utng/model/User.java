package utng.model;
import java.io.Serializable;
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
@Table(name="tbl_user")
public class User implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    @Column(name="id_user")
    private Long idUser;
    
    @Column(name="username", length=40)
    private String username;
    
    @Column(name="password",length=20)
    private String password;
    
    @ManyToOne(cascade =CascadeType.REMOVE)
    @JoinColumn(name="id_role")
    
    private Role role;

    public User(Long idUser, String username, String password, Role role) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.role = role;
    }
    
    public User() {
        this.idUser=0L;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
   
    
}
