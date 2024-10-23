package Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Equipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "nom")
    private String nom;

    @OneToMany(mappedBy = "equipe")
    private List<Joueur> joueurs;

    @ManyToMany
    @JoinTable(
            name = "tournoi_equipe",
            joinColumns = @JoinColumn(name = "equipe_id"),
            inverseJoinColumns = @JoinColumn(name = "tournoi_id")
    )
    private List<Tournoi> tournois;

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

    public List<Joueur> getJoueurs() {
        return joueurs;
    }

    public void setJoueurs(List<Joueur> joueurs) {
        this.joueurs = joueurs;
    }

    public List<Tournoi> getTournois() {
        return tournois;
    }

    public void setTournois(List<Tournoi> tournois) {
        this.tournois = tournois;
    }

    public int getClassement() {
        return classement;
    }

    public void setClassement(int classement) {
        this.classement = classement;
    }

    @Column(name = "classement")
    private int classement;


}
