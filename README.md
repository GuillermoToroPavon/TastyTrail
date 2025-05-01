# TastyTrail
 
TastyTrail es una aplicación que he desarrollado como proyecto para mi portfolio. Mi objetivo era conectarme a una base de datos de forma segura, limpia y ordenada usando nuevas tecnologías.

Tecnologías & Mecánicas utilizadas:

Jetpack Compose para construir la interfaz de usuario de forma declarativa y moderna.

Arquitectura limpia (Clean Architecture) con división clara entre capas: presentación, dominio y datos.

Jetpack Navigation Compose para navegación fluida entre pantallas.

Hilt para inyección de dependencias, facilitando el manejo de componentes desacoplados y testables.

Arrow para el manejo de errores y estructuras funcionales (como Either, Option, etc.), asegurando un flujo de datos robusto y predecible.

Search bar interactiva para filtrar recetas en tiempo real por nombre o ingredientes.

Consumo de API con transformación de datos mediante mapeo DTO → Domain Model.

Coil para carga eficiente de imágenes directamente en Compose.

State Management reactivo con remember y mutableStateOf.

Funcionalidades destacadas:

Listado de recetas con imagen, nombre e ingredientes principales.

Filtro en tiempo real por texto (nombre o ingredientes).

Vista de detalle con instrucciones paso a paso.

Código modular, limpio y fácilmente escalable.

