# API TaskMaster (Spring Boot)
---

**Proyecto desarrollado por:**
* **J.A. Vega Reyes** (autor de este repositorio)

Este proyecto fue desarrollado para la **Unidad de Aprendizaje "Desarrollo de Aplicaciones Móviles"**, en la **Escuela Superior de Cómputo** del **Instituto Politécnico Nacional** en la Unidad Zacatenco, Ciudad de México.

---
## 💡 Importante
### Requisitos de Ejecución y Entorno
>[!IMPORTANT]
El proyecto **API TaskMaster** (el backend) se ha implementado, probado y ejecutado con:
* **IDE:** **IntelliJ IDEA** (o **Eclipse/STS**)
* **SDK:** **Java JDK** [Indicar la versión, ej: 17 o superior]
* **Base de Datos:** [Indica tu BD, ej: MySQL, PostgreSQL, H2]

Es importante considerar estas herramientas para su correcta ejecución y conexión con el frontend (TaskMate App).

### Repositorio Oficial
Si quieres visualizar directamente el código fuente del backend, aquí te dejo un link al repositorio oficial:

(https://github.com/AngelChetosmen/API_TaskMaster_SpringBoot.git)

>[!CAUTION]
---Es posible que la API no se ejecute correctamente si las variables de entorno (como la conexión a la base de datos en `application.properties`) no están configuradas. Si por alguna razón no puedes ejecutar la API, contáctame para poder ayudarte a resolverlo.

## 📝 Descripción
>[! INFO]
El proyecto **API TaskMaster** es una **API RESTful** desarrollada en **Java** utilizando el framework **Spring Boot**.

Esta API sirve como el **backend** para la aplicación móvil "TaskMate App". Se encarga de toda la lógica de negocio, gestión de datos y persistencia, exponiendo *endpoints* para que la aplicación cliente (Android) pueda consumir y manipular la información de las tareas.

---
## 📂 Estructura del Proyecto
El proyecto está organizado siguiendo la arquitectura estándar de Spring Boot:

### Código Fuente (`src/main/java/com/example/api_taskmaster/`):
* **`ApiTaskmasterApplication.java`**: Clase principal que inicia la aplicación Spring.
* **`controller/`**: Contiene los controladores REST (ej. `TaskController.java`) que manejan las peticiones HTTP.
* **`model/` (o `entity/`)**: Contiene las clases de entidad (POJOs) que mapean a la base de datos (ej. `Task.java`).
* **`repository/`**: Contiene las interfaces de Spring Data JPA (ej. `TaskRepository.java`) para interactuar con la BD.
* **`service/`**: Contiene la lógica de negocio (ej. `TaskService.java`).

### Recursos (`src/main/resources/`):
* **`application.properties` (o `.yml`)**: Archivo de configuración principal (conexión a BD, puerto del servidor, etc.).
* `static/`: Recursos estáticos (si aplica).
* `templates/`: Plantillas (si aplica, aunque para una API pura puede estar vacío).

### Configuración de Build:
* **`pom.xml`** (o `build.gradle`): Archivo de configuración de Maven (o Gradle) que gestiona las dependencias del proyecto (Spring Web, Spring Data JPA, Driver de BD, etc.).

---
## ✨ Funcionalidades Principales (Endpoints)
La API expone los siguientes *endpoints* para la gestión de tareas (CRUD):

### Gestión de Tareas (CRUD):
* **`GET /api/tasks`**: Obtiene la lista completa de todas las tareas.
* **`GET /api/tasks/{id}`**: Obtiene una tarea específica por su ID.
* **`POST /api/tasks`**: Crea una nueva tarea (recibe un JSON con los datos de la tarea).
* **`PUT /api/tasks/{id}`**: Actualiza una tarea existente por su ID.
* **`DELETE /api/tasks/{id}`**: Elimina una tarea por su ID.

*(Nota: Ajusta las rutas `/api/tasks` si usaste un prefijo diferente)*

---
## 🛠 Requisitos
* **IDE de Java**: IntelliJ IDEA, Eclipse (con plugin STS) o VS Code (con extensiones de Java/Spring).
* **JDK**: [Indica tu versión, ej: JDK 11, 17 o superior].
* **Maven** o **Gradle**: Para la gestión de dependencias (generalmente incluido en el IDE).
* **Base de Datos**: Un servidor de [MySQL/PostgreSQL] o usar la base de datos en memoria H2.
* **Postman** o **Insomnia**: (Opcional) Para probar los endpoints de la API.

---
## ⚙️ Instalación y Ejecución
1.  **Clonar el Repositorio**:
    ```bash
    git clone [https://github.com/AngelChetosmen/API_TaskMaster_SpringBoot.git](https://github.com/AngelChetosmen/API_TaskMaster_SpringBoot.git)
    ```
2.  **Abrir en tu IDE**:
    * Selecciona `File > Open` (o `Import Project`) y abre la carpeta del proyecto clonado (asegúrate de que lo reconozca como un proyecto Maven o Gradle).
3.  **Configurar Base de Datos**:
    * Abre el archivo `src/main/resources/application.properties`.
    * Modifica las líneas `spring.datasource.url`, `spring.datasource.username` y `spring.datasource.password` con los datos de tu servidor de base de datos local.
4.  **Ejecutar la Aplicación**:
    * Busca la clase `ApiTaskmasterApplication.java` y ejecútala como una Aplicación Java.
    * O bien, usa la terminal:
      ```bash
      # Si usas Maven
      ./mvnw spring-boot:run
      
      # Si usas Gradle
      ./gradlew bootRun
      ```
5.  **Verificar**: La API debería estar corriendo en `http://localhost:8080` (o el puerto que hayas configurado).

---
## 📄 Licencia y Aviso Legal
Este proyecto está licenciado bajo los términos de la **licencia EUVA**. Consulta el repositorio oficial del autor original J.A. Vega Reyes `LICENSE` para más detalles.

>[!WARNING]
**Aclaración sobre el Origen:**
* Este proyecto fue desarrollado por el autor mencionado (J.A. Vega Reyes).
* El objetivo de este repositorio es contar con un espacio para la **consulta pública** del proyecto. Personalmente, yo, J.A. Vega Reyes, no tengo inconveniente con el análisis, visualización e incluso mejoras en la aplicación.
* No existe la garantía de que el **Instituto Politécnico Nacional** y la **Escuela Superior de Cómputo** puedan dar su consentimiento respecto a una mejora o modificación.
* Por lo tanto, se recomienda **citar el origen del proyecto** para evitar posibles plagios o problemas futuros.

---
¡Gracias por leer este README como parte de la documentacion de este pruyecto. Disfruta de analizar este proyecto!
Saludos.      :D
