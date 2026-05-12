# А хэсэг: SETUP

## 1. Сонгосон API
**Хувилбар 2:** Бие даалт 11-д хэрэгжүүлсэн өөрийн Spring Boot REST API (Auth болон Product endpoints).

## 2. API Brief (Товч танилцуулга)
Энэхүү API нь хэрэглэгч бүртгэх (Register), нэвтрэх (Login) болон бүтээгдэхүүний мэдээллийг удирдах (CRUD) үйлдлүүдийг хангадаг.
- **Хэрэглэгчийн үйлдэл:** `/api/register`, `/api/login`
- **Бүтээгдэхүүний үйлдэл:** `/api/products` (GET, POST, PUT, DELETE)

## 3. Base URL
- **Local (dev):** `http://localhost:8080`
- **CI (GitHub Actions):** `http://localhost:8080`

## 4. Auth
Энэхүү API нь Spring Security ашиглан хэрэглэгчийн нэвтрэлтийг шалгадаг бөгөөд одоо `/api/login` руу username, password явуулахад амжилттай бол `200 OK` болон **JWT token** (`{ "token": "..." }`) буцаадаг болсон. Алдаатай бол `401 Unauthorized` буцаана.

## 5. Постман дээрх шалгалтууд (Screenshots)

### 5.1 Variables тохиргоо
![Variables](./variables.png)

### 5.2 Хэрэглэгч бүртгэх (Register)
![Register](./register.png)

### 5.3 Нэвтрэх (Login) ба Token авах
![Login](./login.png)

### 5.4 Бүтээгдэхүүн үүсгэх (POST)
![Create Product](./create_product.png)

### 5.5 Бүтээгдэхүүн харах (GET - Эхний амжилттай хүсэлт)
![Screenshot](./screenshot.png)

