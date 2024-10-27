package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class TournoiValidation {


        private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        public static String readNonEmptyString(Scanner scanner) {
            String input;
            do {
                input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    System.out.print("Entrée vide. Veuillez réessayer : ");
                }
            } while (input.isEmpty());
            return input;
        }

        public static int readPositiveInt(Scanner scanner) {
            int number;
            while (true) {
                try {
                    number = Integer.parseInt(scanner.nextLine());
                    if (number > 0) {
                        break;
                    } else {
                        System.out.print("Veuillez entrer un nombre positif : ");
                    }
                } catch (NumberFormatException e) {
                    System.out.print("Entrée non valide. Veuillez entrer un entier positif : ");
                }
            }
            return number;
        }

        public static String readDate(Scanner scanner) {
            String dateInput;
            while (true) {
                dateInput = scanner.nextLine().trim();
                try {
                    LocalDate.parse(dateInput, DATE_FORMATTER);
                    break;
                } catch (DateTimeParseException e) {
                    System.out.print("Format de date invalide. Veuillez entrer une date au format AAAA-MM-JJ : ");
                }
            }
            return dateInput;
        }
    }


