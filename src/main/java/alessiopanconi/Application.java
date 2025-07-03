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
    private static  final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4w3d4pu");

    public static void main(String[] args) {

        EntityManager em= emf.createEntityManager();
        EventoDAO ev = new EventoDAO(em);
        LocationDAO lc = new LocationDAO(em);
        PartecipazioniDAO pt = new PartecipazioniDAO(em);
        PersonaDAO pr = new PersonaDAO(em);

        em.close();
        emf.close();
    }
}
