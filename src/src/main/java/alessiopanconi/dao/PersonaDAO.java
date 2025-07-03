package alessiopanconi.dao;

import alessiopanconi.entities.Persona;
import alessiopanconi.exceptions.OggettoNonTrovatoException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class PersonaDAO {

    private EntityManager entityManager;
    public PersonaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void salvaPersona (Persona nuovaPersona)
    {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(nuovaPersona);
        transaction.commit();

        System.out.println("La persona"+ nuovaPersona.getNome()+""+nuovaPersona.getCognome()+" è stata salvata con successo");
    }

    public Persona trovaPersonaPerId(UUID id){
        Persona found = entityManager.find(Persona.class, id);
        if(found == null) throw new OggettoNonTrovatoException(id);
        return found;
    }
}
