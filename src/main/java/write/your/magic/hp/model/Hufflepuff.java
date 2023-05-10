package write.your.magic.hp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "hufflepuff")
public class Hufflepuff {

    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "criador")
    private String criador;
    @Column(name = "animal")
    private String animal;
    @Column(name = "fantasma")
    private String fantasma;

    public Hufflepuff() {
    }

    public Hufflepuff(Integer id, String criador, String animal, String fantasma) {
        this.id = id;
        this.criador = criador;
        this.animal = animal;
        this.fantasma = fantasma;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCriador() {
        return criador;
    }

    public void setCriador(String criador) {
        this.criador = criador;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getFantasma() {
        return fantasma;
    }

    public void setFantasma(String fantasma) {
        this.fantasma = fantasma;
    }

    @Override
    public String toString() {
        return "Hufflepuff{" + "id=" + id + ", criador='" + criador + '\'' + ", animal='" + animal + '\'' + ", fantasma='" + fantasma + '\'' + '}';
    }
}
