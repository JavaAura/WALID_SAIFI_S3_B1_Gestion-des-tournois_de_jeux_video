package org.toure;

import java.util.logging.Logger;
import org.h2.tools.Server;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.jpa.EntityManagerFactoryAccessor;
import org.toure.Model.Equipe;
import org.toure.Model.Joueur;
import org.toure.Repository.Implementation.EquipeRepositoryImpl;
import org.toure.Repository.Implementation.JoueurRepositoryImpl;
import org.toure.Repository.interfaces.JoueurRepository;
import org.toure.Service.EquipeService;
import org.toure.Service.JoueurService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class App {

    private static final Logger logger = Logger.getLogger(App.class.getName());
    public static void main(String[] args) {
       ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Server h2WebServer = context.getBean("h2WebServer", Server.class);
        String h2ConsoleUrl = "http://localhost:8083";

        System.out.println("H2 Console URL: " + h2ConsoleUrl);
        logger.info("H2 Console URL: " + h2ConsoleUrl);




        // Création d'une instance de service pour gérer les équipes
        EquipeService equipeService = new EquipeService(new EquipeRepositoryImpl());

       // Création d'une nouvelle équipe
        Equipe nouvelleEquipe = new Equipe();
        nouvelleEquipe.setNom("der");
        nouvelleEquipe.setClassement(1);

        Equipe equipeCreee = equipeService.ajouterEquipe(nouvelleEquipe);
        System.out.println("Équipe créée : " + equipeCreee.getNom());


        JoueurRepository joueurRepository = new JoueurRepositoryImpl();
        JoueurService joueurService = new JoueurService(joueurRepository);

      //  Joueur joueur = new Joueur("Walid", 14, equipeCreee); // On associe l'équipe à ce joueur


      //  joueurService.ajouterJour(joueur);

       // System.out.println("Joueur ajouté : " + joueur.getPseudo() + " dans l'équipe " + joueur.getEquipe().getNom());

        Joueur joueur1 = new Joueur("diablooooooo", 44, equipeCreee);
        joueurService.ModifierJoueur(joueur1,6);




    }







}
