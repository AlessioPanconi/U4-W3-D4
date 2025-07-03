package alessiopanconi.dao;

import alessiopanconi.entities.Location;
import alessiopanconi.exceptions.OggettoNonTrovatoException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class LocationDAO {

    private EntityManager entityManager;
    public LocationDAO(EntityManager entityManager){this.entityManager = entityManager;}

    public void salvaLocation(Location nuovaLocation)
    {
        //1
        EntityTransaction transaction = entityManager.getTransaction();
        //2
        transaction.begin();
        //3
        entityManager.persist(nuovaLocation);
        //4
        transaction.commit();

        System.out.println("La location: " + nuovaLocation.getCitta() + " è stata creata correttamente");
    }

    public Location trovaLocationPerId (UUID id)
    {
        Location found = entityManager.find(Location.class, id);
        if (found == null) throw new OggettoNonTrovatoException(id);
        return found;
    }

}
