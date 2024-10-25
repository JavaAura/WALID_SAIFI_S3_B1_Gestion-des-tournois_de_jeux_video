package org.toure.DAO.Implementation;

import org.toure.Model.Tournoi;
import org.toure.Repository.interfaces.TournoiRepository;

public class TournoiDaoExtension extends TournoiDaoImpl {

        public TournoiDaoExtension(TournoiRepository tournoiRepository) {
            super(tournoiRepository);
        }

        @Override
        public int calculerDureeEstimeeTournoi(Long tournoiId) {
            Tournoi tournoi = tournoiRepository.findById(tournoiId);
            if (tournoi != null) {
                int nombreEquipes = tournoi.getEquipes().size();
                int dureeMoyenneMatch = tournoi.getJeu().getDureeMoyenne();
                int difficulteJeu = tournoi.getJeu().getDifficulte();
                int tempsPause = tournoi.getTempsPause();
                int tempsCeremonie = tournoi.getTempsCeremonie();

                return (nombreEquipes * dureeMoyenneMatch * difficulteJeu) + tempsPause + tempsCeremonie;
            }
            return 0;
        }

}
