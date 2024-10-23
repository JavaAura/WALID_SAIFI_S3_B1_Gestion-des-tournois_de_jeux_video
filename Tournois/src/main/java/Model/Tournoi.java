package Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Tournoi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "titre", unique = true)
    private String titre;

     @ManyToOne
       @JoinColumn(name = "jeu_id")
       private Jeu jeu;


    @Column(name = "date_debut")
    private LocalDate dateDebut;

    @Column(name = "date_fin")
    private LocalDate dateFin;

    @Column(name = "nombre_spectateurs")
    private int nombreSpectateurs;

    @ManyToMany
    @JoinTable(
            name = "tournoi_equipe",
            joinColumns = @JoinColumn(name = "tournoi_id"),
            inverseJoinColumns = @JoinColumn(name = "equipe_id")
    )
    private List<Equipe> equipes;

    @Column(name = "duree_estimee")
    private int dureeEstimee;

    @Column(name = "temps_pause_entre_matchs")
    private int tempsPauseEntreMatchs;

    @Column(name = "temps_ceremonie")
    private int tempsCeremonie;

    @Enumerated(EnumType.STRING)
    @Column(name = "statut")
    private StatutTournoi statut;

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public int getNombreSpectateurs() {
        return nombreSpectateurs;
    }

    public void setNombreSpectateurs(int nombreSpectateurs) {
        this.nombreSpectateurs = nombreSpectateurs;
    }

    public List<Equipe> getEquipes() {
        return equipes;
    }

    public void setEquipes(List<Equipe> equipes) {
        this.equipes = equipes;
    }

    public int getDureeEstimee() {
        return dureeEstimee;
    }

    public void setDureeEstimee(int dureeEstimee) {
        this.dureeEstimee = dureeEstimee;
    }

    public int getTempsPauseEntreMatchs() {
        return tempsPauseEntreMatchs;
    }

    public void setTempsPauseEntreMatchs(int tempsPauseEntreMatchs) {
        this.tempsPauseEntreMatchs = tempsPauseEntreMatchs;
    }

    public int getTempsCeremonie() {
        return tempsCeremonie;
    }

    public void setTempsCeremonie(int tempsCeremonie) {
        this.tempsCeremonie = tempsCeremonie;
    }

    public StatutTournoi getStatut() {
        return statut;
    }

    public void setStatut(StatutTournoi statut) {
        this.statut = statut;
    }
}
