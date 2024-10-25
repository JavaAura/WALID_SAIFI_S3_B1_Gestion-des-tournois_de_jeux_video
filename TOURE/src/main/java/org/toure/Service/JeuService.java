package org.toure.Service;

import org.toure.Model.Jeu;
import org.toure.Model.Joueur;
import org.toure.Repository.interfaces.JeuRepository;
import org.toure.Repository.interfaces.JoueurRepository;

public class JeuService {
    public JeuRepository jeuRepository;

    public JeuService(JeuRepository jeuRepository) {
        this.jeuRepository = jeuRepository;
    }

    public void ajouterJeu(Jeu jeu) {
        jeuRepository.create(jeu);
    }

    public void ModifierJeu(Jeu jeu,long id) {

         jeuRepository.update(jeu,id);
    }

    public  void SupprimerJeu(long id){
        jeuRepository.delete(id);
    }


}
