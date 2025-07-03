package alessiopanconi.entities;

import alessiopanconi.entities.enums.Stato;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "partecipazioni")

public class Partecipazioni {
    @Id
    @GeneratedValue
    @Column(name = "partecipazione_id")
    private UUID partecipazioneId;
    @Column(name = "stato", nullable = false)
    @Enumerated(EnumType.STRING)
    private Stato stato;

    //RELAZIONI
    //evento
    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;
    //persona
    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;

    //COSTRUTTORI
    public Partecipazioni() {
    }
    public Partecipazioni( Stato stato, Evento evento, Persona persona) {
        this.stato = stato;
        this.evento = evento;
        this.persona = persona;
    }

    //GETTER
    public UUID getPartecipazioneId() {
        return partecipazioneId;
    }
    public Stato getStato() {
        return stato;
    }
    public Evento getEvento() {
        return evento;
    }
    public Persona getPersona() {
        return persona;
    }

    //SETTER
    public void setStato(Stato stato) {
        this.stato = stato;
    }
}
