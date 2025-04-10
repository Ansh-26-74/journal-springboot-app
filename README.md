# 📝 Journal Spring Boot App

A simple Spring Boot REST API for managing personal journal entries. This project demonstrates basic CRUD operations using in-memory JSON storage — no database required!

---

## 🚀 Features

- ✅ Create journal entries
- 📖 Read all or specific entries
- 🔁 Update entries
- ❌ Delete entries
- 🧠 Data stored in-memory using Java `HashMap`

---

## 🔧 Tech Stack

- Java 17+
- Spring Boot
- Maven
- Postman (for API testing)

---

## 📦 API Endpoints

| Method | Endpoint               | Description                  |
|--------|------------------------|------------------------------|
| GET    | `/journal`             | Get all journal entries      |
| POST   | `/journal`             | Create a new entry           |
| GET    | `/journal/id/{id}`     | Get entry by ID              |
| PUT    | `/journal`             | Update entry by ID           |
| DELETE | `/journal/id/{id}`     | Delete entry by ID           |

---

## 📂 Project Structure

JournalApplication/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── AnshSpringBootProjects/
│       │           └── JournalApplication/
│       │               ├── Controller/
│       │               │   └── JournalEntriesController.java
│       │               ├── Entity/
│       │               │   └── JournalEntries.java
│       │               └── JournalApplication.java
│       └── resources/
│           └── application.properties
├── pom.xml

---

## 🛠 How to Run

1. Clone this repo:
   ```bash
   git clone https://github.com/Ansh-26-74/journal-springboot-app.git
   cd journal-springboot-app