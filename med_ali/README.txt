Projet : Gestion et Classement des Étudiants
Ce dossier contient l'intégralité du code source Java pour le système de gestion des moyennes. Le projet met l'accent sur la robustesse du code et la flexibilité de l'architecture.

DÉTAILS TECHNIQUES & ARCHITECTURE

1. Conception Orientée Objet (SOLID)
•	Héritage & Abstraction : Utilisation d'une classe abstraite Personne et d'une classe fille Etudiant.
•	Interface de Contrat : L'interface Evaluable impose la méthode de calcul des moyennes, assurant une structure cohérente.
•	Inversion des Dépendances (DIP) : Implémentation d'une interface Sauvegarde. Le programme principal dépend d'une abstraction et non d'un format de fichier spécifique, ce qui permet de changer le mode de stockage (CSV, JSON, SQL) sans modifier le code métier.

2. Robustesse et Expérience Utilisateur (UX)
•	Gestion Sécurisée du Scanner : Utilisation de Integer.parseInt(sc.nextLine()) pour éviter le bug classique du "saut de ligne" en Java et garantir un buffer clavier toujours propre.
•	Validation des Saisies : Système de vérification par "témoin" (boolean flag) pour interdire les chiffres dans les noms d'étudiants.
•	Gestion des Exceptions : Utilisation ciblée des blocs try-catch pour intercepter les erreurs de format (NumberFormatException), les fichiers manquants (FileNotFoundException) et les erreurs d'entrée/sortie (IOException).

3. Traitement des Données
•	Logique de Regroupement : L'algorithme de lecture CSV identifie si un étudiant existe déjà dans la ArrayList pour lui associer ses différentes notes, évitant ainsi les doublons en mémoire.
•	Algorithme de Tri : Implémentation d'un Comparator personnalisé pour générer un classement décroissant (les meilleures moyennes en premier).
•	Formatage de Sortie : Utilisation de println et String.format pour un affichage en console parfaitement aligné et des données CSV précises à deux décimales.

SCÉNARIOS DE TESTS RÉALISÉS
•	Fichier CSV Absent ou Corrompu : Géré par une exception avec message utilisateur clair.
•	Entrées Invalides : Test de saisie de texte dans les menus numériques et de chiffres dans les champs de texte.
•	Mise à jour Dynamique : Test de suppression d'un étudiant en milieu de liste avec réorganisation immédiate du classement.
•	Sauvegarde des données : Vérification de la création automatique du fichier classement.csv après traitement.
