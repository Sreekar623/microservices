# Spring Boot Microservices Project

A basic microservices architecture built using Spring Boot and Spring Cloud.  
This project demonstrates service decomposition, centralized configuration, service discovery, API Gateway routing, inter-service communication, and Kafka-based asynchronous messaging.

---

# Microservices Included

- API Gateway
- Config Server
- Service Registry (Eureka Server)
- Employee Service
- Department Service

---

# Features

- REST API Development
- Microservices Architecture
- Service Discovery using Eureka
- Centralized Configuration using Config Server
- API Gateway Routing
- Inter-Service Communication
- Kafka Integration
- Layered Backend Architecture
- Exception Handling
- DTO Implementation
- Spring Data JPA Integration
- Validation & Logging

---

# Tech Stack

- Java
- Spring Boot
- Spring Cloud
- Eureka Server
- API Gateway
- Config Server
- Apache Kafka
- Spring Data JPA
- Hibernate
- MySQL
- Maven

---

# Architecture Flow

```text
Client
   ↓
API Gateway
   ↓
Microservices
   ├── Employee Service
   └── Department Service
