import java.util.Comparator;

// UTILITAIRE DE TRI : Cette classe explique à Java comment comparer deux objets "Etudiant".
// L'utilisation de l'interface Comparator intégrée nativement dans Java

public class ComparateurMoyenne implements Comparator<Etudiant> {
    @Override
    public int compare(Etudiant e1, Etudiant e2) {
        // En comparant e2 (le deuxième) avec e1 (le premier), on inverse l'ordre naturel.
        // Résultat : Les moyennes les plus hautes seront placées au début de la liste.
        return Double.compare(e2.calculerMoyenne(), e1.calculerMoyenne());
    }
}