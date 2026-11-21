# WalletView — Dashboard Financiero (AVS.03.06.01)

Aplicación Android (Kotlin) que muestra un resumen de los gastos del mes con
una **gráfica de pastel** y una **gráfica de barras**, usando la librería externa
**MPAndroidChart**.

## Librería utilizada
- **MPAndroidChart** (`com.github.PhilJay:MPAndroidChart:v3.1.0`): librería
  especializada en visualización de datos para Android.

## Integración
1. La dependencia se agrega en `app/build.gradle.kts`.
2. Para poder descargarla se agrega el repositorio **JitPack** en
   `settings.gradle.kts` (`https://jitpack.io`).

## Clases principales
- `Gasto.kt` — modelo de un gasto y los datos de ejemplo del dashboard.
- `MainActivity.kt` — arma la gráfica de pastel (gastos por categoría) y la
  gráfica de barras (gasto por mes) con MPAndroidChart.
- `res/layout/activity_main.xml` — contiene los componentes PieChart y BarChart.

## Cómo probar
1. Abre el proyecto en Android Studio.
2. Deja que Gradle sincronice las dependencias (descarga MPAndroidChart desde JitPack).
3. Ejecuta la app en un emulador o dispositivo para ver el dashboard.
