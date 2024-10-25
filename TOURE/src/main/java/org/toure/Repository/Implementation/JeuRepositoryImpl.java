package org.toure.Repository.Implementation;

import org.toure.Model.Equipe;
import org.toure.Model.Jeu;
import org.toure.Repository.interfaces.JeuRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class JeuRepositoryImpl implements JeuRepository {
    private EntityManagerFactory entityManagerFactory;

    public  JeuRepositoryImpl(){
        this.entityManagerFactory = Persistence.createEntityManagerFactory("tourePU");
    }

    public  void create(Jeu jeu){
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(jeu);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public void  update(Jeu jeu, long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Jeu existJeu = entityManager.find(Jeu.class,id);
            existJeu.setNom(jeu.getNom());
            existJeu.setDifficulte(jeu.getDifficulte());
            existJeu.setDureeMoyenneMatch(jeu.getDureeMoyenneMatch());
            entityManager.merge(existJeu);
            entityManager.getTransaction().commit();

        }catch (Exception e){
            throw e;
        }finally {
            entityManager.close();
        }
    }

    @Override
    public List<Equipe> getAll() {
        return null;
    }

    @Override
    public void delete(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Jeu jeu = entityManager.find(Jeu.class,id);
            if(jeu != null){
                entityManager.remove(jeu);
            }
            entityManager.getTransaction().commit();


        }catch (Exception e){
            throw  e;
        }

    }


}
