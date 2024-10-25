package org.toure.Presentation;

import org.toure.Model.Joueur;
import util.JoueurValidator;

import java.util.Scanner;


public class PresentationJoueur {
    private void addPlayer() {
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


        Joueur joueur = new Joueur(pseudo, age, null);
        // joueurService.save(joueur);
        System.out.println("Joueur ajouté avec succès : " + pseudo);
    }


}
