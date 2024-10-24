package org.toure.Repository.interfaces;

import org.toure.Model.Joueur;

import java.util.List;

public interface JoueurRepository {
   public Joueur create(Joueur joueur);
   public Joueur update(Joueur joueur, long id);
   public void delete(long id);
}