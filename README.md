# Gestión de Proyectos Académicos para Empresas

## Descripción
Este proyecto es una aplicación de escritorio desarrollada en Java utilizando **NetBeans** y **Swing** para la interfaz gráfica. Su objetivo es facilitar la gestión de proyectos académicos para empresas, permitiendo la interacción entre empresas, coordinadores y estudiantes.

## Arquitectura
El proyecto sigue un enfoque de **arquitectura en capas** y el patrón **Modelo-Vista-Controlador (MVC)**, además de aplicar los principios **SOLID** para mejorar la mantenibilidad y escalabilidad del código. Se han utilizado los patrones de diseño **Observer** y **State** para manejar la comunicación entre los componentes.

### Capas del sistema
- **Capa de Presentación:** Implementada con `javax.swing.JFrame`, proporciona la interfaz gráfica.
- **Capa de Negocio:** Contiene la lógica de aplicación y los servicios.
- **Capa de Datos:** Gestiona la persistencia con **MariaDB**, administrada mediante **HeidiSQL**.

## Requisitos
### Funcionales
1. Registro de empresas con información detallada.
2. Publicación de proyectos por parte de las empresas.
3. Evaluación y gestión de proyectos por parte del coordinador.
4. Visualización y postulación de proyectos por los estudiantes.
5. Inicio de sesión para los distintos usuarios.

### No Funcionales
- **Modificabilidad:** Estructura modular que facilita la evolución del sistema.
- **Escalabilidad:** Diseñado para soportar múltiples empresas y proyectos.
- **Desempeño:** Procesamiento eficiente de solicitudes concurrentes.

## Prototipos y Diseño
- [Prototipos de Interfaz Gráfica](https://www.figma.com/design/xtrR8g8GnDTOGKsR7NAF7U/Gesti%C3%B3n-De-Proyectos-Acad%C3%A9micos-V.2?node-id=0-1&t=B7LqdQA19FCZxWi0-1)
- [Diagrama Entidad-Relación](https://drive.google.com/file/d/1I6pi0R7gYwSiqrWNn6MVyKbS7FnPlVaR/view?usp=sharing)
- [Modelo C4] (https://drive.google.com/file/d/1I6pi0R7gYwSiqrWNn6MVyKbS7FnPlVaR/view?usp=sharing)
- [Levantamiento de requisitos](https://docs.google.com/spreadsheets/d/1hG2GuJDQpcxUXRv70Yiytuf38SZNCaiGbclfKXcRKBk/edit?usp=sharing)

## Base de Datos
- [Creación de Tablas](https://docs.google.com/document/d/1kMIIEXTbxMX_9jPuHZQbjI-xVG2hGmIFbEeRHqOTYbQ/edit?usp=sharing)
- [Inserción de Datos](https://docs.google.com/document/d/15t-HtM0J3-9bGSsDSEnZZqkk12O9IaQs3rojCnnxk8U/edit?usp=sharing)
- [Función Almacenada](https://docs.google.com/document/d/12_va4__3k_VSFBanorPgKcRr3RxaZvxdwFB6OonF2jg/edit?usp=sharing)

## Pruebas Unitarias
Se han implementado pruebas unitarias en **JUnit**, utilizando **mocks** para simular dependencias en la capa de negocio.

## Instalación y Uso
### Requisitos Previos
- **JDK 17 o superior**
- **NetBeans IDE**
- **MariaDB y HeidiSQL**

### Configuración
1. Clonar el repositorio:
   ```bash
   git clone https://github.com/Sofii141/gestionProyectosAcademicos.git
   ```
2. Configurar la base de datos en `MariaDB` utilizando los scripts SQL proporcionados.
3. Ejecutar la aplicación desde NetBeans.

### Variables de Entorno
Es necesario configurar las siguientes variables de entorno en **PowerShell**:
```powershell
setx EMAIL_USER "sofiaarango141@gmail.com"
setx EMAIL_PASS "zmswzgudkjoazdrq"
```

## Créditos
**Desarrollado por:**
- Ana Sofía Arango Yanza
- Juan Diego Gómez Garcés
- Paula Andrea Muñoz Delgado
- Cristhian Camilo Unas Ocaña
- Juan David Vela Coronado

**Profesor:** Libardo Pantoja
