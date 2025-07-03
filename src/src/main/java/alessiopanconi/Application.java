package alessiopanconi;

import alessiopanconi.dao.EventoDAO;
import alessiopanconi.dao.LocationDAO;
import alessiopanconi.dao.PartecipazioniDAO;
import alessiopanconi.dao.PersonaDAO;
import alessiopanconi.entities.Evento;
import alessiopanconi.entities.Location;
import alessiopanconi.entities.Partecipazioni;
import alessiopanconi.entities.Persona;
import alessiopanconi.entities.enums.Sesso;
import alessiopanconi.entities.enums.Stato;
import alessiopanconi.entities.enums.TipoEvento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static  final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4w3d3pu");

    public static void main(String[] args) {

        EntityManager em= emf.createEntityManager();

        EventoDAO ev = new EventoDAO(em);
        LocationDAO lc = new LocationDAO(em);
        PartecipazioniDAO pt = new PartecipazioniDAO(em);
        PersonaDAO pr = new PersonaDAO(em);

        Location arenaDiVerona = new Location("Arena di Verona","Verona");
        Location colosseo = new Location("Colosseo", "Roma");

        lc.salvaLocation(arenaDiVerona);
        lc.salvaLocation(colosseo);

        Evento balloDelQuaqua = new Evento("Ballo del QUAQUA",LocalDate.of(2025, 5, 12), TipoEvento.PUBBLICO, 200 , arenaDiVerona );
        Evento valzer = new Evento("Valzer",LocalDate.of(2022, 1, 25),TipoEvento.PRIVATO,20,colosseo);
        Evento concerto = new Evento("Concerto",LocalDate.of(2025, 8, 2),TipoEvento.PUBBLICO,3000,colosseo);

        ev.salvaEvento(balloDelQuaqua);
        ev.salvaEvento(valzer);
        ev.salvaEvento(concerto);

        Persona pippo = new Persona("Pippo","Ambarabat","pippo.ambarabat@gmail.com",LocalDate.of(1969,2,19), Sesso.M);
        Persona pino = new Persona("Pino","Antonacci","pino.antonacci@gmail.com",LocalDate.of(2000,3,28),Sesso.M);
        Persona marika = new Persona("Marika","Antonietta","marika.antonietta@gmail.com",LocalDate.of(2010,10,10),Sesso.F);

        pr.salvaPersona(pippo);
        pr.salvaPersona(pino);
        pr.salvaPersona(marika);

        Partecipazioni p1 = new Partecipazioni(Stato.CONFERMATA,balloDelQuaqua,pino);
        Partecipazioni p2 = new Partecipazioni(Stato.DA_CONFERMARE,concerto,pino);
        Partecipazioni p3 = new Partecipazioni(Stato.CONFERMATA,valzer,marika);

        pt.salvaPartecipazioni(p1);
        pt.salvaPartecipazioni(p2);
        pt.salvaPartecipazioni(p3);

        em.close();
        emf.close();
    }
}
