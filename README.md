
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

![image](https://github.com/JohnnMS/Conversor-de-divisas/assets/99614055/22c16a64-2b2b-4abb-bdb0-00fae0bcce10)

- Opción 4: Si el usuario no conoce de antemano los códigos de las divisas con las cuales va a operar, la aplicación le ofrece 
la opción de buscar dentro de un listado completo de divisas. Estas divisas se organizan por código y nombre en orden alfabético. 

![image](https://github.com/JohnnMS/Conversor-de-divisas/assets/99614055/546957f8-5760-40e6-bdce-b84d2b7d1955)

- Opción 1: Antes de realizar una conversión de divisa, es habitual también consultar la tasa de cambio vigente. El usuario
ingresa el código de la divisa y se le muestra el listado completo de tasas de cambio para la divisa consultada, también en
orden alfabético de izquierda a derecha dentro de la tabla.

![image](https://github.com/JohnnMS/Conversor-de-divisas/assets/99614055/408a8e9c-b6d5-412b-9826-3538dde0f880)

- Opción 2: Con los datos suficientes de código de divisas y monto, se procede a usar el módulo de conversión. Cada conversión,
sin observaciones y aprobada por el usuario, se guarda en el historial de conversiones.

![image](https://github.com/JohnnMS/Conversor-de-divisas/assets/99614055/4e8329ab-53c2-4bc9-9b48-f9b752b922fc)

![image](https://github.com/JohnnMS/Conversor-de-divisas/assets/99614055/854002b5-04f9-4392-9a86-ea34a8b71d7b)

- Opción 3: Presenta el historial completo de conversiones, donde se incluye la fecha y hora de la conversión. Permite al usuario
borrar ese historial en caso de que lo necesite. El historial se va almacenando en un archivo .txt que se crea automáticamente
dentro del menú raíz de la aplicación. Este archivo se nombra 'Historial.txt'.

![image](https://github.com/JohnnMS/Conversor-de-divisas/assets/99614055/421c4dd5-ad69-4e77-ad98-f937f9646442)

### Acceso al proyecto
La aplicación principal se aloja e la ruta .../currency_exchange/src/App/App.java

### Licencia

Este proyecto está licenciado bajo la Licencia MIT - ver el archivo [LICENSE](LICENSE) para más detalles.

## Licencias de Dependencias

Este proyecto utiliza las siguientes bibliotecas y frameworks, cada uno con sus respectivas licencias:
- **JDK de Java 17**: Disponible bajo la [Licencia Pública General de GNU, versión 2, con la excepción de la clase de biblioteca](https://openjdk.java.net/legal/gplv2+ce.html).
- **Exchangerate API**: Los desarrolladores de la API ofrecen un plan gratuito de 1500 cuotas de uso renovadas al mes. Antes de 
ejecutar el código debe obtener su API Key en el sitio web https://www.exchangerate-api.com/, para luego modificar el siguiente archivo e ingresar su 
propia API key conservando ambas comillas:

Ruta del archivo: currency_exchange/src/Metodos_Http/API_ExCH.java

![image](https://github.com/JohnnMS/Conversor-de-divisas/assets/99614055/c89cba82-d206-4c82-9659-06e01f9625a1)

### Demo

https://youtu.be/Uf2auhgMP3Q

### Autor
Johnn Montañez Sarmiento
