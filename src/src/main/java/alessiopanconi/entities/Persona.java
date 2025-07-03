package alessiopanconi.entities;

import alessiopanconi.entities.enums.Sesso;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "persona")
public class Persona {
    @Id
    @GeneratedValue
    @Column(name = "persona_id",nullable = false)
    private UUID id;
    @Column(name = "nome",nullable = false)
    private String nome;
    @Column(name="cognome",nullable = false)
    private String cognome;
    @Column(name = "email",nullable = false)
    private  String email;
    @Column(name = "data_di_nascita",nullable = false)
    private LocalDate dataDiNascita;
    @Column(name = "sesso")
    @Enumerated(EnumType.STRING)
    private Sesso sesso;

    //RELAZIONI
    //persona
    @OneToMany(mappedBy = "persona")
    private List<Partecipazioni> partecipazioni;

    //COSTRUTTORI
    public Persona() {
    }
    public Persona(String nome, String cognome, String email, LocalDate dataDiNascita, Sesso sesso) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataDiNascita = dataDiNascita;
        this.sesso = sesso;
    }

    //GETTER
    public UUID getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getCognome() {
        return cognome;
    }
    public String getEmail() {
        return email;
    }
    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }
    public Sesso getSesso() {
        return sesso;
    }
    public List<Partecipazioni> getPartecipazioni() {
        return partecipazioni;
    }

    //SETTER
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }
    public void setSesso(Sesso sesso) {
        this.sesso = sesso;
    }
}
