package org.toure.Presentation;
import org.toure.DAO.Implementation.TournoiDaoImpl;
import org.toure.DAO.Interfaces.TournoiDao;
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

    public TournoiDaoImpl tournoiDao;

    public PresentationTournoi(JeuService jeuService, TournoiService tournoiService, TournoiDaoImpl tournoiDao) {
        this.jeuService = jeuService;
        this.tournoiService = tournoiService;
        this.tournoiDao =tournoiDao;
    }


    void addTournament() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le titre du tournoi : ");
        String title = TournoiValidation.readNonEmptyString(scanner);

        String nomJeu;
        Jeu jeu = null;
        while (true) {
            System.out.print("Entrez le nom de jeu du tournoi : ");
            nomJeu = TournoiValidation.readNonEmptyString(scanner);
            if (!nomJeu.isEmpty()) {
                jeu = jeuService.getJeuByname(nomJeu);
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

        System.out.print("Entrez le temps de pause entre les matchs (en minutes) : ");
        int tempsPause = TournoiValidation.readPositiveInt(scanner);

        System.out.print("Entrez le temps de la cérémonie (en minutes) : ");
        int tempsCeremonie = TournoiValidation.readPositiveInt(scanner);

        Tournoi tournoi = new Tournoi(title, jeu, startDate, endDate, spectators, tempsPause, tempsCeremonie);

        tournoiService.ajouterTournoi(tournoi);

        Long tournoiId = tournoi.getId();
        if (tournoiId != null) {
            int dureeEstimee = tournoiDao.calculerDureeEstimeeTournoi(tournoiId);
            tournoi.setDureeEstimee(dureeEstimee);

            tournoiService.ModifierTournoi(tournoi,tournoiId);
            System.out.println("Tournoi ajouté avec succès.");
        } else {
            System.out.println("Erreur lors de la création du tournoi : l'ID n'a pas pu être généré.");
        }
    }


    void deleteTournament() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez l'ID du tournoi à supprimer : ");
        int id = TournoiValidation.readPositiveInt(scanner);
          tournoiService.SuppremeTouroi(id);

            System.out.println("Aucun tournoi trouvé avec cet ID.");
        }



    void displayAllTournaments() {
        tournoiService.getAllTournois().forEach(tournoi -> {
            System.out.println("ID: " + tournoi.getId() + ", Titre: " + tournoi.getTitre() +
                    ", Jeu: " + tournoi.getJeu().getNom() + ", Date de début: " + tournoi.getDateDebut() +
                    ", Date de fin: " + tournoi.getDateFin() + ", Spectateurs: " + tournoi.getNombreSpectateurs());
        });
    }



    void updateTournament() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez l'ID du tournoi à modifier : ");
        Long id = Long.valueOf(TournoiValidation.readPositiveInt(scanner));
        Tournoi tournoi = tournoiService.getTournoi(id);
        if (tournoi == null) {
            System.out.println("Aucun tournoi trouvé avec cet ID.");
            return;
        }

        System.out.print("Entrez le nouveau titre du tournoi (laisser vide pour garder l'ancien) : ");
        String title = TournoiValidation.readNonEmptyString(scanner);
        if (!title.isEmpty()) {
            tournoi.setTitre(title);
        }

        System.out.print("Entrez le nouveau nom de jeu du tournoi (laisser vide pour garder l'ancien) : ");
        String gameName;
        Jeu jeu = null;
        while (true) {
            gameName = TournoiValidation.readNonEmptyString(scanner);
            if (gameName.isEmpty()) {
                break;
            }
            jeu = jeuService.getJeuByname(gameName);
            if (jeu != null) {
                tournoi.setJeu(jeu);
                break;
            } else {
                System.out.println("Jeu non trouvé, veuillez réessayer.");
            }
        }


        String startDateInput;
        while (true) {
            System.out.print("Entrez la nouvelle date de début (AAAA-MM-JJ, laisser vide pour garder l'ancienne) : ");
            startDateInput = TournoiValidation.readDate(scanner);
            if (startDateInput.isEmpty()) {
                break;
            }
            try {
                tournoi.setDateDebut(LocalDate.parse(startDateInput));
                break;
            } catch (Exception e) {
                System.out.println("Format de date invalide. Veuillez réessayer.");
            }
        }


        String endDateInput;
        while (true) {
            System.out.print("Entrez la nouvelle date de fin (AAAA-MM-JJ, laisser vide pour garder l'ancienne) : ");
            endDateInput = TournoiValidation.readDate(scanner);
            if (endDateInput.isEmpty()) {
                break;
            }
            try {
                tournoi.setDateFin(LocalDate.parse(endDateInput));
                break; // Sortir de la boucle si la date est valide
            } catch (Exception e) {
                System.out.println("Format de date invalide. Veuillez réessayer.");
            }
        }


        String spectatorsInput;
        while (true) {
            System.out.print("Entrez le nouveau nombre de spectateurs (laisser vide pour garder l'ancien) : ");
            spectatorsInput = scanner.nextLine();
            if (spectatorsInput.isEmpty()) {
                break;
            }
            try {
                int spectators = Integer.parseInt(spectatorsInput);
                tournoi.setNombreSpectateurs(spectators);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre valide.");
            }
        }


        String tempsPauseInput;
        while (true) {
            System.out.print("Entrez le nouveau temps de pause entre les matchs (en minutes, laisser vide pour garder l'ancien) : ");
            tempsPauseInput = scanner.nextLine();
            if (tempsPauseInput.isEmpty()) {
                break;
            }
            try {
                int tempsPause = Integer.parseInt(tempsPauseInput);
                tournoi.setTempsPause(tempsPause);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre valide.");
            }
        }

        String tempsCeremonieInput;
        while (true) {
            System.out.print("Entrez le nouveau temps de la cérémonie (en minutes, laisser vide pour garder l'ancien) : ");
            tempsCeremonieInput = scanner.nextLine();
            if (tempsCeremonieInput.isEmpty()) {
                break;
            }
            try {
                int tempsCeremonie = Integer.parseInt(tempsCeremonieInput);
                tournoi.setTempsCeremonie(tempsCeremonie);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre valide.");
            }
        }

        tournoiService.ModifierTournoi(tournoi,id);
        System.out.println("Tournoi mis à jour avec succès.");

    }


}