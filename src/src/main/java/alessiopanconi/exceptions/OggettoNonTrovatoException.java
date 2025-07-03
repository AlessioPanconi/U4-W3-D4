package alessiopanconi.exceptions;

import java.util.UUID;

public class OggettoNonTrovatoException extends RuntimeException {
    public OggettoNonTrovatoException(UUID id) {
        super("L'oggetto con id: " + id + " non è stato trovato");
    }
}
