package org.toure.Repository.interfaces;

import org.toure.Model.Joueur;

import java.util.List;

public interface JoueurRepository {
    Joueur create(Joueur joueur);
    Joueur get(Long id);
    List<Joueur> getAll();
    Joueur update(Joueur joueur);
    void delete(Long id);
}