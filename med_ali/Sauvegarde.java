import java.util.ArrayList;

// INTERFACE : Applique le DIP (Inversion des Dépendances) pour rendre le code flexible.
// Elle définit l'action de sauvegarder sans préciser la technologie (CSV, SQL, XML).
public interface Sauvegarde {
    void sauvegarder(ArrayList<Etudiant> liste, String destination);
}
