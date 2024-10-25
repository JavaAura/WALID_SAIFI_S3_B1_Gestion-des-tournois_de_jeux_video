package Util;

import org.toure.Model.Equipe;

public class JoueurValidator {

    public static boolean validatePseudo(String pseudo) {
        if (pseudo == null || pseudo.isEmpty()) {
            System.out.println("Erreur : Le pseudo ne peut pas être vide.");
            return false;
        }
        if (pseudo.length() < 3) {
            System.out.println("Erreur : Le pseudo doit contenir au moins 3 caractères.");
            return false;
        }
        return true;
    }


    public static boolean validateAge(int age) {

        if (age <= 0) {
            System.out.println("Erreur : L'âge doit être un nombre positif.");
            return false;
        }

        return true;
    }

    public static boolean validateEquipe(Equipe equipe) {

        if (equipe != null && equipe.getNom().isEmpty()) {
            System.out.println("Erreur : Le nom de l'équipe ne peut pas être vide.");
            return false;
        }
        return true;
    }
}
