# Gestion des Tournois d'E-sport

## Description

Ce projet est une application Java qui permet de gérer les tournois d'e-sport. Il offre des fonctionnalités pour gérer les joueurs, les équipes et les tournois. L'application utilise Spring Core pour l'inversion de contrôle et JPA/Hibernate pour l'accès aux données, avec H2 comme base de données.

## Fonctionnalités Principales

- **Gestion des Joueurs** : Inscription, modification, suppression et affichage d'un ou plusieurs joueurs.
- **Gestion des Équipes** : Création, modification, ajout/retrait de joueurs et affichage d'une ou plusieurs équipes.
- **Gestion des Tournois** : Création, modification, ajout/retrait d'équipes et affichage d'un ou plusieurs tournois.

## Structure des Classes Principales

- **Joueur** : `pseudo`, `âge`, `équipe`
- **Équipe** : `nom`, `joueurs`, `tournois`, `classement`
- **Tournoi** : `titre`, `jeu`, `date de début`, `date de fin`, `nombre de spectateurs`, `équipes`, `dureeEstimee`, `tempsPause`, `tempsCeremonie`, `statut` (PLANIFIE, EN_COURS, TERMINE, ANNULE)
- **Jeu** : `nom`, `difficulté`, `durée moyenne d'un match`

## Interfaces Principales

- **TournoiDao**
    - Méthode : `calculerdureeEstimeeTournoi(Long tournoiId)`

- **TournoiMetier**
    - Méthode : `obtenirdureeEstimeeTournoi(Long tournoiId)`

## Classes d'Implémentation

- **TournoiDaoImpl** (implémente TournoiDao)
- **TournoiDaoExtension** (implémente TournoiDao)
- **TournoiMetierImpl** (implémente TournoiMetier)

## Règles de Calcul de la Durée Totale Estimée du Tournoi

- **Calcul de Base** (TournoiDaoImpl) :  
  Durée estimée = (Nombre d'équipes × Durée moyenne d'un match) + (Temps de pause entre les matchs)

- **Calcul Avancé** (TournoiDaoExtension) :  
  Durée estimée = (Nombre d'équipes × Durée moyenne d'un match × difficulté du jeu) + (Temps de pause entre les matchs) + (Temps pour les cérémonies d'ouverture et de clôture)

## Configuration du Projet

### Fichiers de Configuration

- **`applicationContext.xml`** : Configuration de Spring
- **`pom.xml`** : Configuration Maven
- **`persistence.xml`** : Configuration JPA et H2

### Exemple de Configuration de `applicationContext.xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:tx="http://www.springframework.org/schema/tx"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
                           http://www.springframework.org/schema/beans/spring-beans.xsd
                           http://www.springframework.org/schema/context
                           http://www.springframework.org/schema/context/spring-context.xsd
                           http://www.springframework.org/schema/tx
                           http://www.springframework.org/schema/tx/spring-tx.xsd">

    <bean id="entityManagerFactory" class="org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean">
        <property name="persistenceXmlLocation" value="classpath:META-INF/persistence.xml"/>
        <property name="jpaVendorAdapter">
            <bean class="org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter"/>
        </property>
    </bean>

    <!-- H2 Web Server Bean -->
    <bean id="h2WebServer" class="org.h2.tools.Server" factory-method="createWebServer" init-method="start" destroy-method="stop">
        <constructor-arg value="-web,-webAllowOthers,-webPort,8083" />
    </bean>

    <!-- Définition des beans pour les repositories -->
    <bean id="tournoiRepository" class="org.toure.Repository.Implementation.TournoiRepositoryImpl"></bean>
    <bean id="equipeRepository" class="org.toure.Repository.Implementation.EquipeRepositoryImpl"/>
    <bean id="joueurRepository" class="org.toure.Repository.Implementation.JoueurRepositoryImpl"/>

    <!-- Définition des beans pour les services -->
    <bean id="tournoiService" class="org.toure.Service.TournoiService">
        <constructor-arg ref="tournoiRepository"/>
    </bean>
    <bean id="equipeService" class="org.toure.Service.EquipeService">
        <constructor-arg ref="equipeRepository"/>
    </bean>
    <bean id="joueurService" class="org.toure.Service.JoueurService">
        <constructor-arg ref="joueurRepository"/>
    </bean>

</beans>
