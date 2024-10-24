package org.toure;

import java.util.logging.Logger;
import org.h2.tools.Server;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.toure.Model.Equipe;
import org.toure.Model.Joueur;
import org.toure.Service.JeuService;

public class App {

    private static final Logger logger = Logger.getLogger(App.class.getName());
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Server h2WebServer = context.getBean("h2WebServer", Server.class);
        String h2ConsoleUrl = "http://localhost:8083";

        System.out.println("H2 Console URL: " + h2ConsoleUrl);
        logger.info("H2 Console URL: " + h2ConsoleUrl);

        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            logger.severe("Application interrupted: " + e.getMessage());
        }
    }






}
