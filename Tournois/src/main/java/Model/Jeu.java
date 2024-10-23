package Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Jeu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "nom", unique = true)
    private String nom;

    @NotNull
    @Column(name = "difficulte")
    private int difficulte;

    @Column(name = "duree_moyenne_match")
    private int dureeMoyenneMatch;

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
