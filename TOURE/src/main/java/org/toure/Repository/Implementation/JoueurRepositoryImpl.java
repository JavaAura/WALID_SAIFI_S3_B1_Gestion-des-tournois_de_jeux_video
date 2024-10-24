package org.toure.Repository.Implementation;


import org.toure.Model.Joueur;
import org.toure.Repository.interfaces.JoueurRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JoueurRepositoryImpl implements JoueurRepository {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("your-persistence-unit");



    @Override
    public Joueur create(Joueur joueur) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(joueur);
            transaction.commit();
            return joueur;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return null;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Joueur get(Long id) {
        return null;
    }

    @Override
    public List<Joueur> getAll() {
        return null;
    }

    @Override
    public Joueur update(Joueur joueur) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
