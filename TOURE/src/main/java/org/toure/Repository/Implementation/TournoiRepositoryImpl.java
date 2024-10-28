package org.toure.Repository.Implementation;

import org.toure.Model.Equipe;
import org.toure.Model.Tournoi;
import org.toure.Repository.interfaces.TournoiRepository;

import javax.persistence.*;
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
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException("Error while persisting Tournoi entity", e);
        } finally {
            entityManager.close();
        }
    }




    @Override
    public void update(Tournoi tournoi, long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();


            Tournoi existTournoi = entityManager.find(Tournoi.class, id);
            if (existTournoi != null) {
                entityManager.detach(existTournoi);


                existTournoi.setTitre(tournoi.getTitre());
                existTournoi.setJeu(tournoi.getJeu());
                existTournoi.setDateDebut(tournoi.getDateDebut());
                existTournoi.setDateFin(tournoi.getDateFin());
                existTournoi.setNombreSpectateurs(tournoi.getNombreSpectateurs());
                existTournoi.setEquipes(tournoi.getEquipes());
                existTournoi.setTempsPause(tournoi.getTempsPause());
                existTournoi.setTempsCeremonie(tournoi.getTempsCeremonie());


                entityManager.merge(existTournoi);
            } else {
                throw new EntityNotFoundException("Le tournoi avec l'ID " + id + " n'existe pas.");
            }

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw e;
        } finally {
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



    @Override
    public void addEquipeATournoi(Equipe equipe, Long tournoiId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();

            if (equipe == null || equipe.getId() == null) {
                throw new RuntimeException("L'équipe à ajouter ne peut pas être nulle.");
            }

            Equipe equipeTemp = entityManager.find(Equipe.class, equipe.getId());
            Tournoi tournoi = entityManager.find(Tournoi.class, tournoiId);

            if (equipeTemp == null) {
                throw new RuntimeException("L'équipe avec l'ID " + equipe.getId() + " n'existe pas.");
            }
            if (tournoi == null) {
                throw new RuntimeException("Le tournoi avec l'ID " + tournoiId + " n'existe pas.");
            }

            if (!tournoi.getEquipes().contains(equipeTemp)) {
                tournoi.getEquipes().add(equipeTemp);
            } else {
                throw new RuntimeException("L'équipe est déjà ajoutée au tournoi.");
            }

            entityManager.merge(tournoi);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException("Erreur lors de l'ajout de l'équipe au tournoi : " + e.getMessage(), e);
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Tournoi getTournoiByName(String name) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Tournoi tournoi = null;

        try {
            tournoi = entityManager.createQuery("SELECT t FROM Tournoi t WHERE t.titre = :name", Tournoi.class)
                    .setParameter("name", name)
                    .getSingleResult();
        } catch (NoResultException e) {
            // Return null when no result is found
            return null;
        } catch (PersistenceException e) {
            throw new RuntimeException("Erreur lors de la récupération du tournoi par nom", e);
        } catch (Exception e) {
            // Handle other exceptions
            throw new RuntimeException("Erreur inattendue lors de la récupération du tournoi par nom", e);
        } finally {
            entityManager.close();
        }

        return tournoi;
    }



}
