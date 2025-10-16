Voici le prompt utilisé pour l'exo5 :


Je travaille sur un TP Java dans Eclipse, de type Dynamic Web Project, déployé sur WildFly.
L’objectif est de réaliser une application web qui permet de générer dynamiquement un code-barres à partir d’un formulaire HTML ou un utilisateur rentre l'info à integrer dans le code QR.

Fonctionnalités demandées :
 -  Une servlet :
     -  en GET → affiche une page d’accueil avec un message de bienvenue et un formulaire de saisie.
     -  en POST → génère un code-barres sous forme d’image.
 -  Le message encodé dans le code-barres doit être de la forme : "Le code du formulaire est <code>. Le libellé est <libellé>."

Contraintes techniques :
 -  Utiliser la bibliothèque Barcode4J (version 2.1) et ses dépendances :
     -  avalon-framework-api:4.2.0
     -  avalon-framework-impl:4.2.0
 -  Le projet doit fonctionner en Dynamic Web Project.
 -  Le code doit être compatible avec WildFly et le JDK 17+.

Ce que je souhaite obtenir :
 -  Que tu m'aides dans le code de la servlet (QrcodeServlet.java) implémentant doGet() et doPost().
 -  Un exemple de page HTML générée (formulaire et affichage du code-barres).
 -  Les étapes détaillées pour ajouter les librairies Barcode4J dans Eclipse.
 -  Les étapes détaillées pour configurer correctement mon IDE Eclipse
 -  Des conseils pour tester le tout.

En résumé :
« Aide-moi à créer une application web Java simple qui génère un code-barres via Barcode4J à partir d’un formulaire (code + libellé), avec explications et configuration Eclipse. »
