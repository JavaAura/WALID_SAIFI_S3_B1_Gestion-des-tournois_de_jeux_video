package org.toure.Repository.interfaces;

import org.toure.Model.Tournoi;

import java.util.List;

public interface TournoiRepository {
    Tournoi findById(long Id);
    public  void  create(Tournoi tournoi);
    public  void  update(Tournoi tournoi,long id);
    public void delete(long id);

    public List<Tournoi> getAllTournois();



}
