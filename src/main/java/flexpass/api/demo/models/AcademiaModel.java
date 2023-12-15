package flexpass.api.demo.models;

import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity //informar que é para tratar a classe como uma tabela
@Table(name = "academia") //informar que é para criar uma tabela com nome academia
public class AcademiaModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // define o padrao de criacao automatica de id
    @Column(name = "gymID", unique = true)
    private Long gymID;

    @Column(name = "gymNome", length = 100, nullable = false)
    @NotBlank
    private String gymNome;

    @Column(name = "gymEndereco", length = 200, nullable = false)
    @NotBlank
    private String gymEndereco;

    @Column(name = "limiteUsuarios", nullable = false)
    private int limiteUsuarios;

    @Column(name = "horarioAbertura", nullable = false)
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime horarioAbertura;

    @Column(name = "horarioFechamento", nullable = false)
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime horarioFechamento;

    // Relacionamento um(reserva) para muitos(academia) com ReservasModel
    @OneToMany(mappedBy = "academia", cascade = CascadeType.ALL)
    private List<ReservasModel> reservas;

    // Relacionamento uma academia ligada a muitas avaliacoes
    /*@OneToMany(mappedBy = "academia", cascade = CascadeType.ALL)
    private List<AvaliacaoModel> avaliacao;*/

    @ManyToOne
    @JoinColumn(name = "mapaId")
    private MapaModel mapa;

    public AcademiaModel() {
    }

    public AcademiaModel(Long gymID, String gymNome, String gymEndereco, int limiteUsuarios, LocalTime horarioAbertura, LocalTime horarioFechamento) {
        this.gymID = gymID;
        this.gymNome = gymNome;
        this.gymEndereco = gymEndereco;
        this.limiteUsuarios = limiteUsuarios;
        this.horarioAbertura = horarioAbertura;
        this.horarioFechamento = horarioFechamento;
    }

    public Long getGymID() {
        return this.gymID;
    }

    public void setGymID(Long gymID) {
        this.gymID = gymID;
    }

    public String getGymNome() {
        return this.gymNome;
    }

    public void setGymNome(String gymNome) {
        this.gymNome = gymNome;
    }

    public String getGymEndereco() {
        return this.gymEndereco;
    }

    public void setGymEndereco(String gymEndereco) {
        this.gymEndereco = gymEndereco;
    }

    public int getLimiteUsuarios() {
        return this.limiteUsuarios;
    }

    public void setLimiteUsuarios(int limiteUsuários) {
        this.limiteUsuarios = limiteUsuários;
    }

    public LocalTime getHorarioAbertura() {
        return this.horarioAbertura;
    }

    public void setHorarioAbertura(LocalTime horarioAbertura) {
        this.horarioAbertura = horarioAbertura;
    }

    public LocalTime getHorarioFechamento() {
        return this.horarioFechamento;
    }

    public void setHorarioFechamento(LocalTime horarioFechamento) {
        this.horarioFechamento = horarioFechamento;
    }

}