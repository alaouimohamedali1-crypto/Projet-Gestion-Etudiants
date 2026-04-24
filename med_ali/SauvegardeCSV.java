import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SauvegardeCSV implements Sauvegarde {
    // On utilise un 'FileWriter' (qui gère l'accès physique au disque)
    // et 'PrintWriter' pour bénéficier de méthodes de formatage avancées comme 'println()'.

    @Override
    public void sauvegarder(ArrayList<Etudiant> liste, String destination) {
        // try-with-resources : assure que le fichier est bien fermé même en cas d'erreur
        try (PrintWriter redacteur = new PrintWriter(new FileWriter(destination))) {
            redacteur.println("Nom,Moyenne"); // En-tête du fichier CSV
            for (Etudiant e : liste) {
                // Écrit une ligne par étudiant avec sa moyenne formatée
                redacteur.println(e.getNom() + "," + String.format("%.2f", e.calculerMoyenne()));
            }
            System.out.println("Sauvegarde réussie dans : " + destination);
        } catch (IOException e) {
            // Gestion de l'exception si le fichier est protégé ou le disque plein
            System.out.println("Erreur lors de la sauvegarde : " + e.getMessage());
        }
    }
}