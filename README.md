
# CHALLENGE 2: Conversor de divisas.
https://github.com/JohnnMS/Conversor-de-divisas.git

Versión final -1.0- del segundo challenge desarrollado en el proceso de formación con Alura LATAM & Oracle Next Education.

## DESCRIPCIÓN.
El Conversor de Divisas es una herramienta diseñada para facilitar la conversión entre diferentes monedas de forma rápida 
y sencilla. Desarrollado como parte del proceso de formación en Alura & Oracle Next Education, este proyecto busca aplicar
los conocimientos adquiridos en el ámbito de la programación y formación como Backend.

El Conversor de Divisas se desarrolló en el lenguaje de programación Java. Adicionalmente, la aplicación realiza consultas
y hace consumo de datos de una API llamada "ExchangeRate-API", la cual fue lanzada en el año 2010. Esta API recopila datos
de múltiples bancos centrales y distintas organizaciones comerciales, lo que le permite ofrecer 161 tasas de conversión en
diversas divisas. Esto la hace apropiada para complementar aplicaciones para SaaS, dashboards y comercio electrónico.

Para mayor información visite, https://www.exchangerate-api.com/

### Requisitos establecidos para el desarrollo del proyecto.
- la aplicación debe contar con una interfaz de usuario.
- la aplicación debe contar con el consumo o uso de una API.
- Debe existir un análisis de la respuesta JSON de la API para manipular y mostrar apropiadamente los datos al usuario.

Opcionales incluidos dentro de la aplicación:
- Historial de Conversiones: Capacidad de rastrear y mostrar el historial de las últimas conversiones realizadas.
- El usuario tendrá la opción de convertir en distintos tipos de divisas.
- Registros con Marca de Tiempo: Mostrar fecha y hora, incluyendo información sobre qué divisas se convirtieron y el monto.

## ¿CÓMO EMPEZAR?

### Componentes.
Toda la interacción con el usuario se realiza a través de una interfaz textual mediante la consola. La estructura incluye
un menú con cuatro opciones iniciales dentro de un bucle de repetición, lo que permite al usuario seleccionar opciones 
numéricas y proporcionar datos para la consulta y el cálculo de conversión. Cada opción en el menú principal lleva a un 
módulo distinto, donde se ejecuta cada componente del código para suministrar la información al usuario. La aplicación 
ofrece control de errores, control del tipo de dato ingresado e interfaz detallada con colores distintivos.

### Modo de uso y diseños.

- Menú principal:

![MenuPpal](https://github.com/JohnnMS/Conversor-de-divisas/assets/99614055/e9f9ba85-0b03-4775-b8ed-576281e2dfa1)

- Opción 4: Si el usuario no conoce de antemano los códigos de las divisas con las cuales va a operar, la aplicación le ofrece 
la opción de buscar dentro de un listado completo de divisas. Estas divisas se organizan por código y nombre en orden alfabético. 

![Opción 4, Consulta Códigos de divisas](https://github.com/JohnnMS/Conversor-de-divisas/assets/99614055/ed6c039f-6c06-49cf-b932-c112e755b950)

- Opción 1: Antes de realizar una conversión de divisa, es habitual también consultar la tasa de cambio vigente. El usuario
ingresa el código de la divisa y se le muestra el listado completo de tasas de cambio para la divisa consultada, también en
orden alfabético de izquierda a derecha dentro de la tabla.

![Opción 1, Consulta Tasas de cambio](https://github.com/JohnnMS/Conversor-de-divisas/assets/99614055/99be46b6-2104-42ae-8058-6aac91f1bbaa)

- Opción 2: Con los datos suficientes de código de divisas y monto, se procede a usar el módulo de conversión. Cada conversión,
sin observaciones y aprobada por el usuario, se guarda en el historial de conversiones.

![Opción 2, Conversiones](https://github.com/JohnnMS/Conversor-de-divisas/assets/99614055/36c25693-50b4-4d31-b879-6c35b077e5e3)

![Opción 2, Conversiones resultados](https://github.com/JohnnMS/Conversor-de-divisas/assets/99614055/4f2d02b0-b9fa-4c36-a57d-1b5183bae69a)

- Opción 3: Presenta el historial completo de conversiones, donde se incluye la fecha y hora de la conversión. Permite al usuario
borrar ese historial en caso de que lo necesite. El historial se va almacenando en un archivo .txt que se crea automáticamente
dentro del menú raíz de la aplicación. Este archivo se nombra 'Historial.txt'.

![Opción 3, historial de conversiones](https://github.com/JohnnMS/Conversor-de-divisas/assets/99614055/e1e43072-1dde-4916-93a7-a0f2b1f6764d)

### Acceso al proyecto
La aplicación principal se aloja e la ruta .../currency_exchange/src/App/App.java

### Licencia
La aplicación no requiere licencias para su uso. Los desarrolladores de la API ofrecen un plan gratuito de 1500 cuotas de uso renovadas al mes.

### Recurso adicional
Si tiene dudas en cuanto al funcionamiento de la aplicación, dentro del repositorio se incluye un video demostrativo con el uso y pruebas de funcionamiento.

### Autor
Johnn Montañez Sarmiento
