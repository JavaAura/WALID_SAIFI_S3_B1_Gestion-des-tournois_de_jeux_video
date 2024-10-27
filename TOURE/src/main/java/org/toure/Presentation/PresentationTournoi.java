package org.toure.Presentation;
import org.toure.Model.Jeu;
import org.toure.Model.Tournoi;
import org.toure.Service.JeuService;
import org.toure.Service.TournoiService;
import util.TournoiValidation;

import java.time.LocalDate;
import java.util.Scanner;


public class PresentationTournoi {

    private  final JeuService jeuService;
    private final TournoiService tournoiService;

    public PresentationTournoi(JeuService jeuService, TournoiService tournoiService) {
        this.jeuService = jeuService;
        this.tournoiService = tournoiService;
    }



    void addTournament() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le titre du tournoi : ");
        String title = TournoiValidation.readNonEmptyString(scanner);

        String nomJeu;
        while (true) {
            System.out.print("Entrez le nom de jeu du tournoi : ");
            nomJeu = TournoiValidation.readNonEmptyString(scanner);
            if (!nomJeu.isEmpty()) {
                Jeu jeu = jeuService.getJeuByname(nomJeu);
                if (jeu != null) {
                    break;
                }
                System.out.println("Jeu non trouvé. Veuillez vérifier le nom du jeu.");
            } else {
                System.out.println("Le nom du jeu ne peut pas être vide. Veuillez réessayer.");
            }
        }
        System.out.print("Entrez la date de début (AAAA-MM-JJ) : ");
        LocalDate startDate = LocalDate.parse(TournoiValidation.readDate(scanner));

        System.out.print("Entrez la date de fin (AAAA-MM-JJ) : ");
        LocalDate endDate = LocalDate.parse(TournoiValidation.readDate(scanner));

        System.out.print("Entrez le nombre de spectateurs : ");
        int spectators = TournoiValidation.readPositiveInt(scanner);

        Jeu jeu = jeuService.getJeuByname(nomJeu);

        if (jeu == null) {
            System.out.println("Jeu non trouvé. Veuillez vérifier le nom du jeu.");
            return;
        }

         Tournoi tournoi = new Tournoi(title,jeu,startDate, endDate, spectators);
         tournoiService.ajouterTournoi(tournoi);
         System.out.println("Tournoi ajouté avec succès.");
    }
/*
    private void deleteTournament() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez l'ID du tournoi à supprimer : ");
        int id = TournoiValidation.readPositiveInt(scanner);

        boolean success = tournoiService.deleteTournoi(id);
        if (success) {
            System.out.println("Tournoi supprimé avec succès.");
        } else {
            System.out.println("Aucun tournoi trouvé avec cet ID.");
        }
    }

    private void updateTournament() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez l'ID du tournoi à modifier : ");
        int id = TournoiValidation.readPositiveInt(scanner);

        System.out.print("Entrez le nouveau titre du tournoi : ");
        String title = TournoiValidation.readNonEmptyString(scanner);

        System.out.print("Entrez le nouveau jeu du tournoi : ");
        String game = TournoiValidation.readNonEmptyString(scanner);

        System.out.print("Entrez la nouvelle date de début (AAAA-MM-JJ) : ");
        String startDate = TournoiValidation.readDate(scanner);

        System.out.print("Entrez la nouvelle date de fin (AAAA-MM-JJ) : ");
        String endDate = TournoiValidation.readDate(scanner);

        System.out.print("Entrez le nouveau nombre de spectateurs : ");
        int spectators = TournoiValidation.readPositiveInt(scanner);

        //Tournoi updatedTournoi = new Tournoi(id, title, game, startDate, endDate, spectators);
       /*boolean success = tournoiService.updateTournoi(updatedTournoi);
        if (success) {
            System.out.println("Tournoi mis à jour avec succès.");
        } else {
            System.out.println("Erreur lors de la mise à jour du tournoi.");
        }*/
    /*

    private void displayAllTournaments() {
        tournoiService.getAllTournois().forEach(tournoi -> {
            System.out.println("ID: " + tournoi.getId() + ", Titre: " + tournoi.getTitre() +
                    ", Jeu: " + tournoi.getJeu().getNom() + ", Date de début: " + tournoi.getDateDebut() +
                    ", Date de fin: " + tournoi.getDateFin() + ", Spectateurs: " + tournoi.getNombreSpectateurs());
        });
    }*/

}