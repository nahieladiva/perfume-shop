# Modelo de Dominio - Ecommerce de Perfumes

## 1. Clases del Dominio

### 1.1 Person (Clase Abstracta)
- **Propósito**: Base para todos los usuarios del sistema.
- **Atributos**:
  - `id`: String
  - `firstName`: String
  - `lastName`: String
  - `email`: Email (Value Object)
  - `phone`: PhoneNumber (Value Object)
  - `createdAt`: LocalDateTime
  - `updatedAt`: LocalDateTime
- **Métodos**:
  - `getFullName()`: String
  - `getRole()`: Role (abstracto)

### 1.2 User (hereda de Person)
- **Propósito**: Usuario del sistema con autenticación.
- **Atributos**:
  - `username`: String
  - `passwordHash`: String
  - `status`: UserStatus (Enum)
  - `roles`: List<Role> (Enum)
  - `lastLogin`: LocalDateTime
- **Métodos**:
  - `activate()`, `deactivate()`, `suspend()`
  - `hasRole(Role role)`: boolean
  - `login()`

### 1.3 Buyer (hereda de User)
- **Propósito**: Comprador que puede tener wishlist y puntos.
- **Atributos**:
  - `points`: int
  - `memberSince`: LocalDateTime
  - `wishlist`: List<String>
  - `purchaseHistory`: List<String>
- **Métodos**:
  - `addToWishlist(String perfumeId)`
  - `removeFromWishlist(String perfumeId)`
  - `addPurchase(String orderId)`
  - `redeemPoints(int points)`: boolean

### 1.4 Seller (hereda de User)
- **Propósito**: Vendedor que administra productos y su tienda.
- **Atributos**:
  - `storeName`: String
  - `storeDescription`: String
  - `verified`: boolean
  - `products`: List<String>
  - `salesCount`: int
- **Métodos**:
  - `addProduct(String productId)`
  - `removeProduct(String productId)`
  - `recordSale()`
  - `verifyStore()`

### 1.5 Admin (hereda de User)
- **Propósito**: Administrador con permisos especiales.
- **Atributos**:
  - `adminLevel`: int
  - `permissions`: List<String>
- **Métodos**:
  - `addPermission(String permission)`
  - `hasPermission(String permission)`: boolean
  - `suspendUser(User user)`
  - `activateUser(User user)`

### 1.6 Brand
- **Propósito**: Marca de los perfumes.
- **Atributos**:
  - `id`: String
  - `name`: String
  - `description`: String
  - `yearFounded`: int
  - `country`: String
  - `website`: String
  - `logo`: String
  - `createdAt`: LocalDateTime
  - `updatedAt`: LocalDateTime
- **Métodos**:
  - `updateInfo()`
  - `getAge()`: int
- **Relaciones**: Una marca tiene muchos **Perfumes**.

### 1.7 Perfume
- **Propósito**: Producto principal del ecommerce.
- **Atributos**:
  - `id`: String
  - `name`: String
  - `brand`: Brand
  - `description`: String
  - `olfactoryNotes`: OlfactoryNotes (Value Object)
  - `fragranceFamily`: FragranceFamily (Enum)
  - `gender`: Gender (Enum)
  - `concentration`: Concentration (Enum)
  - `price`: Money (Value Object)
  - `volume`: Volume (Enum)
  - `stock`: int
  - `releaseYear`: int
  - `status`: ProductStatus (Enum)
  - `images`: List<String>
  - `averageRating`: double
  - `reviewCount`: int
  - `createdAt`: LocalDateTime
  - `updatedAt`: LocalDateTime
- **Métodos**:
  - `updateStock(int newStock)`
  - `addReview(int rating)`
  - `isAvailable()`: boolean
  - `activate()`
  - `deactivate()`
- **Relaciones**: Pertenece a una **Brand**, tiene muchas **Reviews**, aparece en muchos **OrderItems**.

### 1.8 Review
- **Propósito**: Reseña de un perfume hecha por un usuario.
- **Atributos**:
  - `id`: String
  - `user`: User (Buyer que escribe)
  - `perfume`: Perfume
  - `rating`: int (1-5)
  - `comment`: String
  - `createdAt`: LocalDateTime
  - `updatedAt`: LocalDateTime
- **Métodos**:
  - `updateReview(int rating, String comment)`
- **Relaciones**: Un **User** (Buyer) y un **Perfume**.

### 1.9 Order
- **Propósito**: Pedido de compra realizado por un usuario.
- **Atributos**:
  - `id`: String
  - `user`: User (Buyer)
  - `shippingAddress`: Address (Value Object)
  - `paymentMethod`: PaymentMethod (Enum)
  - `items`: List<OrderItem>
  - `status`: OrderStatus (Enum)
  - `createdAt`: LocalDateTime
  - `updatedAt`: LocalDateTime
- **Métodos**:
  - `addItem(Perfume perfume, int quantity)`
  - `removeItem(String perfumeId)`
  - `confirm()`
  - `process()`
  - `ship()`
  - `deliver()`
  - `cancel()`
- **Relaciones**: Un **User** (Buyer) y muchos **OrderItems**.

### 1.10 OrderItem
- **Propósito**: Línea de pedido, con perfume y cantidad.
- **Atributos**:
  - `perfume`: Perfume
  - `quantity`: int
- **Métodos**:
  - `getSubtotal()`: Money
- **Relaciones**: Un **Perfume** y una **Order**.

## 2. Herencia
