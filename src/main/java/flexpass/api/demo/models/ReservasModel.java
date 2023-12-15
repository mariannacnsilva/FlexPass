package flexpass.api.demo.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table (name = "reservas")
public class ReservasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id", unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cpf_usuario", referencedColumnName = "cpf")
    private UsuarioModel usuario;

    @Column(name = "data", nullable = false)
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalDate data;

    @Column(name = "status")
    private boolean status;

    // Relacionamento muitos para um com Academia
    @ManyToOne
    private AcademiaModel academia;

    public ReservasModel() {
    }

    public ReservasModel(Long id, UsuarioModel usuario, LocalDate data, boolean status) {
        this.id = id;
        this.usuario = usuario;
        this.data = data;
        this.status = status;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UsuarioModel getUsuario() {
        return this.usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    public LocalDate getData() {
        return this.data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public boolean isStatus() {
        return this.status;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
