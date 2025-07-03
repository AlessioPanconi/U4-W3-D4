package alessiopanconi.entities.EventoFigli;


import alessiopanconi.entities.Evento;
import alessiopanconi.entities.Partecipazioni;
import alessiopanconi.entities.Persona;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "gara_di_atletica")
public class GaraDiAtletica extends Evento {

    @Column(name = "atleti")
    List<Partecipazioni> atleti = this.partecipazioni;
    @Column(name = "vincitore",nullable = false)
    private Persona vincitore;

}
