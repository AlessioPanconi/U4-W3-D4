package alessiopanconi.dao;

import alessiopanconi.entities.Evento;
import alessiopanconi.entities.Partecipazioni;
import alessiopanconi.exceptions.OggettoNonTrovatoException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class PartecipazioniDAO {

    private EntityManager entityManager;
    public PartecipazioniDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void salvaPartecipazioni(Partecipazioni nuovaPartecipazione)
    {

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(nuovaPartecipazione);
        transaction.commit();

        System.out.println("La partecipazione con id: " +nuovaPartecipazione.getPartecipazioneId() + " è stata creata correttamente");
    }

    public Partecipazioni trovaPartecipazioniPerId(UUID id) {
        Partecipazioni found = entityManager.find(Partecipazioni.class, id);
        if (found == null) throw new OggettoNonTrovatoException(id);
        return found;
    }


}
