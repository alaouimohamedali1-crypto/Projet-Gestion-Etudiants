// CONCEPT : CLASSE ABSTRAITE
// On ne peut pas créer une "Personne" directement (new Personne() est impossible).
// Elle sert de moule commun pour d'autres classes comme Etudiant, si on souhaite les ajouter dans l'avenir.
public abstract class Personne {
    // Attribut "protected" : accessible uniquement par les classes filles (comme Etudiant)
    protected String nom;

    public Personne(String nom) {
        this.nom = nom;
    }

    // Méthode commune dont héritera l'étudiant
    public String getNom() {
        return nom;
    }
}