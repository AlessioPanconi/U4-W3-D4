package alessiopanconi.entities.EventoFigli;

import alessiopanconi.entities.Evento;
import alessiopanconi.entities.Location;
import alessiopanconi.entities.enums.Genere;
import alessiopanconi.entities.enums.TipoEvento;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "concerto")
public class Concerto extends Evento {

    @Column(name = "genere",nullable = false)
    @Enumerated(EnumType.STRING)
    private Genere genere;
    @Column(name = "in_streaming",nullable = false)
    private boolean inStreaming;

    //COSTRUTTORI
    public Concerto(){}
    public Concerto(String titolo, LocalDate dataEvento, TipoEvento tipoEvento, int numeroPartecipantiMassimo, Location location, Genere genere, boolean inStreaming) {
        super(titolo, dataEvento, tipoEvento, numeroPartecipantiMassimo, location);
        this.genere = genere;
        this.inStreaming = inStreaming;
    }

    //GETTER
    public Genere getGenere() {
        return genere;
    }
    public boolean isInStreaming() {
        return inStreaming;
    }

    //SETTER
    public void setGenere(Genere genere) {
        this.genere = genere;
    }
    public void setInStreaming(boolean inStreaming) {
        this.inStreaming = inStreaming;
    }
}
