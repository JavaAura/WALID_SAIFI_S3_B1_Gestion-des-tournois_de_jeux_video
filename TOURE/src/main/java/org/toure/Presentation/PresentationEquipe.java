package org.toure.Presentation;

import org.toure.Model.Equipe;
import org.toure.Service.EquipeService;
import util.EquipeValidator;

import java.util.List;
import java.util.Scanner;

public class PresentationEquipe {

    private final EquipeService equipeService;

    public PresentationEquipe(EquipeService equipeService) {
        this.equipeService = equipeService;

    }


    void addEquipe(){
        Scanner scanner = new Scanner(System.in);
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

    void updateEquipe(){
        Scanner scanner = new Scanner(System.in);
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

    void deleteEquipe(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez l'ID de l'équipe à supprimer : ");
        long id = scanner.nextLong();
        scanner.nextLine();

        equipeService.SuppremeEquipe(id);
        System.out.println("Équipe supprimée avec succès.");
    }

    void displayAllTeams() {

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
