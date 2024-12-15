Application de Météo - Java EE


Description

Cette application permet aux utilisateurs de consulter les prévisions météo en temps réel pour différentes villes du monde. Développée en Java EE, elle utilise l'API OpenWeatherMap pour récupérer les données météorologiques.

Fonctionnalités

Recherche des prévisions météo par ville.

Affichage des informations détaillées :

Température actuelle (en Celsius/Fahrenheit).

Humidité.

Pression atmosphérique.

Description des conditions météorologiques.


Interface utilisateur simple et intuitive basée sur JSP/HTML/CSS.




Prérequis

Logiciels nécessaires :

Java Development Kit (JDK) 11 ou supérieur.

Serveur d'applications Java EE (par ex. Apache TomEE, WildFly ou GlassFish).

Maven pour la gestion des dépendances.


API utilisée :

OpenWeatherMap API : Vous devez obtenir une clé API gratuite depuis OpenWeatherMap.


Installation et Configuration

1. Clonez le projet :

git clone https://github.com/codemk-begginer/java_project.git  
cd java_project


2. Configurer l'API Key OpenWeatherMap :

Ajoutez la clé API dans un fichier .env ou dans un fichier de configuration sécurisé.

Exemple d'utilisation avec un fichier .env :

OPENWEATHERMAP_API_KEY=votre_cle_api



3. Construire le projet avec Maven :

mvn clean install


4. Déployez l'application sur le serveur d'applications :

Copiez le fichier .war généré (dans le dossier target/) vers le répertoire de déploiement de votre serveur d'applications.

Exemple pour Apache TomEE : déplacez le .war dans le dossier webapps/.



5. Lancer le serveur :

Accédez à l'application via votre navigateur web :

http://localhost:8080/MyWeatherApp




Structure du Projet

/  
├── src/  
│   ├── main/java/  
│   │   ├── controllers/         # Servlets pour gérer les requêtes HTTP  
│   │   ├── services/            # Classes pour la logique métier  
│   │   ├── models/              # Représentation des données météo  
│   │   └── utils/               # Classes utilitaires (connexion API, gestion des erreurs)  
│   ├── main/webapp/  
│       ├── WEB-INF/             # Configuration du déploiement (web.xml)  
│       ├── css/                 # Feuilles de style  
│       └── jsp/                 # Pages JSP pour l'interface utilisateur  
├── pom.xml                      # Dépendances Maven  
└── README.md                    # Documentation du projet

Technologies utilisées

Java EE (Servlets, JSP, etc.).

Maven pour la gestion des dépendances.

HTML/CSS pour le front-end.

OpenWeatherMap API pour les données météo.



Auteurs

[CodeMk-Begginer]

Contact : 



