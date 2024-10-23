package Model;

import Model.*;
import Model.Jeu;
import Model.StatutTournoi;

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
    private String titre;

   /* @ManyToOne
    @JoinColumn(name = "jeu_id")
    private Jeu jeu;
*/

    private LocalDate dateDebut;

    private LocalDate dateFin;

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



}
