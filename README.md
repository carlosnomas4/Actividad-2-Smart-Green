# Smart Green - Control de Jardines Inteligente

## Práctica para Programación de Vanguardia

Este proyecto es una aplicación Java desarrollada como práctica para la materia Programación de Vanguardia de la facultad de la ciudad de Buenos Aires. 
La aplicación `Smart Green` tiene como objetivo simular el control inteligente de jardines, permitiendo monitorear la temperatura, accionar el riego del pasto 
y alertar al usuario sobre temperaturas elevadas.

## Tecnologías Utilizadas

* **Java:** Lenguaje de programación principal.
* **Maven:** Herramienta de gestión de proyectos para la construcción, dependencias y empaquetado de la aplicación.
* **commons-cli:** Librería de Apache para el manejo de argumentos de línea de comandos.
* **Log4j 2:** Framework de logging de Apache para registrar el comportamiento y los eventos de la aplicación.
* **IntelliJ IDEA Community Edition:** IDE utilizado para el desarrollo de la aplicación.

## Estructura del Proyecto

El proyecto sigue la estructura estándar de un proyecto Maven:

Actividad2/
├── src/
│   ├── main/
│       ├── java/
│       │   └── ar/
│       │       └── edu/
│       │           └── udeci/
│       │               └── pv/
│       │                   └── SmartGreenApp.java
│       └── resources/
│          └── log4j2.xml
│   
├── pom.xml
└── README.md


* **`src/main/java/ar/edu/udeci/pv/smart_green/SmartGreenApp.java`:** Contiene el código fuente principal de la aplicación.
* **`src/main/resources/log4j2.xml`:** Archivo de configuración para el framework de logging Log4j 2.
* **`pom.xml`:** Archivo de configuración de Maven que define las dependencias del proyecto y la forma de construirlo.
* **`README.md`:** Este archivo, que proporciona información general sobre el proyecto.

## Interacción y Uso de la Aplicación

### Requisitos Previos

* **Java Development Kit (JDK):** Asegúrate de tener instalado un JDK compatible (se recomienda la versión utilizada durante el desarrollo,
 especificada en el `<properties>` del `pom.xml`).
* **Maven:** Maven debe estar instalado y configurado en tu sistema para construir el proyecto.

### Construcción del Proyecto

1.  Abre una terminal o símbolo del sistema y navega hasta la raíz del directorio del proyecto (`Actividad2`).
2.  Ejecuta el siguiente comando de Maven para compilar el proyecto y generar el archivo JAR:

    ```bash
    mvn clean package
    ```

3.  Una vez que la construcción sea exitosa, el archivo JAR ejecutable (`Actividad2-1.0-SNAPSHOT.jar`) se encontrará en el directorio `target/`.

### Ejecución de la Aplicación

1.  Navega hasta el directorio `target/` dentro del directorio del proyecto.
2.  Ejecuta la aplicación utilizando el comando `java -jar`:

    ```bash
    java -jar Actividad2-1.0-SNAPSHOT.jar [opciones]
    ```

### Opciones de Línea de Comandos (Implementadas con `commons-cli`)

La aplicación permite configurar la temperatura máxima para la alerta a través de un argumento de línea de comandos:

* `-t <temperatura>` o `--max-temp <temperatura>`: Establece la temperatura máxima en grados Celsius (°C) 
a partir de la cual se activará una alerta de alta temperatura. Si no se proporciona esta opción, se utiliza un valor por defecto de 30 °C.

**Ejemplos de Ejecución:**

* Ejecutar la aplicación con la temperatura máxima por defecto:

    ```bash
    java -jar Actividad2-1.0-SNAPSHOT.jar
    ```

* Ejecutar la aplicación estableciendo la temperatura máxima en 35 °C:

    ```bash
    java -jar Actividad2-1.0-SNAPSHOT.jar -t 35
    ```

### Salida de la Aplicación

Al ejecutarse, la aplicación mostrará mensajes en la consola indicando:

* La temperatura máxima configurada.
* La temperatura actual simulada del jardín.
* Si se ha detectado una alerta de alta temperatura.
* Si el riego se ha activado (simulado basado en la temperatura actual).

Además, la aplicación utiliza **Log4j 2** para registrar información detallada sobre su ejecución, incluyendo el análisis de los 
argumentos de línea de comandos, la temperatura actual, las decisiones sobre alertas y el riego. 
Estos logs se mostrarán en la consola según la configuración definida en `src/main/resources/log4j2.xml`.

## Desarrollo de la Aplicación

El desarrollo de esta aplicación se realizó utilizando IntelliJ IDEA Community Edition como entorno de desarrollo integrado.
Maven se utilizó para gestionar las dependencias (principalmente `commons-cli` y `log4j-api`/`log4j-core`) 
y para facilitar la construcción y el empaquetado de la aplicación en un archivo JAR ejecutable.

* **Manejo de Argumentos (`commons-cli`):** La librería `commons-cli` se integró para permitir que el usuario configure
 parámetros de la aplicación a través de la línea de comandos, específicamente la temperatura máxima para las alertas. 
 Esto hace que la aplicación sea más flexible y configurable sin necesidad de modificar el código fuente.

* **Registro de Eventos (`Log4j 2`):** Se implementó `Log4j 2` para llevar un registro detallado de la actividad de la aplicación. 
Esto es fundamental para el monitoreo, la depuración y la comprensión del comportamiento del sistema. 
Los logs incluyen información sobre la configuración, la simulación de la temperatura y las acciones tomadas por la aplicación (alertas, riego).

La aplicación simula la lectura de la temperatura del jardín generando un valor aleatorio dentro de un rango predefinido.
Basándose en esta temperatura simulada y la temperatura máxima configurada, se decide si se debe emitir una alerta.
De manera similar, el riego se activa de forma simulada si la temperatura actual supera un umbral.

Este proyecto demuestra el uso de herramientas y librerías estándar en el desarrollo de aplicaciones Java modernas, enfocándose en la gestión de dependencias, la configuración a través de la línea de comandos y el registro robusto de la actividad de la aplicación.

## Posibles Extensiones Futuras

* Implementar la lectura de temperatura desde un sensor real (requeriría hardware específico y librerías para interactuar con él).
* Integrar un sistema de notificación real (por ejemplo, envío de correos electrónicos o mensajes SMS).
* Añadir lógica más sofisticada para el control del riego, considerando la humedad del suelo, el clima y horarios.
* Persistir datos históricos de temperatura y riego.
* Desarrollar una interfaz gráfica de usuario para la aplicación.
