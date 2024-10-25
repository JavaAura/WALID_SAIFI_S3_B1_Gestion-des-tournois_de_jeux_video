package org.toure.Presentation;

import org.springframework.context.ApplicationContext;
import java.util.Scanner;

public class ApplicationConsole {

    private ApplicationContext context;

    public ApplicationConsole(ApplicationContext context) {
        this.context = context;
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
        System.out.println("=== Gestion des joueurs ===");


    }

    private void manageTeams() {
        System.out.println("=== Gestion des équipes ===");

    }

    private void manageTournaments() {
        System.out.println("=== Gestion des tournois ===");

    }
}
