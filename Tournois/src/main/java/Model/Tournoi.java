import Model.Equipe;
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

    @ManyToOne
    @JoinColumn(name = "jeu_id")
    private Jeu jeu;

    @NotNull
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

    private int dureeEstimee;

    private int tempsPauseEntreMatchs;

    private int tempsCeremonie;

    @Enumerated(EnumType.STRING)
    private StatutTournoi statut;


}
