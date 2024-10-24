package org.toure.Model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tournoi")
public class Tournoi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titre", nullable = false)
    private String titre;

    @ManyToOne
    @JoinColumn(name = "jeu_id", nullable = false)
    private Jeu jeu;

    @Column(name = "date_debut", nullable = false)
    private LocalDate dateDebut;

    @Column(name = "date_fin", nullable = false)
    private LocalDate dateFin;

    @Column(name = "nombre_spectateurs", nullable = false)
    private int nombreSpectateurs;

    @ManyToMany(mappedBy = "tournois", cascade = CascadeType.ALL)
    private List<Equipe> equipes;

    @Column(name = "duree_estimee")
    private int dureeEstimee;

    @Column(name = "temps_pause")
    private int tempsPause;

    @Column(name = "temps_ceremonie")
    private int tempsCeremonie;

    @Enumerated(EnumType.STRING)
    @Column(name = "statut")
    private Statut statut;

    // Constructeurs
    public Tournoi() {
    }

    public Tournoi(String titre, Jeu jeu, LocalDate dateDebut, LocalDate dateFin, int nombreSpectateurs,
                   List<Equipe> equipes, int dureeEstimee, int tempsPause, int tempsCeremonie, Statut statut) {
        this.titre = titre;
        this.jeu = jeu;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.nombreSpectateurs = nombreSpectateurs;
        this.equipes = equipes;
        this.dureeEstimee = dureeEstimee;
        this.tempsPause = tempsPause;
        this.tempsCeremonie = tempsCeremonie;
        this.statut = statut;
    }

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

    public Jeu getJeu() {
        return jeu;
    }

    public void setJeu(Jeu jeu) {
        this.jeu = jeu;
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

    public int getTempsPause() {
        return tempsPause;
    }

    public void setTempsPause(int tempsPause) {
        this.tempsPause = tempsPause;
    }

    public int getTempsCeremonie() {
        return tempsCeremonie;
    }

    public void setTempsCeremonie(int tempsCeremonie) {
        this.tempsCeremonie = tempsCeremonie;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }
}
