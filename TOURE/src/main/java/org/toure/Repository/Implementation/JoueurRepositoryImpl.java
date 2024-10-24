package org.toure.Repository.Implementation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.toure.Model.Joueur;
import org.toure.Repository.interfaces.JoueurRepository;

import java.util.List;
import javax.persistence.*;

public class JoueurRepositoryImpl implements JoueurRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public JoueurRepositoryImpl(){

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tourePU");
        this.entityManager = emf.createEntityManager();

    }


    @Override
    public Joueur create(Joueur joueur) {
            entityManager.getTransaction().begin();
            entityManager.persist(joueur);
            entityManager.getTransaction().commit();
            return joueur;

    }


    @Override
    public Joueur update(Joueur joueur, long id) {
        try {
            entityManager.getTransaction().begin();
            Joueur joueurToUpdate = entityManager.find(Joueur.class, id);

            joueurToUpdate.setPseudo(joueur.getPseudo());
            joueurToUpdate.setAge(joueur.getAge());
            joueurToUpdate.setEquipe(joueur.getEquipe());

            entityManager.merge(joueurToUpdate);
            entityManager.getTransaction().commit();
            return joueurToUpdate;

        } catch (Exception e) {
            throw e;
        }
    }


    @Override
    public void delete(long id) {
        try {
            entityManager.getTransaction().begin();
            Joueur joueurToDelete = entityManager.find(Joueur.class, id);

            entityManager.remove(joueurToDelete);
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            throw e;
        }
    }
}

