package alessiopanconi.entities.EventoFigli;

import alessiopanconi.entities.Evento;
import alessiopanconi.entities.Location;
import alessiopanconi.entities.Persona;
import alessiopanconi.entities.enums.TipoEvento;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "gara_di_atletica")
public class GaraDiAtletica extends Evento {

    //RELAZIONI
    //PERSONA
    @ManyToMany
    @JoinTable(
            name = "gara_atleti",
            joinColumns = @JoinColumn(name = "gara_id"),
            inverseJoinColumns = @JoinColumn(name = "persona_id")
    )
    private List<Persona> atleti = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "id_vincitore")
    private Persona vincitore;

    //COSTRUTTORE
    public GaraDiAtletica(){}
    public GaraDiAtletica(String titolo, LocalDate dataEvento, TipoEvento tipoEvento, int numeroPartecipantiMassimo, Location location, Persona vincitore) {
        super(titolo, dataEvento, tipoEvento, numeroPartecipantiMassimo, location);
        this.vincitore = vincitore;
    }

    //GETTER
    public List<Persona> getAtleti() {
        return atleti;
    }
    public Persona getVincitore() {
        return vincitore;
    }
}
