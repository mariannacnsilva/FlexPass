/*package flexpass.api.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "avaliações")
public class AvaliacaoModel {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idAvaliacao;

    @Column(name = "comentario", length = 200)
    private String comentario;

    @Column(name = "nota", nullable = false)
    @NotBlank
    private float nota;

    @ManyToOne
    @JoinColumn(name = "avaliacao")
    private AcademiaModel academia;

    public AvaliacaoModel() {
    }

    public AvaliacaoModel(Long idAvaliacao, String comentario, float nota) {
        this.idAvaliacao = idAvaliacao;
        this.comentario = comentario;
        this.nota = nota;
    }

    public Long getIdAvaliacao() {
        return this.idAvaliacao;
    }

    public void setIdAvaliacao(Long idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public String getComentario() {
        return this.comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public float getNota() {
        return this.nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

}
*/