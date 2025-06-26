# 📸 Photopedia API

![Java](https://img.shields.io/badge/Java-17-blue?logo=java) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5-success?logo=springboot) ![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-blue?logo=postgresql) ![License](https://img.shields.io/badge/license-MIT-lightgrey)

Photopedia is a RESTful API built with **Spring Boot**, designed to manage photographers, their albums, and photos.  
It allows CRUD operations on all entities, uses a relational database with **JPA**, and provides interactive **Swagger** documentation.

URL de teste: https://photopedia-pdyu.onrender.com/swagger-ui/index.html

---

## 🧩 Technologies

- ⚙️ Spring Boot 3
- ☕ Java 17
- 🐘 PostgreSQL
- 📚 Spring Data JPA
- 📄 MapStruct (DTO mapping)
- 🧪 Hibernate Validator (Bean Validation)
- 🔍 Swagger (SpringDoc OpenAPI)
- 🚀 Maven

---

## 🏗️ Architecture

```plaintext
Photographer
 └── Album
      └── Photo
```

- **One-to-Many:** A Photographer has many Albums
- **One-to-Many:** An Album has many Photos
- **Unidirectional** relationships with full encapsulation via DTOs

---

## 📑 API Endpoints

All endpoints are available and documented via Swagger:

📎 Access the interactive docs at:  
`http://localhost:8080/swagger-ui.html` or `/swagger-ui/index.html`

Examples:

```
GET    /api/photographers
POST   /api/albums
DELETE /api/photos/{id}
```

---

## 🧪 Run Locally

1. **Clone the repository:**

```bash
git clone https://github.com/luccalkm/photopedia.git
cd photopedia
```

2. **Configure your PostgreSQL database in `application.properties`:**

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/photopedia
spring.datasource.username=postgres
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

3. **Run the project:**

```bash
./mvnw spring-boot:run
```

---

## 🧠 Author

**Lucca Lima**  
📧 [Contato via GitHub](https://github.com/luccalkm)  
🚀 Projeto criado como trabalho prático para a disciplina de Desenvolvimento Web em Camadas - Unilasalle

---

## ❗️ Requisições de Criação e Edição

> **Importante:**  
> Os endpoints de criação e edição de fotógrafos e álbuns **NÃO aceitam arrays de filhos (`albums`, `photos`)** no corpo da requisição.  
> Sempre use os endpoints específicos para criar e editar álbuns e fotos.  
> O GET retorna a árvore completa (photographer → albums → photos), mas o PUT/POST só recebe campos simples.

---

## 🗃️ Example Payloads

## 📸 Photographer Endpoints

### ✅ Create Photographer

```http
POST /api/photographers
Content-Type: application/json
```
```json
{
  "name": "Lucca Lima",
  "email": "lucca@email.com",
  "bio": "Landscape and portrait photographer based in Brazil.",
  "phone": "+55 51 98765-4321",
  "website": "https://luccalimafoto.com",
  "instagram": "instagram.com/luccalimafoto",
  "avatarUrl": "https://meusite.com/avatar.jpg"
}
```

### 📄 Get All Photographers

```http
GET /api/photographers
```

### 🔍 Get Photographer by ID

```http
GET /api/photographers/1
```

### ✏️ Update Photographer

```http
PUT /api/photographers/1
Content-Type: application/json
```
```json
{
  "name": "Lucca Motta",
  "email": "novo@email.com",
  "bio": "Fotógrafo premiado.",
  "phone": "+55 51 91234-5678"
}
```

### ❌ Delete Photographer

```http
DELETE /api/photographers/1
```

---

## 📀 Album Endpoints

### ✅ Create Album

```http
POST /api/albums
Content-Type: application/json
```
```json
{
  "title": "Summer Vibes",
  "photographerId": 1
}
```

### 📄 Get All Albums

```http
GET /api/albums
```

### 🔍 Get Album by ID

```http
GET /api/albums/1
```

### ✏️ Update Album

```http
PUT /api/albums/1
Content-Type: application/json
```
```json
{
  "title": "Summer Vibes Updated",
  "photographerId": 1
}
```

### ❌ Delete Album

```http
DELETE /api/albums/1
```

---

## 🖼️ Photo Endpoints

### ✅ Create Photo

```http
POST /api/photos
Content-Type: application/json
```
```json
{
  "caption": "Sunset at the beach",
  "url": "https://example.com/photo.jpg",
  "albumId": 1
}
```

### 📄 Get All Photos

```http
GET /api/photos
```

### 🔍 Get Photo by ID

```http
GET /api/photos/1
```

### ✏️ Update Photo

```http
PUT /api/photos/1
Content-Type: application/json
```
```json
{
  "caption": "Updated caption",
  "url": "https://example.com/photo_updated.jpg",
  "albumId": 1
}
```

### ❌ Delete Photo

```http
DELETE /api/photos/1
```

---

## 📝 Example Full Photographer Response (GET)

```json
{
  "id": 1,
  "name": "Lucca Lima",
  "email": "lucca@email.com",
  "bio": "Landscape and portrait photographer based in Brazil.",
  "phone": "+55 51 98765-4321",
  "albums": [
    {
      "id": 1,
      "title": "Summer Vibes",
      "photos": [
        {
          "id": 1,
          "caption": "Sunset at the beach",
          "url": "https://example.com/photo.jpg",
          "albumId": 1
        }
      ]
    }
  ]
}
```

---
