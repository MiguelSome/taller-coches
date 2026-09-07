# 🚗 Sistema de Gestión de Taller Mecánico

Proyecto Java desarrollado con una arquitectura modular en capas (Model-Repository-Service), gestionado con **Maven** y con cobertura de pruebas unitarias usando **JUnit 5** y **Mockito**.

---

## 🛠️ Tecnologías Utilizadas

* ☕ **Java** (JDK 17+)
* 📦 **Apache Maven** (Gestión de dependencias y build)
* 🧪 **JUnit 5** (Pruebas unitarias)
* 🎭 **Mockito** (Simulación de dependencias / Mocks)

---

## 📐 Arquitectura del Proyecto

El sistema sigue el principio de separación de responsabilidades:

* **`model/`**: Entidades del dominio (`OrdenTaller`, `Pieza`, `Cliente`, `Empleado`, etc.).
* **`enums/`**: Enumerados de estado (`EstadoOrden`).
* **`repository/`**: Capa de acceso a datos (patrón Repository con almacenamiento en memoria).
* **`service/`**: Capa de lógica de negocio (validaciones, transiciones de estado y gestión de stock).

---

## ⚙️ Comandos Útiles (Maven)

Compilar el proyecto:
```bash
mvn clean compile
