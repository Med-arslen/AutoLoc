# Stratégie de Fetch – AutoLoc

## Objectif
Documenter les choix de `FetchType` retenus pour chaque association du modèle AutoLoc, conformément aux bonnes pratiques JPA/Hibernate et aux recommandations de l’Atelier 2.

## Règles générales appliquées

| Type d’association | Fetch par défaut JPA | Choix AutoLoc | Justification |
|--------------------|----------------------|---------------|---------------|
| `@ManyToOne`       | EAGER                | **LAZY**      | Évite le chargement en cascade de toute la chaîne d’objets |
| `@OneToOne`        | EAGER                | **LAZY**      | Même raison |
| `@OneToMany`       | LAZY                 | **LAZY**      | Une collection ne doit être chargée que si elle est réellement utilisée |
| `@ManyToMany`      | LAZY                 | **LAZY**      | Idem |

## Détail par association

| Association                    | Annotations                          | Fetch retenu | Cascade / remarque |
|--------------------------------|--------------------------------------|--------------|--------------------|
| Contrat → Paiement             | `@OneToMany` / `@ManyToOne`          | LAZY         | `CascadeType.ALL` + `orphanRemoval = true` |
| Reservation ↔ Contrat          | `@OneToOne`                          | LAZY         | `CascadeType.ALL` côté Reservation |
| Client → Reservation           | `@OneToMany` / `@ManyToOne`          | LAZY         | `CascadeType.PERSIST` |
| Reservation → Vehicule         | `@ManyToOne`                         | LAZY         | Aucune |
| Agence → Vehicule              | `@OneToMany` / `@ManyToOne`          | LAZY         | Aucune (un véhicule survit à son agence) |
| Agence → Employe               | `@OneToMany` / `@ManyToOne`          | LAZY         | Aucune |
| Vehicule ↔ Equipement          | `@ManyToMany`                        | LAZY         | Aucune (équipements partagés – utilisation d’un `Set`) |
| Vehicule → Maintenance         | `@OneToMany` / `@ManyToOne`          | LAZY         | `CascadeType.PERSIST` |

## Pourquoi LAZY presque partout ?

- **Performance** : on ne charge que ce dont on a réellement besoin.
- **Évite les problèmes N+1** et les requêtes trop lourdes.
- **Meilleure scalabilité** de l’application.

## Point d’attention

Avec `FetchType.LAZY`, l’accès à une association hors d’une transaction ouverte provoque une `LazyInitializationException`.  
Ce point sera traité plus tard (Atelier sur les requêtes et les DTOs) avec :
- des requêtes JPQL / `EntityGraph`
- ou un mapping vers des DTOs.

## Configuration finale retenue

```java
// Exemple typique côté inverse
@OneToMany(mappedBy = "contrat",
           cascade = CascadeType.ALL,
           orphanRemoval = true,
           fetch = FetchType.LAZY)
private List<Paiement> paiements = new ArrayList<>();