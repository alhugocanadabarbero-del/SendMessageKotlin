# CHANGELOG 📜

Todos los cambios notables realizados en el proyecto **SendMessage** serán documentados en este archivo.

El formato está basado en [Keep a Changelog](https://keepachangelog.com/es-ES/1.0.0/) y este proyecto se adhiere a [Semantic Versioning](https://semver.org/).

---

## [1.0] - 2026-09-28

### ✨ Añadido
* **Paso de datos completado**: Integración del envío de información entre actividades utilizando `Intent` y `Bundle` con la clave `"KEY_MESSAGE"`.
* **Recepción en `ViewMessageActivity`**: Recuperación dinámica del texto ingresado y asignación al componente `TextView` (`tvMessage`).
* **Soporte de orientación y temas**: Corrección de visibilidad de texto y márgenes responsivos para compatibilidad en orientación vertical y horizontal.
* **Documentación completa**:
  * Creación del archivo `README.md` con enlaces oficiales, decisiones de diseño e indicadores de capturas.
  * Creación del archivo `CHANGELOG.md` para el seguimiento de versiones.
  * Creación del archivo `MANUAL_USUARIO.md` redactado en 3 pasos sencillos.

### 🔧 Modificado
* Ajuste de estilos y dimensiones en `activity_send_message.xml` y `activity_view_message.xml` utilizando `layout_weight="1"` para evitar colapsos visuales.
* Ocultación de la barra de acciones predeterminada (`supportActionBar?.hide()`) para una mejor presentación de la pantalla de mensajes.

---

## [0.1] - 2026-09-25

### ✨ Añadido
* **Configuración inicial del proyecto**: Creación del proyecto Android en Kotlin con soporte para la versión de SDK objetivo.
* **Diseño de interfaces XML**:
  * Creación de `activity_send_message.xml` con `EditText` (`etMessage`) y `Button` (`btSend`).
  * Creación de `activity_view_message.xml` con `TextView` (`tvMessage`) e `ImageView` (`tvImage`).
* **Estructura base de código**:
  * Definición de las actividades `SendMessageActivity` y `ViewMessageActivity`.
  * Configuración de la clase de aplicación `SendMEssageApplication`.
  * Configuración del archivo `AndroidManifest.xml` estableciendo `SendMessageActivity` como actividad principal (*Launcher*).
