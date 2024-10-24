package org.toure.Repository.Implementation;

import org.toure.Model.Joueur;
import org.toure.Repository.interfaces.JoueurRepository;

import java.util.List;
import javax.persistence.*;

public class JoueurRepositoryImpl implements JoueurRepository {


    private EntityManagerFactory entityManagerFactory;

    public JoueurRepositoryImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public Joueur create(Joueur joueur) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(joueur);
            transaction.commit();
            return joueur;
        }  catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            entityManager.close();
        }
    }

    public Joueur get(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            return entityManager.find(Joueur.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            entityManager.close();
        }
    }
    public List<Joueur> getAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            TypedQuery<Joueur> query = entityManager.createQuery("SELECT j FROM Joueur j", Joueur.class);
            return query.getResultList(); // Get all players from the database
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            entityManager.close();
        }
    }

    public Joueur update(Joueur joueur) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Joueur updatedJoueur = entityManager.merge(joueur);
            transaction.commit();
            return updatedJoueur;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            entityManager.close();
        }
    }
    @Override
    public void delete(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Joueur joueur = entityManager.find(Joueur.class, id);
            if (joueur != null) {
                entityManager.remove(joueur);
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            entityManager.close();
        }
    }
}

