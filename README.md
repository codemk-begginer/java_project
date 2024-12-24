Application Web de Météo

Ce projet est une application web de météo développée en Java EE à l'aide de l'IDE Eclipse. Elle permet aux utilisateurs de consulter les prévisions météorologiques pour différentes localités.

Fonctionnalités

Rechercher une ville : Entrez le nom d'une ville pour consulter les prévisions météo.

Affichage des détails météo : Température, humidité, vitesse du vent, etc.

Interface utilisateur conviviale : Une interface simple et intuitive pour naviguer facilement.


Technologies Utilisées

Backend : Java EE (Servlets, JSP)

Frontend : HTML, CSS, JavaScript

Serveur d'application : Apache Tomcat v10.1

IDE : Eclipse IDE for java ee developpers 




Prérequis

Avant de commencer, assurez-vous que les éléments suivants sont installés sur votre machine :

JDK 21

Eclipse IDE for java ee developpers

Apache Tomcat v10.1




Installation et Configuration

1. Clonez ce dépôt sur votre machine locale.

git clone https://github.com/codemk-begginer/java_project.git



2. Importez le projet dans Eclipse :

Ouvrez Eclipse.

Cliquez sur File > Import > Existing Projects into Workspace.

Sélectionnez le dossier contenant le projet.



3. Configurez Apache Tomcat :

Allez dans Window > Preferences > Server > Runtime Environments.

Cliquez sur Add et sélectionnez votre version de Tomcat.

Spécifiez le chemin d'installation de Tomcat.
(une fois que vous avez terminé pour vérifier que apache tomcat a bien été installé vous allez dans l'arborescence du projet vous ouvrez java resource ensuite vous ouvrez libraries a l'interieur vous devrez trouver "server runtime[apache tomcat v10.1]" )



4. Déployez l'application sur le serveur Tomcat :

Faites un clic droit sur le projet dans Eclipse.

Sélectionnez Run As > Run on Server.




5. Accédez à l'application dans votre navigateur à l'adresse suivante (si l'application ne se lance pas automatiquement sur le navigateur) :

http://localhost:8080/MyWeatherApp

