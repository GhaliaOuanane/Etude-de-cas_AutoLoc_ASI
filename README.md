# AutoLoc API - Système de Location de Véhicules

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1.1-brightgreen)
![Java](https://img.shields.io/badge/Java-17-orange)
![Build](https://img.shields.io/badge/build-passing-success)
![License](https://img.shields.io/badge/license-MIT-blue)

Application Spring Boot pour la gestion d'un système de location de véhicules (AutoLoc).

## 📋 Table des matières

- [Fonctionnalités](#fonctionnalités)
- [Architecture](#architecture)
- [Technologies](#technologies)
- [Prérequis](#prérequis)
- [Installation](#installation)
- [Configuration](#configuration)
- [Utilisation](#utilisation)
- [Structure du projet](#structure-du-projet)
- [Documentation](#documentation)
- [Ateliers](#ateliers)

## ✨ Fonctionnalités

### Entités Gérées (9)

- 🏢 **Agence** : Gestion des agences de location
- 👤 **Client** : Gestion des clients
- 📄 **Contrat** : Gestion des contrats de location
- 👨‍💼 **Employe** : Gestion des employés
- 🔧 **Equipement** : Équipements des véhicules
- 🛠️ **Maintenance** : Historique de maintenance
- 💳 **Paiement** : Gestion des paiements
- 📅 **Reservation** : Système de réservation
- 🚗 **Vehicule** : Gestion du parc automobile

### Opérations CRUD Complètes

Toutes les entités disposent d'un service complet avec :
- ✅ Create (Créer)
- ✅ Read (Lire)
- ✅ Update (Mettre à jour)
- ✅ Delete (Supprimer)
- ✅ Read All (Lire tous)
- ✅ Create Multiple (Créer plusieurs)

## 🏗️ Architecture

Le projet suit une architecture en couches (Layered Architecture) :

```
┌─────────────────────────────────┐
│   Controllers (REST)            │  ← Atelier 5
├─────────────────────────────────┤
│   Services (Business Logic)     │  ← Atelier 3 ✅
├─────────────────────────────────┤
│   Repositories (Data Access)    │  ← Atelier 3 ✅
├─────────────────────────────────┤
│   Entities (Domain Model)       │  ← Ateliers 1 & 2 ✅
├─────────────────────────────────┤
│   Database (MySQL)              │
└─────────────────────────────────┘
```

### Packages

```
tn.esprit.autoloc.autolocapi/
├── domain/              # Entités JPA (9)
├── Repository/          # Repositories Spring Data JPA (9)
└── service/             # Services métier (18 fichiers)
    ├── I*Service        # Interfaces (9)
    └── *ServiceImpl     # Implémentations (9)
```

## 🛠️ Technologies

### Backend
- **Spring Boot** 4.1.1
- **Spring Data JPA** (Hibernate)
- **Java** 17
- **Maven** (Build tool)
- **Lombok** (Réduction boilerplate)

### Base de données
- **MySQL** (SGBD relationnel)
- **MySQL Connector** (Driver JDBC)

### Outils de développement
- **IntelliJ IDEA** (IDE recommandé)
- **SonarQube for IDE** (Analyse qualité code)
- **Git** (Gestion de version)

## 📦 Prérequis

- ☕ Java 17 ou supérieur
- 🗄️ MySQL 8.0+
- 📦 Maven 3.6+ (ou utiliser le wrapper inclus)
- 💻 IDE (IntelliJ IDEA recommandé)

## 🚀 Installation

### 1. Cloner le dépôt

```bash
git clone https://github.com/GhaliaOuanane/Etude-de-cas_AutoLoc_ASI.git
cd Etude-de-cas_AutoLoc_ASI
```

### 2. Configurer la base de données

Créer une base de données MySQL :

```sql
CREATE DATABASE autoloc_db;
```

### 3. Configurer application.properties

Éditer `src/main/resources/application.properties` :

```properties
# Configuration MySQL
spring.datasource.url=jdbc:mysql://localhost:3306/autoloc_db
spring.datasource.username=votre_utilisateur
spring.datasource.password=votre_mot_de_passe

# Configuration JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
logging.level.org.hibernate.SQL=DEBUG
```

### 4. Compiler et exécuter

```bash
# Avec Maven wrapper (recommandé)
./mvnw.cmd clean install   # Windows
./mvnw clean install       # Linux/Mac

# Lancer l'application
./mvnw.cmd spring-boot:run   # Windows
./mvnw spring-boot:run       # Linux/Mac
```

## ⚙️ Configuration

### application.properties

```properties
# Serveur
server.port=8080

# Base de données
spring.datasource.url=jdbc:mysql://localhost:3306/autoloc_db
spring.datasource.username=root
spring.datasource.password=

# JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# Logs
logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE
```

## 💻 Utilisation

### Exemple d'utilisation des services

#### ClientService

```java
@Autowired
private IClientService clientService;

// Créer un client
Client client = new Client();
client.setNom("Dupont");
client.setPrenom("Jean");
client.setEmail("jean.dupont@email.com");
Client saved = clientService.addClient(client);

// Récupérer tous les clients
List<Client> clients = clientService.retrieveAllClients();

// Récupérer un client
Client client = clientService.retrieveClient(1L);

// Mettre à jour
client.setEmail("nouveau@email.com");
clientService.updateClient(client);

// Supprimer
clientService.removeClient(1L);
```

#### VehiculeService

```java
@Autowired
private IVehiculeService vehiculeService;

// Créer un véhicule
Vehicule vehicule = new Vehicule();
vehicule.setImmatriculation("TUN-123");
vehicule.setMarque("Toyota");
vehicule.setModele("Corolla");
Vehicule saved = vehiculeService.addVehicule(vehicule);

// Opérations CRUD similaires à ClientService
```

Pour plus d'exemples, consultez [README_SERVICES.md](README_SERVICES.md)

## 📁 Structure du projet

```
autoloc-api/
├── src/
│   ├── main/
│   │   ├── java/tn/esprit/autoloc/autolocapi/
│   │   │   ├── domain/                    # 9 entités JPA
│   │   │   │   ├── Agence.java
│   │   │   │   ├── Client.java
│   │   │   │   ├── Contrat.java
│   │   │   │   ├── Employe.java
│   │   │   │   ├── Equipement.java
│   │   │   │   ├── Maintenance.java
│   │   │   │   ├── Paiement.java
│   │   │   │   ├── Reservation.java
│   │   │   │   └── Vehicule.java
│   │   │   │
│   │   │   ├── Repository/                # 9 repositories
│   │   │   │   ├── IAgenceRepository.java
│   │   │   │   ├── IClientRepository.java
│   │   │   │   └── ... (7 autres)
│   │   │   │
│   │   │   └── service/                   # 18 fichiers
│   │   │       ├── IAgenceService.java    # Interfaces
│   │   │       ├── AgenceServiceImpl.java # Implémentations
│   │   │       └── ... (16 autres)
│   │   │
│   │   └── resources/
│   │       └── application.properties
│   │
│   └── test/
│       └── java/...
│
├── docs/
│   └── repository-notes.md               # Documentation technique
│
├── pom.xml                               # Configuration Maven
├── README.md                             # Ce fichier
├── README_SERVICES.md                    # Guide d'utilisation services
├── ATELIER3_RESUME.md                    # Résumé Atelier 3
├── VERIFICATION_ATELIER3.md              # Checklist vérification
└── COMPATIBILITE_RAPPORT.md              # Rapport compatibilité
```

## 📚 Documentation

| Document | Description |
|----------|-------------|
| [README_SERVICES.md](README_SERVICES.md) | Guide complet d'utilisation des services |
| [docs/repository-notes.md](docs/repository-notes.md) | Documentation technique repositories |
| [ATELIER3_RESUME.md](ATELIER3_RESUME.md) | Résumé des modifications Atelier 3 |
| [VERIFICATION_ATELIER3.md](VERIFICATION_ATELIER3.md) | Checklist de vérification |
| [COMPATIBILITE_RAPPORT.md](COMPATIBILITE_RAPPORT.md) | Rapport de compatibilité |

## 🎓 Ateliers

### ✅ Atelier 1 - Projet Spring Boot
- Initialisation projet Spring Boot
- Configuration base de données MySQL
- Structure de base

### ✅ Atelier 2 - Entités JPA
- 9 entités du domaine
- Associations JPA (OneToMany, ManyToOne, ManyToMany)
- Énumérations (StatutVehicule, ModePaiement, etc.)

### ✅ Atelier 3 - Repositories et Services (ACTUEL)
- 9 repositories JpaRepository
- 9 interfaces de service
- 9 implémentations de service
- CRUD complet pour toutes les entités
- Focus détaillé sur Client et Vehicule

### 🔜 Atelier 4 - Couche métier avancée
- Méthodes de requêtes personnalisées
- Query methods
- Transactions complexes

### 🔜 Atelier 5 - Contrôleurs REST
- API REST complète
- Endpoints CRUD
- Documentation Swagger

## 🔍 Commandes utiles

```bash
# Compiler le projet
./mvnw.cmd clean compile

# Exécuter les tests
./mvnw.cmd test

# Créer le package JAR
./mvnw.cmd clean package

# Lancer l'application
./mvnw.cmd spring-boot:run

# Vérification complète
./mvnw.cmd clean verify
```

## 🤝 Contribution

1. Fork le projet
2. Créer une branche (`git checkout -b feature/nouvelle-fonctionnalite`)
3. Commit les changements (`git commit -m 'Ajout nouvelle fonctionnalité'`)
4. Push vers la branche (`git push origin feature/nouvelle-fonctionnalite`)
5. Ouvrir une Pull Request

## 📝 Conventions de code

- ✅ Préfixe `I` pour les interfaces repository
- ✅ Suffixe `Service` pour les interfaces de service
- ✅ Suffixe `ServiceImpl` pour les implémentations
- ✅ Annotations Lombok (`@AllArgsConstructor`, `@Getter`, `@Setter`)
- ✅ Injection par constructeur (immutabilité)
- ✅ Gestion d'erreurs avec `Optional.orElseThrow()`

## 📄 Licence

Ce projet est sous licence MIT.

## 👥 Auteurs

- **Ghalia Ouanane** - [GitHub](https://github.com/GhaliaOuanane)

## 🔗 Liens utiles

- [Documentation Spring Boot](https://spring.io/projects/spring-boot)
- [Documentation Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Lombok](https://projectlombok.org/)
- [MySQL](https://www.mysql.com/)

---

⭐ **Si ce projet vous aide, n'oubliez pas de lui donner une étoile !** ⭐
