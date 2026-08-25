# Value Objects - Ecommerce de Perfumes

## 1. ¿Qué son los Value Objects?
Los Value Objects son objetos inmutables que encapsulan un valor y sus reglas de validación. No tienen identidad propia (se identifican por su valor).

## 2. Lista de Value Objects

### Email
- **Atributos**: `value` (String)
- **Validación**: Formato `nombre@dominio.com` (regex)
- **Métodos**: `getValue()`, `toString()`

```java
public class Email {
    private final String value;

    public Email(String value) {
        if (!isValid(value)) {
            throw new IllegalArgumentException("Email inválido: " + value);
        }
        this.value = value;
    }

    private boolean isValid(String email) {
        return email != null && email.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$");
    }

    public String getValue() { return value; }
}