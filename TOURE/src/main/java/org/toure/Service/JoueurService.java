package org.toure.Service;

import org.toure.Model.Joueur;
import org.toure.Repository.interfaces.JoueurRepository;

public class JoueurService {
    private  final JoueurRepository joueurRepository;

    public JoueurService(JoueurRepository joueurRepository) {
        this.joueurRepository = joueurRepository;
    }

    public  Joueur ajouterJour(Joueur joueur){
      return   joueurRepository.create(joueur);
    }


    public  Joueur ModifierJoueur(Joueur joueur, long id){
        return  joueurRepository.update(joueur,id);
    }
    public  void  SuppremeJoueur(long id){
        joueurRepository.delete(id);
    }
}
