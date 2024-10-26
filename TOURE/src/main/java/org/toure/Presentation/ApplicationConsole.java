package org.toure.Presentation;

import org.springframework.context.ApplicationContext;
import org.toure.Model.Equipe;
import org.toure.Repository.interfaces.EquipeRepository;
import org.toure.Repository.interfaces.JoueurRepository;
import org.toure.Service.EquipeService;
import org.toure.Service.JoueurService;

import java.util.List;
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
                    manageTournaments();
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
            scanner.nextLine(); // Consommer le saut de ligne

            switch (choice) {
                case 1:
                    // Ajouter une équipe
                    addEquipe();
                    break;
                case 2:
                    // Supprimer une équipe
                    deleteEquipe();
                    break;
                case 3:
                    // Modifier une équipe
                    updateEquipe();
                    break;
                case 4:
                    // Afficher toutes les équipes
                    displayAllTeams();
                    break;
                case 0:
                    backToMenu = true;
                    break;
                default:
                    System.out.println("Option invalide, veuillez réessayer.");
            }
        }
    }

    private void addEquipe() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez le nom de l'équipe : ");
        String nom = scanner.nextLine();
        System.out.print("Entrez le classement de l'équipe : ");
        String classement = scanner.nextLine();

        Equipe equipe = new Equipe();
        equipe.setNom(nom);
        equipe.setClassement(Integer.parseInt(classement));

        equipeService.ajouterEquipe(equipe);
        System.out.println("Équipe ajoutée avec succès !");
    }

    private void deleteEquipe() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez l'ID de l'équipe à supprimer : ");
        long id = scanner.nextLong();

        // Appel du service pour supprimer l'équipe
        equipeService.SuppremeEquipe(id);
        System.out.println("Équipe supprimée avec succès !");
    }

    private void updateEquipe() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez l'ID de l'équipe à modifier : ");
        long id = scanner.nextLong();
        scanner.nextLine(); // Consommer le saut de ligne

        System.out.print("Entrez le nouveau nom de l'équipe : ");
        String nom = scanner.nextLine();
        System.out.print("Entrez le nouveau classement de l'équipe : ");
        String classement = scanner.nextLine();

        Equipe equipe = new Equipe();
        equipe.setNom(nom);
        equipe.setClassement(Integer.parseInt(classement));

        equipeService.ModifierEquipe(equipe, id);
        System.out.println("Équipe modifiée avec succès !");
    }

    private void displayAllTeams() {
        List<Equipe> equipes = equipeService.getAllEquipe();
        if (equipes.isEmpty()) {
            System.out.println("Aucune équipe disponible.");
        } else {
            System.out.println("Liste des équipes :");
            equipes.forEach(equipe -> System.out.println("- " + equipe.getNom()));
        }
    }


    private void manageTournaments() {
        System.out.println("=== Gestion des tournois ===");
    }
}
