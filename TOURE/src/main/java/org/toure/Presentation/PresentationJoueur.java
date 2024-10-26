package org.toure.Presentation;

import java.util.Scanner;
import org.toure.Model.Equipe;
import org.toure.Model.Joueur;
import org.toure.Repository.interfaces.EquipeRepository;
import org.toure.Repository.interfaces.JoueurRepository;
import org.toure.Service.EquipeService;
import org.toure.Service.JoueurService;
import util.JoueurValidator;

public class PresentationJoueur {

    private final EquipeService equipeService;
    private final JoueurService joueurService;

    public PresentationJoueur(EquipeRepository equipeRepository, JoueurRepository joueurRepository) {
        this.equipeService = new EquipeService(equipeRepository);
        this.joueurService = new JoueurService(joueurRepository);
    }

    void addJoueur() {
        Scanner scanner = new Scanner(System.in);
        String pseudo;


        while (true) {
            System.out.print("Entrez le pseudo du joueur : ");
            pseudo = scanner.nextLine();

            if (JoueurValidator.validatePseudo(pseudo)) {
                break;
            } else {
                System.out.println("Le pseudo est invalide. Veuillez entrer un pseudo de 3 caractères minimum.");
            }
        }


        int age;
        while (true) {
            System.out.print("Entrez l'âge du joueur : ");
            try {
                age = Integer.parseInt(scanner.nextLine());
                if (JoueurValidator.validateAge(age)) {
                    break;
                } else {
                    System.out.println("L'âge doit être un nombre positif. Veuillez réessayer.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erreur : L'âge doit être un nombre entier.");
            }
        }


        Equipe equipe;
        while (true) {
            System.out.print("Entrez le nom de l'équipe : ");
            String nomEquipe = scanner.nextLine();
            equipe = equipeService.getbyname(nomEquipe);

            if (equipe != null) {
                break;
            } else {
                System.out.println("L'équipe n'existe pas. Veuillez entrer un nom d'équipe valide.");
            }
        }

        Joueur joueur = new Joueur(pseudo, age, equipe);
        joueurService.ajouterJour(joueur);
        System.out.println("Joueur ajouté avec succès : " + pseudo);
    }


    public void deleteJoueur() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez l'ID du joueur à supprimer : ");
        Long joueurId = scanner.nextLong();
        scanner.nextLine();

        try {
            joueurService.SuppremeJoueur(joueurId);
            System.out.println("Joueur supprimé avec succès !");
        } catch (Exception e) {
            System.out.println("Erreur lors de la suppression du joueur : " + e.getMessage());
        }
    }



    public void updateJoueur() {
        Scanner scanner = new Scanner(System.in);
        Long joueurId = null;
        boolean validId = false;

        while (!validId) {
            System.out.print("Entrez l'ID du joueur à mettre à jour : ");
            String idInput = scanner.nextLine();

            try {
                joueurId = Long.parseLong(idInput);
                validId = true;
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un ID valide.");
            }
        }

        String nouveauPseudo;
        // Validation du nouveau pseudo
        while (true) {
            System.out.print("Entrez le nouveau pseudo : ");
            nouveauPseudo = scanner.nextLine();
            if (JoueurValidator.validatePseudo(nouveauPseudo)) {
                break; // Sortie de la boucle si le pseudo est valide
            }
        }

        int nouvelAge;
        // Validation de l'âge
        while (true) {
            System.out.print("Entrez le nouvel âge : ");
            String ageInput = scanner.nextLine();
            try {
                nouvelAge = Integer.parseInt(ageInput);
                if (JoueurValidator.validateAge(nouvelAge)) {
                    break; // Sortie de la boucle si l'âge est valide
                }
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un âge valide.");
            }
        }


        Equipe equipe;
        while (true) {
            System.out.print("Entrez le nom de la nouvel  l'équipe : ");
            String nomEquipe = scanner.nextLine();
            equipe = equipeService.getbyname(nomEquipe);

            if (equipe != null) {
                break;
            } else {
                System.out.println("L'équipe n'existe pas. Veuillez entrer un nom d'équipe valide.");
            }
        }


        Joueur joueur = new Joueur(nouveauPseudo, nouvelAge,equipe);

        try {
            joueurService.ModifierJoueur(joueur, joueurId);
            System.out.println("Joueur mis à jour avec succès !");
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur lors de la mise à jour du joueur : " + e.getMessage());
        }
    }




}
