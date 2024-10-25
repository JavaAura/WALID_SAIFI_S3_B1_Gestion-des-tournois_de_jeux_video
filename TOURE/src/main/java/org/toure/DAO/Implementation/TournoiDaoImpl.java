package org.toure.DAO.Implementation;


import org.toure.DAO.Interfaces.TournoiDao;
import org.toure.Model.Tournoi;
import org.toure.Repository.interfaces.TournoiRepository;

public class TournoiDaoImpl implements TournoiDao {

    protected TournoiRepository tournoiRepository;

    public TournoiDaoImpl(TournoiRepository tournoiRepository) {
        this.tournoiRepository = tournoiRepository;
    }


    @Override
    public int calculerDureeEstimeeTournoi(Long tournoiId) {
           Tournoi tournoi = tournoiRepository.findById(tournoiId);
            if (tournoi != null) {
                int nombreEquipes = tournoi.getEquipes().size();
                int dureeMoyenneMatch = tournoi.getJeu().getDureeMoyenne();
                int tempsPause = tournoi.getTempsPause();

                return (nombreEquipes * dureeMoyenneMatch) + tempsPause;
            }
            return 0;
    }
}

