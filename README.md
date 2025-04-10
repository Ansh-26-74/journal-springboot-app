# 📝 Journal App — Spring Boot CRUD API

Welcome to the **JournalApplication**, a beginner-friendly RESTful API built using **Spring Boot**. It allows users to perform **Create, Read, Update, and Delete** (CRUD) operations on journal entries, stored temporarily in-memory using Java's `HashMap`.

---

## 👨‍💻 Made by: Ansh Mishra

- 📍 Pune, India
- 🎓 Computer Engineering @ G. H. Raisoni College
- 💼 Aspiring Backend Developer | Spring Boot & Java Enthusiast

---

## 🚀 Features

- ✨ Create a new journal entry
- 📚 View all or specific journal entries
- ♻️ Update existing entries
- 🗑️ Delete entries
- ⚡ Fast in-memory storage (no DB required yet!)

---

## 💡 Future Upgrades

- 🔌 Integrate MySQL/PostgreSQL
- 🔒 Add input validation using `@Valid`
- 📘 Auto-generate API docs using Swagger
- ☁️ Deploy live on Render/Railway
- 🔐 JWT-based user authentication

---

## 🛠 Tech Stack

- Java 17+
- Spring Boot
- Maven
- Postman (for testing)

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