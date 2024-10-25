package org.toure;

import java.util.logging.Logger;
import org.h2.tools.Server;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.jpa.EntityManagerFactoryAccessor;
import org.toure.Model.Equipe;
import org.toure.Model.Jeu;
import org.toure.Model.Joueur;
import org.toure.Presentation.ApplicationConsole;
import org.toure.Repository.Implementation.EquipeRepositoryImpl;
import org.toure.Repository.Implementation.JeuRepositoryImpl;
import org.toure.Repository.Implementation.JoueurRepositoryImpl;
import org.toure.Repository.interfaces.JeuRepository;
import org.toure.Repository.interfaces.JoueurRepository;
import org.toure.Service.EquipeService;
import org.toure.Service.JeuService;
import org.toure.Service.JoueurService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class App {

    private static final Logger logger = Logger.getLogger(App.class.getName());
    public static void main(String[] args) {
       ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
       /* Server h2WebServer = context.getBean("h2WebServer", Server.class);
        String h2ConsoleUrl = "http://localhost:8083";

       System.out.println("H2 Console URL: " + h2ConsoleUrl);
        logger.info("H2 Console URL: " + h2ConsoleUrl);
        */
        
        ApplicationConsole appConsole = new ApplicationConsole(context);
        appConsole.start();

    }




}
