import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionFichiers {
    // MÉTHODE DE LECTURE : Cette méthode parcourt le fichier CSV et crée des objets Etudiant en mémoire.
    public static void lireDonnees(String nomFichier, ArrayList<Etudiant> listeEtudiants) {
        try {
            File file = new File(nomFichier);
            Scanner lecteur = new Scanner(file);

            // GESTION DE L'EN-TÊTE : On saute la première ligne (Nom,Matiere,Note)
            if (lecteur.hasNextLine()) lecteur.nextLine();

            while (lecteur.hasNextLine()) {
                String ligne = lecteur.nextLine();
                // DÉCOUPAGE : On sépare les données grâce à la virgule (format CSV)
                String[] parties = ligne.split(",");

                if (parties.length == 3) {
                    String nom = parties[0].trim();
                    String matiere = parties[1].trim();
                    // CONVERSION : On transforme le texte du fichier en nombre (double)
                    double note = Double.parseDouble(parties[2].trim());

                    // On vérifie si l'étudiant est déjà dans notre liste pour ne pas le créer deux fois.
                    Etudiant etudiantActuel = null;
                    for (Etudiant e : listeEtudiants) {
                        if (e.getNom().equalsIgnoreCase(nom)) {
                            etudiantActuel = e;
                            break;
                        }
                    }

                    // CRÉATION UNIQUE : Si l'étudiant n'existe pas encore, on l'ajoute à la liste
                    if (etudiantActuel == null) {
                        etudiantActuel = new Etudiant(nom);
                        listeEtudiants.add(etudiantActuel);
                    }

                    // On ajoute la note à l'objet (qu'il soit nouveau ou déjà existant)
                    etudiantActuel.ajouterNote(matiere, note);
                }
            }
            lecteur.close(); // On libère le fichier après lecture
            System.out.println("Données chargées avec succès !");

        } catch (FileNotFoundException e) {
            // SÉCURITÉ : Message clair si l'utilisateur se trompe de nom de fichier
            System.out.println("Erreur: Fichier introuvable.");
        } catch (Exception e) {
            // SÉCURITÉ GÉNÉRALE : Empêche le crash si le contenu du fichier est mal formé
            System.out.println("Erreur lors de la lecture des données.");
        }
    }
}