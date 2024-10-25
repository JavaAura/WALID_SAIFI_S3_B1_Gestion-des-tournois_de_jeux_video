package org.toure.Repository.interfaces;

import org.toure.Model.Equipe;
import org.toure.Model.Jeu;

import java.util.List;

public interface JeuRepository {

    public  void create(Jeu jeu);
    public  void update(Jeu jeu, long id);

    public List<Equipe> getAll();

    public void delete(Long id);



}
