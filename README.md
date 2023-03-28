# Proyecto Ferretería
Este proyecto de ferretería ha sido desarrollado en el lenguaje de programación Kotlin utilizando JDBC para conectarse a la base de datos "Ferretería". El objetivo de este proyecto es facilitar la gestión de la información de la ferretería, permitiendo la consulta de los artículos disponibles, los proveedores y otros datos relevantes.

## Requisitos del sistema
Para ejecutar este proyecto, es necesario tener instalado lo siguiente:

* Java Development Kit (JDK) versión 8 o superior
* Kotlin Compiler
* Base de datos MariaDB

## Instalación
1. Clonar el repositorio a través del comando:

```bash
git clone https://github.com/TuUsuario/proyecto-ferreteria.git
````
2. Configurar la conexión a la base de datos modificando el archivo src/main/kotlin/Conexion.kt con los datos de su servidor MySQL.

3. Crear una base de datos vacía en el servidor MySQL con el nombre "Ferretería".

4. Importar la base de datos ferreteria.sql a la base de datos creada en el paso anterior. Para ello, se puede utilizar el cliente de MySQL o una herramienta de gestión de bases de datos como phpMyAdmin. El archivo ferreteria.sql se encuentra en la raíz del repositorio.


## Uso

Una vez ejecutado el proyecto, se puede acceder a las distintas funcionalidades a través de la consola. Las opciones disponibles son:

* Mostrar todos los artículos disponibles en la ferretería.
* Mostrar todos los proveedores registrados en la base de datos.
* Buscar un artículo por su nombre o descripción.
* Buscar un proveedor por su nombre o teléfono.

## Contribuir

Si deseas contribuir al proyecto, puedes hacerlo a través de los siguientes pasos:

* Realizar un fork del proyecto.
* Crear una rama con los cambios que desees hacer.
* Hacer un pull request a la rama principal del proyecto.

## Créditos
Este proyecto fue desarrollado por @Badrelddin, @FranDaniels y @Loloyss .

## Licencia
Este proyecto se encuentra bajo la Licencia MIT. Puedes leer el archivo LICENSE para más información.
