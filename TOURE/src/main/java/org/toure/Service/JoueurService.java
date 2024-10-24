package org.toure.Service;

import org.toure.Model.Joueur;
import org.toure.Repository.interfaces.JoueurRepository;

public class JoueurService {
    private  final JoueurRepository joueurRepository;

    public JoueurService(JoueurRepository joueurRepository) {
        this.joueurRepository = joueurRepository;
    }

    public  void ajouterJour(Joueur joueur){
        joueurRepository.create(joueur);
    }
}
