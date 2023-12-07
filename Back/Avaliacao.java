package Back;

public class Avaliacao {
    private String comentario;
    private float nota;

    public Avaliacao() {
    }

    public Avaliacao(String comentario, float nota) {
        this.comentario = comentario;
        this.nota = nota;
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

    public String toString() {
        return "{" +
            " comentario='" + getComentario() + "'" +
            ", nota='" + getNota() + "'" +
            "}";
    }

}
