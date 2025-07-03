package alessiopanconi.exceptions;

public class OggettoNonTrovatoException extends RuntimeException {
    public OggettoNonTrovatoException(long id) {
        super("L'oggetto con id: " + id + " non è stato trovato");
    }
}
