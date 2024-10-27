package org.toure.Repository.Implementation;

import org.toure.Model.Tournoi;
import org.toure.Repository.interfaces.TournoiRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

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

    @Override
    public void create(Tournoi tournoi) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(tournoi);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            throw e;
        }finally {
            entityManager.close();
        }
    }

    @Override
    public void update(Tournoi tournoi,long id) {
       EntityManager entityManager = entityManagerFactory.createEntityManager();
       try {
           entityManager.getTransaction().begin();
           Tournoi existTounoi = entityManager.find(Tournoi.class,id);
           existTounoi.setTitre(tournoi.getTitre());
           existTounoi.setJeu(tournoi.getJeu());
           existTounoi.setDateDebut(tournoi.getDateDebut());
           existTounoi.setDateFin(tournoi.getDateFin());
           existTounoi.setNombreSpectateurs(tournoi.getNombreSpectateurs());
           existTounoi.setEquipes(tournoi.getEquipes());
           existTounoi.setTempsPause(tournoi.getTempsPause());
           existTounoi.setTempsCeremonie(tournoi.getTempsCeremonie());
           entityManager.merge(existTounoi);
           entityManager.getTransaction().commit();

       }catch (Exception e){
           throw e;
       }finally {
           entityManager.close();
       }

    }

    @Override
    public void delete(long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Tournoi tournoi = entityManager.find(Tournoi.class, id);
            if (tournoi != null) {
                entityManager.remove(tournoi);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw e;
        } finally {
            entityManager.close();
        }
    }
    @Override
    public List<Tournoi> getAllTournois() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Tournoi> tournois;
        try {
            tournois = entityManager.createQuery("SELECT t FROM Tournoi t", Tournoi.class).getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la récupération des tournois", e);
        } finally {
            entityManager.close();
        }
        return tournois;
    }

}
