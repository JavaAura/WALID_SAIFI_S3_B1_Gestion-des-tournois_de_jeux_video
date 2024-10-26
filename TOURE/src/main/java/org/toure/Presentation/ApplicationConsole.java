package org.toure.Presentation;

import org.springframework.context.ApplicationContext;
import org.toure.Model.Equipe;
import org.toure.Repository.interfaces.EquipeRepository;
import org.toure.Repository.interfaces.JoueurRepository;
import org.toure.Service.EquipeService;
import org.toure.Service.JoueurService;

import java.util.Scanner;

public class ApplicationConsole {

    private EquipeRepository equipeRepository;
    private EquipeService equipeService;
    private JoueurRepository joueurRepository;
    private JoueurService joueurService;

    private ApplicationContext context;

    // Initialisation des dépendances dans le constructeur
    public ApplicationConsole(ApplicationContext context) {
        this.context = context;
        this.equipeRepository = context.getBean(EquipeRepository.class);
        this.equipeService = context.getBean(EquipeService.class);
        this.joueurRepository = context.getBean(JoueurRepository.class);
        this.joueurService = context.getBean(JoueurService.class);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("\n=== Menu de gestion de tournois ===");
            System.out.println("1. Gestion des joueurs");
            System.out.println("2. Gestion des équipes");
            System.out.println("3. Gestion des tournois");
            System.out.println("0. Quitter");
            System.out.print("Veuillez choisir une option : ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    managePlayers();
                    break;
                case 2:
                    manageTeams();
                    break;
                case 3:
                   // manageTournaments();
                    break;
                case 0:
                    exit = true;
                    System.out.println("Fermeture de l'application...");
                    break;
                default:
                    System.out.println("Option invalide, veuillez réessayer.");
            }
        }
        scanner.close();
    }

    private void managePlayers() {

        PresentationJoueur presentationJoueur = new PresentationJoueur(equipeRepository, joueurRepository);


        Scanner scanner = new Scanner(System.in);
        boolean backToMenu = false;

        while (!backToMenu) {
            System.out.println("\n=== Menu Gestion des Joueurs ===");
            System.out.println("1. Ajouter un joueur");
            System.out.println("2. Supprimer un joueur");
            System.out.println("3. Modifier un joueur");
            System.out.println("4. Afficher tous les joueurs");
            System.out.println("0. Retour au menu principal");
            System.out.print("Veuillez choisir une option : ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consommer le saut de ligne

            switch (choice) {
                case 1:
                    presentationJoueur.addJoueur();
                    break;
                case 2:
                     presentationJoueur.deleteJoueur();
                    break;
                case 3:
                     presentationJoueur.updateJoueur();
                    break;
                case 4:
                    //presentationJoueur.displayAllJoueurs();
                    break;
                case 0:
                    backToMenu = true;
                    break;
                default:
                    System.out.println("Option invalide, veuillez réessayer.");
            }
        }
    }

    private void manageTeams() {
        PresentationEquipe presentationEquipe = new PresentationEquipe(equipeService);

        Scanner scanner = new Scanner(System.in);
        boolean backToMenu = false;

        while (!backToMenu) {
            System.out.println("\n=== Menu Gestion des Équipes ===");
            System.out.println("1. Ajouter une équipe");
            System.out.println("2. Supprimer une équipe");
            System.out.println("3. Modifier une équipe");
            System.out.println("4. Afficher toutes les équipes");
            System.out.println("0. Retour au menu principal");
            System.out.print("Veuillez choisir une option : ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:

                    presentationEquipe.addEquipe();
                    break;
                case 2:

                    presentationEquipe.deleteEquipe();
                    break;
                case 3:

                    presentationEquipe.updateEquipe();
                    break;
                case 4:

                    presentationEquipe.displayAllTeams();
                    break;
                case 0:
                    backToMenu = true;
                    break;
                default:
                    System.out.println("Option invalide, veuillez réessayer.");
            }
        }
    }


}
