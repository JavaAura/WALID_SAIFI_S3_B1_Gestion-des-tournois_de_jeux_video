package org.toure.Model;

import com.sun.istack.NotNull;

import javax.persistence.*;


@Entity
@Table(name = "joueur")
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
    @JoinColumn(name = "equipe_id", nullable = true)
    private Equipe equipe;

    public Joueur() {
    }

    public Joueur(String pseudo, int age, Equipe equipe) {
        this.pseudo = pseudo;
        this.age = age;
        this.equipe = equipe;
    }

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