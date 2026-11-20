# TP1 — Implémentation d'un micro-service

**Étudiant :** Zayd Kassimi — EMSI, Architectures Micro Services

## Ce que j'ai fait

J'ai créé un micro-service de gestion des comptes bancaires, `ebank-service`, en Spring Boot 2.7.3 avec Java 17.

### Étapes réalisées

1. Création du projet Spring Boot avec Web, Spring Data JPA, H2 et Lombok
2. Création de l'entité `BankAccount` (`id`, `createdAt`, `balance`, `currency`, `type`)
3. Création du repository `BankAccountRepository` avec Spring Data JPA
4. Test de la couche DAO
5. Création du web service REST pour gérer les comptes
6. Test du micro-service avec Postman
7. Génération de la documentation Swagger des API REST
8. Exposition d'une API REST avec Spring Data REST et des projections
9. Création des DTOs et des Mappers
10. Création de la couche Service
11. Création du web service GraphQL

## Comment lancer le projet

```bash
mvn spring-boot:run
```

L'application démarre sur le port **8081**.

- Base H2 en mémoire `bank-db`, console H2 : http://localhost:8081/h2-console
- Swagger UI : http://localhost:8081/swagger-ui.html
- GraphiQL : http://localhost:8081/graphiql

Au démarrage, 3 clients sont créés (Mohamed, Yasmine, Hassan) avec 10 comptes chacun, soit 30 comptes.

## Endpoints

**REST** — http://localhost:8081/api

- `GET /api/bankAccounts`
- `GET /api/bankAccounts/{id}`
- `POST /api/bankAccounts`
- `PUT /api/bankAccounts/{id}`
- `DELETE /api/bankAccounts/{id}`

**Spring Data REST** — http://localhost:8081

- `GET /bankAccounts?page=0&size=2`
- `GET /bankAccounts/search/byType?type=CURRENT`
- `GET /bankAccounts?projection=p1`

**GraphQL** — `POST http://localhost:8081/graphql`

- Queries : `accountList`, `bankAccountById(id)`, `customerList`
- Mutations : `addAccount`, `updateAccount`, `deleteAccount`
