Banking Microservices Application

Cette application bancaire utilise Spring Boot et Spring Cloud avec une architecture microservices. Elle comprend quatre services : discovery-service (Eureka Server), gateway-service (Spring Cloud Gateway), account-service et customer-service.

Chaque service a sa propre base H2 : account-db pour les comptes et customer-db pour les clients.

Le account-service gère les comptes et récupère les informations clients depuis le customer-service via un Feign Client. 

Un Circuit Breaker protège l’application si le customer-service ne répond pas, permettant de retourner un client par défaut. 

Le gateway-service expose toutes les routes et utilise le DiscoveryClient pour générer dynamiquement les chemins d’accès aux services, avec les noms de services.

Cette architecture assure l’isolation des données, la résilience grâce au Circuit Breaker et la découverte automatique des services, tout en centralisant l’accès via le gateway pour simplifier les appels des clients.