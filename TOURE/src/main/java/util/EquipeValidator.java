package util;

import org.toure.Model.Equipe;

public class EquipeValidator {

    public static boolean validateNom(String nom) {
        if (nom == null || nom.isEmpty()) {
            System.out.println("Erreur : Le nom de l'équipe ne peut pas être vide.");
            return false;
        }
        if (nom.length() < 3) {
            System.out.println("Erreur : Le nom de l'équipe doit contenir au moins 3 caractères.");
            return false;
        }
        return true;
    }


}
