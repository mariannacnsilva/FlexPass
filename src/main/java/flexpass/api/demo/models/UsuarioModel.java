package flexpass.api.demo.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//modelo para criacao de tabela e insersao de dados no BD
@Entity
@Table(name = "usuario")
public class UsuarioModel {

    @Id
    @Column (name = "cpf", unique = true)
    private int cpf;
    
    @Column (name = "nome", length = 100, nullable = false)
    @NotBlank
    private String nome;

    @Column(name = "email", nullable = false)
    @NotBlank
    private String email;

    @Column(name = "senha", nullable = false)
    @NotBlank
    @Size(min = 6)
    private String senha;

    @Column(name = "telefone", nullable = false)
    @NotBlank
    private String telefone;

    // Relacionamento de um para muitos com Reserva
    // CascadeType.ALL significa que todas as operações (persistir, mesclar, remover, atualizar) na entidade UsuarioModel também se aplicam à lista de reservas.
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<ReservasModel> reservas = new ArrayList<ReservasModel>();

    public UsuarioModel() {
    }

    public UsuarioModel(int cpf, String nome, String email, String senha, String telefone) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
    }

    public int getCpf() {
        return this.cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
}
