# Arquitectura del Sistema - Ecommerce de Perfumes

## 1. Patrón de Arquitectura
- **Domain-Driven Design (DDD)**
- **Arquitectura por Capas**

## 2. Capas del Sistema

### Capa de Dominio (Domain Layer)
- **Ubicación**: `src/main/java/com/nahiely/perfume_shop/domain/`
- **Contenido**:
  - **Entidades**: User, Buyer, Seller, Admin, Brand, Perfume, Review, Order, OrderItem
  - **Value Objects**: Email, PhoneNumber, Address, Money, OlfactoryNotes, Concentration
  - **Enums**: Role, UserStatus, ProductStatus, OrderStatus, PaymentMethod, FragranceFamily, Gender, Volume
  - **Clase Abstracta**: Person

### Capa de Aplicación (Application Layer)
- **Ubicación**: `src/main/java/com/nahiely/perfume_shop/application/` (por implementar)
- **Contenido**: Servicios de aplicación, casos de uso, DTOs

### Capa de Infraestructura (Infrastructure Layer)
- **Ubicación**: `src/main/java/com/nahiely/perfume_shop/infrastructure/` (por implementar)
- **Contenido**: Repositorios, servicios externos, persistencia

### Capa de Presentación (Presentation Layer)
- **Ubicación**: `src/main/java/com/nahiely/perfume_shop/controllers/` (por implementar)
- **Contenido**: Controladores REST, manejo de solicitudes HTTP

## 3. Tecnologías Utilizadas
- **Lenguaje**: Java 17
- **Framework**: Spring Boot 3.4.0
- **Gestor de Dependencias**: Gradle
- **Persistencia**: Spring Data JPA (por implementar)
- **Base de Datos**: H2 Database (por implementar)
- **API**: Spring Web (por implementar)

## 4. Principios de Diseño Aplicados
- **Single Responsibility**: Cada clase tiene una sola responsabilidad
- **Encapsulamiento**: Los atributos son privados con getters
- **Inmutabilidad**: Los Value Objects son inmutables (final)
- **Validación**: Los Value Objects validan su estado en el constructor
- **Herencia**: `Person` es abstracta; `User` extiende `Person`; `Buyer`, `Seller`, `Admin` extienden `User`

## 5. Diagrama de Paquetes