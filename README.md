# Бие Даалт 14: Integration & API Testing

Энэхүү төсөл нь F.CSM311 хичээлийн "Бие Даалт 14"-ийн хүрээнд хийгдсэн бөгөөд Postman болон Newman ашиглан API тестийг автоматжуулах зорилготой. (Бие даалт 11-ийн API-г дахин ашигласан - Хувилбар 2)

## Хэрхэн ажиллуулах вэ?

### 1. Local Server асаах
Та өөрийн Spring Boot програмаа (Lab11b) эхлээд ажиллуулах шаардлагатай.
```bash
mvn spring-boot:run
```
Эсвэл IDE (IntelliJ/Eclipse) дээрээсээ `Application` классыг run хийнэ үү. Сервер `http://localhost:8080` дээр асах ёстой.

### 2. Postman дээр тестлэх
1. Postman програмыг нээнэ.
2. `Import` товчийг дарж `postman/collection.json` болон `postman/env.dev.json` файлуудыг оруулна.
3. Баруун дээд булангаас **Dev Environment**-ийг сонгоно.
4. Collection дээр баруун товч дараад **Run collection** эсвэл хүсэлт тус бүрийг нээж **Send** дарж шалгана.

### 3. Newman CLI ашиглаж терминалаас тестлэх
Хэрвээ Newman суугаагүй бол эхлээд суулгана:
```bash
npm install -g newman newman-reporter-htmlextra
```
Дараах командаар тестийг ажиллуулна:
```bash
newman run postman/collection.json -e postman/env.dev.json --reporters cli,htmlextra --reporter-htmlextra-export reports/api.html
```
Амжилттай болсон тохиолдолд `reports/api.html` файл үүсэх бөгөөд үүнийг хөтчөөр (Browser) нээж тайланг харах боломжтой.

## Бүтэц
- `partA/` - Гарааны setup файлууд болон эхний хүсэлтийн screenshot.
- `postman/` - Postman Collection болон Environment файлууд.
- `.github/workflows/` - GitHub Actions CI/CD тохиргоо.
- `reports/` - HTML тайлан (автоматаар эсвэл гараар үүснэ).
- `REFLECTION.md` - Асуултуудын хариулт.
