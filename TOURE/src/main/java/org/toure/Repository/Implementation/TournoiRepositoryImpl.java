package org.toure.Repository.Implementation;

import org.toure.Model.Tournoi;
import org.toure.Repository.interfaces.TournoiRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TournoiRepositoryImpl implements TournoiRepository {


    private EntityManagerFactory entityManagerFactory;

    public TournoiRepositoryImpl() {

        entityManagerFactory = Persistence.createEntityManagerFactory("tourePU");
    }

    @Override
    public Tournoi findById(long Id) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Tournoi tournoi;
        try {
            tournoi = entityManager.find(Tournoi.class, Id);
        } catch (Exception e) {
            throw e;
        }
        return tournoi;
    }
}
