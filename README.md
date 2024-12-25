# Application Web de Météo

Ce projet est une application web de météo développée en Java EE à l'aide de l'IDE Eclipse. Elle permet aux utilisateurs de consulter les prévisions météorologiques pour différentes localités.

__Fonctionnalités__

* Rechercher une ville : Entrez le nom d'une ville pour consulter les prévisions météo.

* Affichage des détails météo : Température, humidité, vitesse du vent, etc.

* Interface utilisateur conviviale : Une interface simple et intuitive pour naviguer facilement.


__Technologies Utilisées__

* Backend : Java EE (Servlets, JSP)

* Frontend : HTML, CSS, JavaScript

* Serveur d'application : Apache Tomcat v10.1

* IDE : Eclipse IDE for java ee developpers 




__Prérequis__

Avant de commencer, assurez-vous que les éléments suivants sont installés sur votre machine :

* JDK 21 (pour vérifier que le jdk a bien été installer , ouvrez un terminale puis saisissez la commande `java --version`)

* Eclipse IDE for java ee developpers

* Apache Tomcat v10.1




__Installation et Configuration__

1. __Clonez ce dépôt sur votre machine locale.__

git clone -b main --single-branch https://github.com/codemk-begginer/java_project.git




2. __Importez le projet dans Eclipse :__

Ouvrez Eclipse.

Cliquez sur File > Import > Existing Projects into Workspace.

Sélectionnez le dossier contenant le projet.



3. __Configurez Apache Tomcat :__

Allez dans Window > Preferences > Server > Runtime Environments.

Cliquez sur Add et sélectionnez votre version de Tomcat.

Spécifiez le chemin d'installation de Tomcat.  

*(une fois que vous avez terminé pour vérifier que apache tomcat a bien été installé vous allez dans l'arborescence du projet vous ouvrez java resource ensuite vous ouvrez libraries a l'interieur vous devrez trouver "server runtime[apache tomcat v10.1]" )*



4. __Déployez l'application sur le serveur Tomcat :__

ouvrez et Faites un clic droit sur le fichier MyServlet.java contennue dans src/main/java > MyPackage   .

Sélectionnez Run As > Run on Server.




5. __Accédez à l'application dans votre navigateur à l'adresse suivante__   
*(si l'application ne se lance pas automatiquement sur le navigateur)* :

http://localhost:8080/MyWeatherApp

