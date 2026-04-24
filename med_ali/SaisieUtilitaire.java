import java.util.Scanner;

public class SaisieUtilitaire {
    private static Scanner sc = new Scanner(System.in);

    // MÉTHODE DE VALIDATION TEXTUELLE :
    // Garantit que l'utilisateur ne laisse pas de champ vide et n'entre pas de chiffres.

    public static String lireTexteValide(String msg) {
        while (true) {
            System.out.print(msg);
            String saisie = sc.nextLine().trim();

            if (saisie.isEmpty()) {
                System.out.println("Erreur : La saisie ne peut pas être vide.");
                continue;
            }

            // VÉRIFICATION : On parcourt la chaîne caractère par caractère pour détecter un chiffre.

            boolean aUnChiffre = false;

            // 1. On transforme le texte en un tableau de caractères (char[])
            char[] lettres = saisie.toCharArray();

            // 2. On parcourt le tableau avec une boucle for simple
            for (int i = 0; i < lettres.length; i++) {
                // 3. On accède à la case [i] du tableau
                if (Character.isDigit(lettres[i])) {
                    aUnChiffre = true;
                    break;
                }
            }

            if (aUnChiffre) {
                System.out.println("Erreur : Le nom ne doit pas contenir de chiffres.");
            } else {
                return saisie; // Renvoie la donnée seulement si elle est 100% valide
            }
        }
    }

    // GESTION DES NOMBRES ET DES EXCEPTIONS :
    // Utilise un bloc try-catch pour empêcher le programme de crash si on saisit du texte.
    public static double lireNote(String msg) {
        while (true) {
            System.out.print(msg);
            try {
                // .replace(',', '.') assure la compatibilité avec tous les types de claviers
                double n = Double.parseDouble(sc.nextLine().replace(',', '.'));
                if (n >= 0 && n <= 20) return n;
                System.out.println("Erreur : La note doit être entre 0 et 20.");
            } catch (Exception e) {
                System.out.println("Erreur : Veuillez entrer un nombre (ex: 15.5).");
            }
        }
    }

    // Utilise Integer.parseInt(sc.nextLine()) au lieu de nextInt() pour éviter
    // le bug du "saut de ligne" en Java en cliquant sur la touche entrée.
    public static int lireChoixMenu(String msg) {
        while (true) {
            System.out.print(msg);
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Erreur : Veuillez entrer un chiffre valide.");
            }
        }
    }
}