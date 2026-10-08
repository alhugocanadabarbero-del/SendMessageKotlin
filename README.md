# SendMessage - Aplicación Android en Kotlin para enviar mensajes con Intent y Bundle

**SendMessage** es una aplicación de Android desarrollada en **Kotlin** que permite redactar un mensaje de texto en una pantalla principal (`SendMessageActivity`) y transmitirlo a una segunda pantalla (`ViewMessageActivity`) utilizando el mecanismo de comunicación de Android mediante `Intent` y `Bundle`.

---

## ✨ Características

* Redacción de un mensaje de texto en la pantalla principal (`SendMessageActivity`).
* Envío del mensaje a la segunda pantalla mediante `Intent` y `Bundle`.
* Visualización del mensaje recibido en `ViewMessageActivity`.
* Interfaz declarativa en XML con `LinearLayout`, `layout_weight` y márgenes de 30dp.
* Diseño responsivo para distintos tamaños y orientaciones de pantalla.
* Soporte de `ViewBinding` para acceso tipado a las vistas.
* Paquete: `com.example.sendmessage` (minSdk 24, targetSdk 36).

---

## 📌 Índice
1. [Características](#-características)
2. [Arquitectura y Estructura del Proyecto](#-arquitectura-y-estructura-del-proyecto)
3. [Demostración de la Aplicación en Ejecución](#-demostración-de-la-aplicación-en-ejecución)
4. [Proceso de Depuración y Evidencias de Logcat](#-proceso-de-depuración-y-evidencias-de-logcat)
5. [Conexión al directorio `/data/data/`](#-conexión-al-directorio-datadata)
6. [Comenzando](#-comenzando)
7. [Enlaces a la Documentación Oficial de Android](#-enlaces-a-la-documentación-oficial-de-android)

---

## 🏗️ Arquitectura y Estructura del Proyecto

El proyecto sigue la arquitectura recomendada por Google para aplicaciones Android sencillas basadas en **Actividades**:

```text
SendMessage/
├── app/
│   ├── src/main/
│   │   ├── java/com/example/sendmessage/
│   │   │   ├── SendMEssageApplication.kt  # Clase de aplicación principal
│   │   │   ├── SendMessageActivity.kt      # Pantalla principal para escribir mensaje
│   │   │   └── ViewMessageActivity.kt      # Pantalla secundaria para visualizar mensaje
│   │   ├── res/
│   │   │   ├── layout/
│   │   │   │   ├── activity_send_message.xml # Layout XML de la pantalla de envío
│   │   │   │   └── activity_view_message.xml # Layout XML de la pantalla de visualización
│   │   │   ├── values/                      # Colores, cadenas y temas
│   │   │   └── drawable/                    # Iconos y recursos gráficos
│   │   └── AndroidManifest.xml              # Declaración de componentes y launcher
└── docs/images/                             # Capturas de pantalla e imágenes de evidencias
```

### Decisiones de Diseño:
* **Separación de responsabilidades**: La interfaz está definida de forma declarativa en archivos XML (`activity_send_message.xml` y `activity_view_message.xml`), mientras que la lógica de negocio y eventos se gestionan en las clases Kotlin correspondientes.
* **Transferencia de Datos mediante `Intent` y `Bundle`**: Se utiliza un `Bundle` explícito cargado en un `Intent` para transferir la cadena de texto ingresada por el usuario en `etMessage` hacia la actividad receptora `ViewMessageActivity`.
* **Diseño Adaptativo y Responsivo**: Uso de `LinearLayout` con pesos (`layout_weight="1"`) y márgenes homogéneos (`30dp`) para asegurar que la interfaz se escale adecuadamente en diferentes tamaños de pantalla y orientaciones (Vertical y Horizontal).

### Stack Tecnológico

| Categoría | Tecnología |
| :--- | :--- |
| Lenguaje | Kotlin (JVM 11) |
| UI | XML Views, `LinearLayout`, Material Components |
| Binding | ViewBinding |
| Comunicación entre pantallas | `Intent` y `Bundle` |
| Dependencias | AppCompat, Core KTX, Activity KTX, ConstraintLayout, Navigation |
| Pruebas | JUnit, Espresso |
| Documentación | Dokka (HTML en `documentación/`) |
| SDK | compileSdk 37.1, minSdk 24, targetSdk 36 |

---

## 📸 Demostración de la Aplicación en Ejecución

A continuación se presentan las capturas reales de la aplicación en ejecución en el dispositivo/emulador:

| Pantalla Principal (`SendMessageActivity`) | Pantalla de Visualización (`ViewMessageActivity`) |
| :---: | :---: |
| ![SendMessageActivity](Recursos/sendmessageimagen.png) | ![ViewMessageActivity](Recursos/viewmessageimagen.png) |

### 1. Pantalla de Envío (`SendMessageActivity`)
![SendMessageActivity](Recursos/sendmessageimagen.png)

* Muestra el título decorativo *"Aplicación para enviar mensajes"*, el campo de texto ingresado y el botón inferior para transmitir el mensaje.

---

### 2. Pantalla de Visualización (`ViewMessageActivity`)
![ViewMessageActivity](Recursos/viewmessageimagen.png)

* Muestra la recepción correcta del mensaje enviado desde la primera pantalla.

---

## 🐞 Proceso de Depuración y Evidencias de Logcat

Durante el desarrollo de la aplicación se utilizó la herramienta **Logcat** de Android Studio para rastrear el ciclo de vida de las actividades, verificar el filtrado por paquete (`package:mine` o `package:com.example.sendmessage`) en un dispositivo `Nothing A063 (Android 15, API 35)` y comprobar la ejecución en tiempo real de la aplicación.

### Evidencia de depuración en Logcat:
![Evidencia Logcat Android Studio](docs/images/logcat_evidence.png)

* En la captura de Logcat se observa el registro activo de eventos del proceso `com.example.sendmessage` (PID 28251) capturando la interacción con el sistema en tiempo real.

---

## 📂 Conexión al directorio `/data/data/`

En los dispositivos Android (emuladores y dispositivos con acceso root o en modo de depuración), cada aplicación instalada dispone de un directorio de almacenamiento privado ubicado en la ruta interna `/data/data/<package_name>/`.

Ruta privada de la aplicación:
```text
/data/data/com.example.sendmessage/
```

### Evidencia del Device File Explorer en `/data/data/`:
![Conexión data/data](docs/images/data_data_connection.png)

---

## 🚀 Comenzando

### Requisitos previos
* Android Studio (versión Ladybug o superior).
* JDK 11 o superior.
* SDK de Android con `minSdk 24` disponible.

### Instalación y ejecución
1. Clona el repositorio: `git clone <url-del-repositorio>`.
2. Abre la carpeta del proyecto en Android Studio.
3. Sincroniza el proyecto con Gradle ("Sync Now").
4. Selecciona un dispositivo o emulador y pulsa **Run ▶** (`app`).

---

## 🔗 Enlaces a la Documentación Oficial de Android

Para la construcción de este proyecto se consultaron los siguientes recursos oficiales de **Android Developer**:

* [Intent - Android Developers](https://developer.android.com/reference/android/content/Intent)
* [Bundle - Android Developers](https://developer.android.com/reference/android/os/Bundle)
* [AppCompatActivity - Android Developers](https://developer.android.com/reference/androidx/appcompat/app/AppCompatActivity)
* [LinearLayout - Android Developers](https://developer.android.com/reference/android/widget/LinearLayout)
* [EditText - Android Developers](https://developer.android.com/reference/android/widget/EditText)
* [TextView - Android Developers](https://developer.android.com/reference/android/widget/TextView)
* [Guía de inicio de Android (Build your first app)](https://developer.android.com/training/basics/firstapp)

---

## 📄 Licencia y Contacto

**Autor:** Alumno / Desarrollador  
**Versión del Proyecto:** 1.0  
**Licencia:** Este proyecto se utiliza con fines académicos.
