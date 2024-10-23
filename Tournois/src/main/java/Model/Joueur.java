package Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Joueur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "pseudo", unique = true)
    private String pseudo;

    @NotNull
    @Column(name = "age")
    private int age;

    @ManyToOne
    @JoinColumn(name = "equipe_id")
    private Equipe equipe;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }
}
