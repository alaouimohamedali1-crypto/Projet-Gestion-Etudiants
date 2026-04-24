import java.util.ArrayList;
import java.util.Collections;

public class MainProjet1 {
    public static void main(String[] args) {
        // STRUCTURE DE DONNÉES : ArrayList dynamique pour gérer une liste d'étudiants infinie
        ArrayList<Etudiant> maClasse = new ArrayList<>();
        boolean quitter = false;

        while (!quitter) {
            // INTERFACE CONSOLE : Menu interactif pour l'utilisateur
            System.out.println("\n========== MENU DE GESTION ==========");
            System.out.println("1. Charger les données (CSV)");
            System.out.println("2. Ajouter un étudiant");
            System.out.println("3. Supprimer un étudiant");
            System.out.println("4. Afficher le classement");
            System.out.println("5. Sauvegarder les résultats");
            System.out.println("6. Rechercher un étudiant");
            System.out.println("7. Quitter");

            int choix = SaisieUtilitaire.lireChoixMenu("Votre choix : ");

            switch (choix) {
                case 1:
                    // LECTURE : Appelle la classe GestionFichiers pour transformer un fichier CSV en objets Etudiant.

                    System.out.print("Nom du fichier (.csv) : ");
                    GestionFichiers.lireDonnees(new java.util.Scanner(System.in).nextLine(), maClasse);
                    break;

                case 2:
                    // CRÉATION D'OBJET : Utilise SaisieUtilitaire pour garantir que l'objet Etudiant est créé avec des données propres.

                    String nom = SaisieUtilitaire.lireTexteValide("Nom de l'étudiant : ");
                    Etudiant e = new Etudiant(nom);

                    int nbNotes = SaisieUtilitaire.lireChoixMenu("Combien de notes à ajouter ? ");
                    for (int i = 0; i < nbNotes; i++) {
                        String mat = SaisieUtilitaire.lireTexteValide("Matière " + (i+1) + " : ");
                        double note = SaisieUtilitaire.lireNote("Note pour " + mat + " : ");
                        e.ajouterNote(mat, note);
                    }
                    maClasse.add(e);
                    System.out.println("Étudiant ajouté avec succès.");
                    break;

                case 3:
                    System.out.print("Nom à supprimer : ");
                    String nomSuppr = new java.util.Scanner(System.in).nextLine();



                    boolean etudiantSupprime = false;

                    // PARCOURS DE LA LISTE : on cherche l'étudiant un par un
                    for (int i = 0; i < maClasse.size(); i++) {
                        String nomActuel = maClasse.get(i).getNom();

                        if (nomActuel.equalsIgnoreCase(nomSuppr)) {
                            maClasse.remove(i);       // Suppression à l'index i
                            etudiantSupprime = true;  // On note que c'est fait
                            break;                    // On arrête la boucle
                        }
                    }

                    if (etudiantSupprime) {
                        System.out.println("Supprimé.");
                    } else {
                        System.out.println("Introuvable.");
                    }
                    break;

                case 4:
                    // CLASSEMENT ET TRI : Utilise Collections.sort avec notre ComparateurMoyenne personnalisé (Tri décroissant).

                    if (maClasse.isEmpty()) {
                        System.out.println("Aucune donnée à afficher.");
                    } else {
                        Collections.sort(maClasse, new ComparateurMoyenne());
                        System.out.println("\n--- CLASSEMENT ---");
                        for (Etudiant etu : maClasse) {
                            System.out.println(etu.getNom() + " | Moyenne : " + String.format("%.2f", etu.calculerMoyenne()));
                        }
                    }
                    break;

                case 5:
                    // POLYMORPHISME : On instancie l'interface Sauvegarde avec l'implémentation CSV.
                    // Respecte le principe DIP (Inversion des dépendances).

                    Sauvegarde outil = new SauvegardeCSV();
                    outil.sauvegarder(maClasse, "resultats_finaux.csv");
                    break;

                case 6:
                    // MOTEUR DE RECHERCHE : Parcours de la liste pour trouver un étudiant spécifique sans tenir compte de la casse.

                    System.out.print("Nom à rechercher : ");
                    String nomRech = new java.util.Scanner(System.in).nextLine();
                    boolean trouve = false;
                    for (Etudiant etu : maClasse) {
                        if (etu.getNom().equalsIgnoreCase(nomRech)) {
                            System.out.println("Trouvé ! Moyenne : " + String.format("%.2f", etu.calculerMoyenne()));
                            trouve = true;
                            break;
                        }
                    }
                    if (!trouve) System.out.println("Étudiant non trouvé.");
                    break;

                case 7:
                    quitter = true;
                    System.out.println("Au revoir !");
                    break;
            }
        }
    }
}