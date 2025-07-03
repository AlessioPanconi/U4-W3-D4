package alessiopanconi.dao;


import alessiopanconi.entities.Evento;
import alessiopanconi.exceptions.OggettoNonTrovatoException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class EventoDAO {

    private EntityManager entityManager;
    public EventoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void salvaEvento(Evento nuovoEvento)
    {
        //1
        EntityTransaction transaction = entityManager.getTransaction();
        //2
        transaction.begin();
        //3
        entityManager.persist(nuovoEvento);
        //4
        transaction.commit();

        System.out.println("L'evento" + nuovoEvento.getTitolo() + " è stato creato correttamente");
    }

    public Evento trovaEventoPerId(UUID id) {
        Evento found = entityManager.find(Evento.class, id);
        if (found == null) throw new OggettoNonTrovatoException(id);
        return found;
    }

    public void trovaEdElimina (long id ) {

        Evento found = this.trovaEventoPerId(id);

        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        entityManager.remove(found);

        transaction.commit();

        System.out.println("L'evento :" + found.getTitolo() + " è stato eliminato");

    }

}
