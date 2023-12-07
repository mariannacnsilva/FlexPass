package usuario.api.criariusuario.dtos;

import java.util.UUID;
import javax.validation.constraints.*;

public class UsuarioSpotDto {
    @NotEmpty private UUID CPF;
    @NotEmpty private String nomeUsuario;
    @NotEmpty private String emailUsuario;
    @NotEmpty private int telUsuario;

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
