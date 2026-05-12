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
<img width="1448" height="410" alt="Screenshot 2026-05-12 184413" src="https://github.com/user-attachments/assets/bce6e7b5-4025-4411-a4c8-a384a710301f" />


### 5.2 Хэрэглэгч бүртгэх (Register)
<img width="1443" height="760" alt="Screenshot 2026-05-12 184437" src="https://github.com/user-attachments/assets/a334a77c-539e-4043-9874-6c9a74052199" />


### 5.3 Нэвтрэх (Login) ба Token авах
<img width="1444" height="682" alt="Screenshot 2026-05-12 184425" src="https://github.com/user-attachments/assets/45e5df54-99db-433c-920e-f88fbd6bf58d" />


### 5.4 Бүтээгдэхүүн үүсгэх (POST)
<img width="1434" height="745" alt="Screenshot 2026-05-12 184453" src="https://github.com/user-attachments/assets/a051833a-9c8e-445b-bad1-130d4c3a63b3" />


### 5.5 Бүтээгдэхүүн харах (GET - Эхний амжилттай хүсэлт)
<img width="1428" height="748" alt="Screenshot 2026-05-12 184511" src="https://github.com/user-attachments/assets/94d02d1c-f2e1-4a0b-90a7-128f51c14803" />

