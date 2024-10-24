package org.toure.Model;

import com.sun.istack.NotNull;

import javax.persistence.*;


@Entity
@Table(name = "jeu")
public class Jeu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull

    @Column(name = "nom")
    private String nom;

    @NotNull
    @Column(name = "difficulte")
    private int difficulte; // Peut être représenté par un entier ou une autre énumération selon votre besoin.

    @NotNull
    @Column(name = "duree_moyenne_match")
    private int dureeMoyenneMatch; // Durée moyenne d'un match en minutes

    // Constructeurs
    public Jeu() {
    }

    public Jeu(String nom, int difficulte, int dureeMoyenneMatch) {
        this.nom = nom;
        this.difficulte = difficulte;
        this.dureeMoyenneMatch = dureeMoyenneMatch;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(int difficulte) {
        this.difficulte = difficulte;
    }

    public int getDureeMoyenneMatch() {
        return dureeMoyenneMatch;
    }

    public void setDureeMoyenneMatch(int dureeMoyenneMatch) {
        this.dureeMoyenneMatch = dureeMoyenneMatch;
    }
}
