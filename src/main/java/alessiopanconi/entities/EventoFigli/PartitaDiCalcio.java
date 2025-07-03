package alessiopanconi.entities.EventoFigli;

import alessiopanconi.entities.Evento;
import alessiopanconi.entities.Location;
import alessiopanconi.entities.enums.TipoEvento;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "partita_di_calcio")
@NamedQuery(name = "getPartiteVinteInCasa", query = "SELECT a FROM PartitaDiCalcio a Where LOWER(a.squadraVincente) = LOWER(a.squadraCasa)")
@NamedQuery(name = "getPartiteVinteInTrasferta", query = "SELECT a FROM PartitaDiCalcio a Where LOWER(a.squadraVincente) = LOWER(a.squadraOspite)")
@NamedQuery(name = "getPartitePareggiate", query = "SELECT a FROM PartitaDiCalcio a Where a.squadraVincente IS NULL")
public class PartitaDiCalcio extends Evento {

    @Column(name = "squadra_casa",nullable = false)
    private String squadraCasa;
    @Column(name = "squadra_ospite",nullable = false)
    private String squadraOspite;
    @Column(name = "squadra_vincente")
    private String squadraVincente;
    @Column(name = "n_gol_casa",nullable = false)
    private int numeroGolCasa;
    @Column(name = "n_gol_ospiti",nullable = false)
    private int numeroGolOspiti;

    //Costruttori
    public PartitaDiCalcio (){}
    public PartitaDiCalcio(String titolo, LocalDate dataEvento, TipoEvento tipoEvento, int numeroPartecipantiMassimo, Location location, String squadraCasa, String squadraOspite, String squadraVincente, int numeroGolCasa, int numeroGolOspiti) {
        super(titolo, dataEvento, tipoEvento, numeroPartecipantiMassimo, location);
        this.squadraCasa = squadraCasa;
        this.squadraOspite = squadraOspite;
        this.squadraVincente = squadraVincente;
        this.numeroGolCasa = numeroGolCasa;
        this.numeroGolOspiti = numeroGolOspiti;
    }

    //GETTER
    public String getSquadraCasa() {
        return squadraCasa;
    }
    public String getSquadraOspite() {
        return squadraOspite;
    }
    public String getSquadraVincente() {
        return squadraVincente;
    }
    public int getNumeroGolCasa() {
        return numeroGolCasa;
    }
    public int getNumeroGolOspiti() {
        return numeroGolOspiti;
    }

    //SETTER
    public void setSquadraCasa(String squadraCasa) {
        this.squadraCasa = squadraCasa;
    }
    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }
    public void setSquadraVincente(String squadraVincente) {
        this.squadraVincente = squadraVincente;
    }
    public void setNumeroGolCasa(int numeroGolCasa) {
        this.numeroGolCasa = numeroGolCasa;
    }
    public void setNumeroGolOspiti(int numeroGolOspiti) {
        this.numeroGolOspiti = numeroGolOspiti;
    }


}
