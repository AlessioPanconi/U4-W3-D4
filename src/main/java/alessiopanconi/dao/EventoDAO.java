package alessiopanconi.dao;


import alessiopanconi.entities.Evento;
import alessiopanconi.entities.EventoFigli.Concerto;
import alessiopanconi.entities.EventoFigli.PartitaDiCalcio;
import alessiopanconi.entities.enums.Genere;
import alessiopanconi.exceptions.OggettoNonTrovatoException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
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

    public Evento trovaEventoPerId(long id) {
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

    public List<Concerto> getConcertiInStreaming(boolean inStreaming) {
        TypedQuery<Concerto> query = entityManager.createQuery("SELECT a FROM Concerto a WHERE a.inStreaming = :streaming", Concerto.class);
        query.setParameter("streaming", inStreaming);
        return query.getResultList();
    }

    public List<Concerto> getConcertiPerGenere (Genere genere){
        TypedQuery<Concerto> query = entityManager.createQuery("SELECT a FROM Concerto a WHERE a.genere = :genere", Concerto.class);
        query.setParameter("genere" , genere);
        return query.getResultList();
    }

    public List<PartitaDiCalcio> getPartiteVinteInCasa (){
        TypedQuery<PartitaDiCalcio> query = entityManager.createNamedQuery("getPartiteVinteInCasa", PartitaDiCalcio.class);
        return query.getResultList();
    }
    public List<PartitaDiCalcio> getPartiteVinteInTrasferta (){
        TypedQuery<PartitaDiCalcio> query = entityManager.createNamedQuery("getPartiteVinteInTrasferta", PartitaDiCalcio.class);
        return query.getResultList();
    }
    public List<PartitaDiCalcio> getPartitePareggiate (){
        TypedQuery<PartitaDiCalcio> query = entityManager.createNamedQuery("getPartitePareggiate", PartitaDiCalcio.class);
        return query.getResultList();
    }
}
