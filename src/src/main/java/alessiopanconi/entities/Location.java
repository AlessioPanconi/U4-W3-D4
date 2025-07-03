package alessiopanconi.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue
    @Column(name = "blog_id")
    private UUID id;
    @Column(name = "nome",nullable = false)
    private String nome;
    @Column(name = "citta",nullable = false)
    private String citta;

    //RELAZIONI
    //evento
    @OneToMany(mappedBy = "location")
    private List<Evento> eventi;

    //COSTRUTTORI
    public Location() {
    }
    public Location(String nome, String citta) {
        this.nome = nome;
        this.citta = citta;
    }

    //GETTER
    public UUID getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getCitta() {
        return citta;
    }
    public List<Evento> getEventi() {
        return eventi;
    }

    //SETTER
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setCitta(String citta) {
        this.citta = citta;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", citta='" + citta + '\'' +
                ", eventi=" + eventi +
                '}';
    }
}
