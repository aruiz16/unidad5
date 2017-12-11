package utng.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_module")
public class Module implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_module")
    private Long idModule;
    @Column(name="name_module", length=100)
    private String nameModule;
    @Column(name="path",length=150)
    private String path;

    public Module(Long idModule, String nameModule, String path) {
        super();
        this.idModule = idModule;
        this.nameModule = nameModule;
        this.path = path;
    }
    
    public Module() {
        this.idModule = 0L;
    }

    public Long getIdModule() {
        return idModule;
    }

    public void setIdModule(Long idModule) {
        this.idModule = idModule;
    }

    public String getNameModule() {
        return nameModule;
    }

    public void setNameModule(String nameModule) {
        this.nameModule = nameModule;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
    
}

