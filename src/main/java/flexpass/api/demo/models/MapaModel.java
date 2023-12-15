package flexpass.api.demo.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Table(name = "mapa")
public class MapaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mapaId", nullable = false)
    private Long mapaId;

    @OneToMany (mappedBy = "mapa", cascade =CascadeType.ALL)
    private List<AcademiaModel> academias;

    // Método para converter a lista de academias para JSON
    /*public String toJson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(this);
    }

    // Método para criar um objeto MapaModel a partir de uma string JSON
    public static MapaModel fromJson(String jsonString) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonString, MapaModel.class);
    }*/

    public MapaModel() {
    }

    public MapaModel(Long mapaId, List<AcademiaModel> academias) {
        this.mapaId = mapaId;
        this.academias = academias;
    }

    public Long mapaId() {
        return mapaId;
    }

    public void setMapaId(Long mapaId) {
        this.mapaId = mapaId;
    }

    public List<AcademiaModel> getAcademias() {
        return academias;
    }

    public void setAcademias(List<AcademiaModel> academias) {
        this.academias = academias;
    }

    
}
