package org.toure.Service;

import org.toure.DAO.Implementation.TournoiDaoImpl;
import org.toure.Model.Equipe;
import org.toure.Model.Statut;
import org.toure.Model.Tournoi;
import org.toure.Repository.interfaces.TournoiRepository;

import java.util.List;

public class TournoiService {

    public TournoiRepository tournoiRepository;
    public TournoiDaoImpl tournoiDao;

    public  TournoiService(TournoiRepository tournoiRepository,TournoiDaoImpl tournoiDao){
        this.tournoiRepository= tournoiRepository;
        this.tournoiDao=tournoiDao;
    }

    public Tournoi getTournoi(long id){
        return  tournoiRepository.findById(id);
    }

    public void ajouterTournoi(Tournoi tournoi) {
        tournoi.setStatut(Statut.EN_COURS);

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

    public void addEquipeATournoi(Equipe equipe, Long tournoiId){
        tournoiRepository.addEquipeATournoi(equipe,tournoiId);
    }
    public  Tournoi getByname(String name){
        return  tournoiRepository.getTournoiByName(name);
    }


}
