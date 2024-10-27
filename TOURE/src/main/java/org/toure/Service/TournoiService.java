package org.toure.Service;

import org.toure.Model.Tournoi;
import org.toure.Repository.interfaces.TournoiRepository;

import java.util.List;

public class TournoiService {

    public TournoiRepository tournoiRepository;

    public  TournoiService(TournoiRepository tournoiRepository){
        this.tournoiRepository= tournoiRepository;
    }

    public Tournoi getTournoi(long id){
        return  tournoiRepository.findById(id);
    }

    public  void  ajouterTournoi(Tournoi tournoi){
            tournoiRepository.create(tournoi);
    }
    public  void  ModifierTournoi(Tournoi tournoi,long id){
        tournoiRepository.update(tournoi,id);
    }

    public  void SuppremeTouroi(long id){
         tournoiRepository.delete(id);
    }

    public List<Tournoi> getAllTournois() {
        return tournoiRepository.getAllTournois();
    }


}
