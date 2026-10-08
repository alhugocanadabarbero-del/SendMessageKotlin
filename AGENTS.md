# AGENTS.md

Proyecto Android académico en Kotlin con un único módulo (`:app`). Documentación, CHANGELOG y comentarios en **español**.

## Comandos (Windows, PowerShell 5.1)

- Compilar: `.\gradlew.bat assembleDebug` → APK en `app/build/outputs/apk/debug/` (verificado). Si PowerShell falla con "no es una aplicación válida para esta plataforma", usa `cmd /c "gradlew.bat assembleDebug"`.
- Tests unitarios: `.\gradlew.bat testDebugUnitTest` (verificado, pasa).
- Tests instrumentados: `.\gradlew.bat connectedAndroidTest` (requiere dispositivo/emulador conectado).
- Documentación KDoc: `.\gradlew.bat dokkaHtml` → escribe en `documentación/` (con acento, definido en `app/build.gradle.kts`), **no** en `documentation/`.
- Validar el README tras modificarlo: `python .opencode/skills/personalice-docs-generator/scripts/validate_readme.py README.md` (requiere Python 3; si `python` abre la Microsoft Store: `winget install Python.Python.3.12`).
- PowerShell 5.1 no admite `&&`; encadenar con `; if ($?) { ... }`.

## Gotchas de build

- Gradle 9.5.0, AGP 9.3.2, Kotlin 2.1.0. Daemon JVM 21 auto-descargado (foojay, `gradle/gradle-daemon-jvm.properties`); CI usa Java 17; bytecode target Java 11.
- `gradle.properties` fija `android.builtInKotlin=false`, `android.newDsl=false` y configuration-cache activo.
- `compileSdk` usa la DSL nueva de AGP 9 en `app/build.gradle.kts` (`version = release(37) { minorApiLevel = 1 }`), no `compileSdk = 37`.
- Todas las versiones de dependencias viven en `gradle/libs.versions.toml`.
- El plugin `kotlin-parcelize` ya está aplicado: `@Parcelize` funciona directamente.

## Flujo real de la app

- Launcher: `SendMessageActivity` (única actividad `exported="true"` en `AndroidManifest.xml`).
- Envía un `Message` (`model/Message.kt` + `model/Person.kt`, `@Parcelize`) dentro del `Bundle` con la clave `"KEY_MESSAGE"` a `ViewMessageActivity` (no exportada), que lo lee con `getParcelable` API 33+ y fallback deprecado.
- `ViewBinding` está habilitado en el build, pero las actividades usan `findViewById`: seguir ese estilo existente.
- El árbol de estructura del `README.md` **no incluye el paquete `model/`**; manda el código, no el README.

## CI / deploy

- Push a `main` → `.github/workflows/desplegar-dokka.yml` ejecuta `dokkaHtml` y publica en GitHub Pages la carpeta `documentation/` (commiteada), mientras `dokkaHtml` escribe en `documentación/` (acento). Ambas carpetas están en el repo: el build fresco **no** es lo que se despliega.

## Documentos y skills

- Formato de documentación: `CHANGELOG.md` sigue Keep a Changelog + SemVer (mantener formato); `MANUAL_USUARIO.md` es el manual del usuario.
- Imágenes: capturas de la app en `Recursos/`. El README referencia `docs/images/logcat_evidence.png` y `docs/images/data_data_connection.png` que **aún no existen** (en `docs/images/` solo hay 3 ficheros); no inventar rutas.
- Skills de OpenCode en `.opencode/skills/`: `personalice-docs-generator` (KDoc/README + script de validación) y `generar-fichero-license`.
