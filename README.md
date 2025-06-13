# 🎯 QuizApp – Microservices-Based Quiz Management System

![Spring Boot](https://img.shields.io/badge/SpringBoot-3.0-green.svg)
![PostgreSQL](https://img.shields.io/badge/Database-PostgreSQL-blue)
![Microservices](https://img.shields.io/badge/Architecture-Microservices-orange)

---

## 📖 Overview

**QuizApp** is a microservices-based backend system that enables users to create quizzes from selected categories, fetch quiz questions, submit answers, and receive scores instantly — all via RESTful APIs.

It uses **Spring Cloud**, **Eureka Server**, **OpenFeign**, and **Spring Gateway** to demonstrate distributed architecture, service discovery, and inter-service communication.

---

## ⚙️ Tech Stack

| Layer            | Technology                     |
|------------------|--------------------------------|
| Backend Services | Spring Boot (Java 17)          |
| API Gateway      | Spring Cloud Gateway           |
| Service Registry | Eureka Server                  |
| Inter-Service    | OpenFeign                      |
| Database         | PostgreSQL                     |
| Build Tool       | Maven                          |
| Testing          | Postman                        |

---

## 📂 Microservice Modules

- **Quiz-Service**: Handles quiz creation, question fetching, and score calculation.
- **Question-Service**: Manages the question bank (CRUD operations).
- **API-Gateway**: Routes and load-balances API requests.
- **Eureka-Server**: Service discovery and registration.

---

## 🔌 Sample API Endpoints

### Question-Service
- `POST /question/add`
- `GET /question/all`
- `DELETE /question/{id}`

### Quiz-Service (via Gateway)
- `POST /quiz-service/quiz/create`
- `GET /quiz-service/quiz/get/{id}`
- `POST /quiz-service/quiz/submit/{id}`

---

## 🧪 How to Run the Project

### 1️⃣ Clone the repository
```bash
git clone https://github.com/seriouslyanuj/QuizApp.git
cd QuizApp
````
---

### 2️⃣ Set up PostgreSQL

```sql
CREATE DATABASE quizdb;
```
---

### 3️⃣ Configure `application.properties` for each service

Update the following in each module:

* PostgreSQL DB URL, username, password
* Port numbers
* Eureka server URL

---

### 4️⃣ Run Services in Order

Start the services one by one:

1. Eureka Server
2. Question Service
3. Quiz Service
4. API Gateway

Run using:

```bash
./mvnw spring-boot:run
```

or directly from your IDE (IntelliJ, Eclipse).

---

## 🧠 What I Learned

- ✅ Microservices communication using **Feign**  
- ✅ API Gateway for centralized **routing**  
- ✅ Service registration with **Eureka**  
- ✅ Clean **RESTful API** design  
- ✅ Modular service **deployment and scaling**
