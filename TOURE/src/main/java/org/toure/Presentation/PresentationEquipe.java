package org.toure.Presentation;

import org.toure.Model.Equipe;
import org.toure.Service.EquipeService;
import util.EquipeValidator;

import java.util.List;
import java.util.Scanner;

public class PresentationEquipe {

    private final EquipeService equipeService;
    private final Scanner scanner;

    public PresentationEquipe(EquipeService equipeService) {
        this.equipeService = equipeService;
        this.scanner = new Scanner(System.in);
    }

    private void manageTeams() {
        System.out.println("=== Gestion des équipes ===");
        boolean running = true;

        while (running) {
            System.out.println("1. Ajouter une équipe");
            System.out.println("2. Modifier une équipe");
            System.out.println("3. Supprimer une équipe");
            System.out.println("4. Afficher toutes les équipes");
            System.out.println("5. Quitter");
            System.out.print("Choisissez une option : ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    addTeam();
                    break;
                case 2:
                    updateTeam();
                    break;
                case 3:
                    deleteTeam();
                    break;
                case 4:
                    displayAllTeams();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        }
    }

    private void addTeam() {
        System.out.print("Entrez le nom de l'équipe : ");
        String nom = scanner.nextLine();

        // Valider le nom
        if (!EquipeValidator.validateNom(nom)) {
            return;
        }

        Equipe equipe = new Equipe();
        equipe.setNom(nom);

        equipeService.ajouterEquipe(equipe);
        System.out.println("Équipe ajoutée avec succès.");
    }

    private void updateTeam() {
        System.out.print("Entrez l'ID de l'équipe à modifier : ");
        long id = scanner.nextLong();
        scanner.nextLine(); // Consomme la nouvelle ligne

        System.out.print("Entrez le nouveau nom de l'équipe : ");
        String nom = scanner.nextLine();

        if (!EquipeValidator.validateNom(nom)) {
            return;
        }

        Equipe equipe = new Equipe();
        equipe.setNom(nom);

        equipeService.ModifierEquipe(equipe, id);
        System.out.println("Équipe modifiée avec succès.");
    }

    private void deleteTeam() {
        System.out.print("Entrez l'ID de l'équipe à supprimer : ");
        long id = scanner.nextLong();
        scanner.nextLine();

        equipeService.SuppremeEquipe(id);
        System.out.println("Équipe supprimée avec succès.");
    }

    private void displayAllTeams() {
        List<Equipe> equipes = equipeService.getAllEquipe();
        if (equipes.isEmpty()) {
            System.out.println("Aucune équipe disponible.");
        } else {
            System.out.println("Liste des équipes :");
            equipes.forEach(equipe ->
                    System.out.println("ID : " + equipe.getId() + ", Nom : " + equipe.getNom())
            );
        }
    }



}
