import java.util.ArrayList;

// CONCEPTS : HÉRITAGE et INTERFACE
// "extends Personne" : L'étudiant récupère l'attribut nom et la méthode getNom().
// "implements Evaluable" : L'étudiant s'oblige à posséder la méthode calculerMoyenne().

public class Etudiant extends Personne implements Evaluable {
    // Collections dynamiques pour stocker un nombre de notes variable
    private ArrayList<String> matieres;
    private ArrayList<Double> notes;

    public Etudiant(String nom) {
        super(nom); // Appelle le constructeur de la classe parente (Personne)
        this.matieres = new ArrayList<>();
        this.notes = new ArrayList<>();
    }

    public void ajouterNote(String nomMatiere, double note) {
        this.matieres.add(nomMatiere);
        this.notes.add(note);
    }

    // LOGIQUE MÉTIER : Implémentation obligatoire de la méthode définie dans l'interface Evaluable.
    @Override
    public double calculerMoyenne() {
        if (notes.isEmpty()) return 0.0;
        double somme = 0;
        for (double n : notes) {
            somme += n;
        }
        return somme / notes.size();
    }
}