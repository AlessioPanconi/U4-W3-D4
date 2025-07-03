package alessiopanconi.entities;

import alessiopanconi.entities.enums.TipoEvento;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "evento")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Evento {

    @Id
    @GeneratedValue
    @Column(name = "evento_id")
    protected long id;
    @Column(name = "titolo",nullable = false)
    protected String titolo;
    @Column(name = "data_evento",nullable = false)
    protected LocalDate dataEvento;
    @Column(name = "tipo_evento",nullable = false)
    @Enumerated(EnumType.STRING)
    protected TipoEvento tipoEvento;
    @Column(name = "numero_partecipanti_massimo")
    protected int numeroPartecipantiMassimo;

    //RELAZIONI
    //location
    @ManyToOne
    @JoinColumn(name = "id_location")
    protected Location location;
    //partecipazioni
    @OneToMany(mappedBy = "evento")
    protected List<Partecipazioni> partecipazioni;

    //COSTRUTTORI
    public Evento(){}

    public Evento(String titolo, LocalDate dataEvento, TipoEvento tipoEvento, int numeroPartecipantiMassimo, Location location) {
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.tipoEvento = tipoEvento;
        this.numeroPartecipantiMassimo = numeroPartecipantiMassimo;
        this.location = location;
    }

    //GETTER

    public long getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }
    public LocalDate getDataEvento() {
        return dataEvento;
    }
    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }
    public int getNumeroPartecipantiMassimo() {
        return numeroPartecipantiMassimo;
    }
    public Location getLocation() {
        return location;
    }
    public List<Partecipazioni> getPartecipazioni() {
        return partecipazioni;
    }

    //SETTER
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }
    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }
    public void setNumeroPartecipantiMassimo(int numeroPartecipantiMassimo) {
        this.numeroPartecipantiMassimo = numeroPartecipantiMassimo;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", dataEvento=" + dataEvento +
                ", tipoEvento=" + tipoEvento +
                ", numeroPartecipantiMassimo=" + numeroPartecipantiMassimo +
                ", location=" + location +
                '}';
    }
}
