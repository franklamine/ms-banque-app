Banking Microservices Application

Cette application bancaire utilise Spring Boot et Spring Cloud avec une architecture microservices. Elle comprend quatre services : discovery-service (Eureka Server), gateway-service (Spring Cloud Gateway), account-service et customer-service.

Chaque service a sa propre base H2 : account-db pour les comptes et customer-db pour les clients.

Le account-service gère les comptes et récupère les informations clients depuis le customer-service via un Feign Client. 

Un Circuit Breaker protège l’application si le customer-service ne répond pas, permettant de retourner un client par défaut. 

Le gateway-service expose toutes les routes et utilise le DiscoveryClient pour générer dynamiquement les chemins d’accès aux services, avec les noms de services.

Cette architecture assure l’isolation des données, la résilience grâce au Circuit Breaker et la découverte automatique des services, tout en centralisant l’accès via le gateway pour simplifier les appels des clients.

La configuration des microservices est centralisée à l’aide de Spring Cloud Config Server (config-service). 
Les fichiers de configuration sont stockés dans un dépôt GitHub, ce qui permet de gérer les paramètres applicatifs (ports, URLs, configurations spécifiques) de manière centralisée et versionnée. 
Chaque microservice (account-service, customer-service, gateway-service) récupère sa configuration au démarrage depuis le config-service, facilitant la maintenance, la cohérence des configurations et leur mise à jour sans duplication.