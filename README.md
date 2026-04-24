# Système de Gestion et Classement des Étudiants (POO Java)

## Auteur
* **Med Ali** - Étudiant en science des données appliquées

## Présentation du Projet
Cette application Java implémente une solution logicielle complète pour la gestion des performances académiques. Le système assure le cycle de vie complet des données : de l'ingestion de flux bruts (format CSV) à la production d'un rapport de performance classé par ordre de mérite. L'architecture repose sur les principes de la Programmation Orientée Objet (POO) pour garantir la modularité et l'extensibilité du code.

## Fonctionnalités
* **Extraction de données :** Parsing intelligent d'un fichier CSV source avec gestion des doublons.
* **Architecture POO Avancée :**
- **Héritage :** Classe parente Personne pour la factorisation des attributs.
- **Interfaces :** Contrat Evaluable pour la standardisation des calculs.
- **Inversion des Dépendances (DIP) :** Architecture flexible facilitant l'évolution du mode de stockage.
* **Calculateur de moyenne :** Gestion dynamique des notes via ArrayList<Double>.
* **Algorithme de Tri :** Classement décroissant automatisé via un Comparator personnalisé.
* **Sécurisation des saisies :** Sécurisation des saisies clavier (gestion du buffer Scanner) et traitement des exceptions (try-catch).
* **Sauvegarde des données :** Exportation automatique des résultats triés dans resultats_finaux.csv.


## Structure du Dépôt
* **med_ali/ :** Code source source complet (Classes métier et utilitaires).
* **etudiants.csv :** Jeu de données de test.
* **README.md :** Documentation technique.
* **contributions.txt :** Détail de l'ingénierie et des étapes de réalisation.


## Instructions d'exécution
1. Télécharger ou cloner le dépôt.
2. Compiler les fichiers avec la commande : `javac med_ali/*.java`
3. Lancer le programme : `java med_ali.MainProjet1`
4. Entrer le nom du fichier CSV au clavier lorsqu'il est demandé.
