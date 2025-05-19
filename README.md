# Auth API with JWT 🔐

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)

This is a simple authentication project using **Spring Boot** and **JWT (JSON Web Token)**. It doesn't use a database — user data is stored in memory for learning purposes only.

## 📦 Features

- User registration (`/register`)
- Login and JWT token generation (`/login`)
- Protected endpoint that only accepts authenticated users (`/secure`)
- Automatic JWT validation on all protected requests

## 🚀 Technologies Used

- Java 17+
- Spring Boot 3+
- Spring Security
- JWT (`io.jsonwebtoken.Jwts`)
- Maven
- Postman (for testing)

## 🛠️ How to Use

### 1. Clone the Repository

```bash
git clone https://github.com/bruno2leite/auth-api-jwt.git
cd auth-api-jwt
```
### 2. Start the application

Run with Maven:

```bash
mvn spring-boot:run
```

The application will be available by default at:

```
http://localhost:8080
```

---

## 📮 API Endpoints

### 🔸 `POST /register`

Registers a new user.

**Request body:**

```json
{
  "username": "your username",
  "password": "your password"
}
```

---

### 🔸 `POST /login`

Authenticates the user and returns a **JWT token**.

**Request body:**

```json
{
  "username": "your username",
  "password": "your password"
}
```

**Response:**

```
eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJicnVubyIsImV4cCI6...
```

---

### 🔸 `GET /secure`

Protected route. Requires a valid JWT in the header.

**Request header:**

```
Authorization: Bearer <your_token_here>
```

**Response:**

```json
"You are authenticated"
```

---

## ✅ Testing the API

Use [Postman](https://www.postman.com/) to test each step:

1. **Register** a user (POST `/register`)
2. **Login** and copy the token (POST `/login`)
3. Use the token to access **Secure** (GET `/secure`)

---


## 🧑‍💻 Author

Developed by **Bruno Leite**  
Linkedin: www.linkedin.com/in/brunoprestesleite
