package usuario.api.criariusuario.Models;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "tabelaUsuarios")
public class UsuarioSpotModel implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(nullable = false, unique = true, length = 6)
    private UUID CPF;
    @Column(nullable = false, unique = true, length = 130)
    private String nomeUsuario;
    @Column(nullable = false, unique = true, length = 6)
    private String emailUsuario;
    @Column(nullable = false, unique = true, length = 6)
    private int telUsuario;

    public UUID getCPF() {
        return this.CPF;
    }

    public void setCPF(UUID CPF) {
        this.CPF = CPF;
    }

    public String getNomeUsuario() {
        return this.nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEmailUsuario() {
        return this.emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public int getTelUsuario() {
        return this.telUsuario;
    }

    public void setTelUsuario(int telUsuario) {
        this.telUsuario = telUsuario;
    }

}
