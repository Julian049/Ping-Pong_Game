## JUEGO DE PING PONG MULTIJUGADOR EN JAVA

Bienvenido al juego de Ping Pong Multijugador desarrollado en Java. Este proyecto permite a los jugadores conectarse desde sus propios computadores y competir en un clásico juego de ping pong gracias a la implementación de Sockets.

## Prerrequisitos

- Java 17 o superior
- Windows 10 o superior
- Instalación previa de un entorno de desarrollo como Intellij o Visual Studio Code.


## Descripción

Este proyecto implementa la logica del clasico juego de Ping Pong utilizando el patrón de arquitectura Modelo-Vista-Presentador (MVP) en Java. Por otro lado, la parte interesante del presente proyecto se centra en la utilización de sockets, los cuales permiten la conexion de varias computadoras a un mismo servidor permitiendo que el juego pueda ser ejecutado y jugado por dos o mas jugadores cada uno conectado desde su propia maquina.

- Modelo: Gestiona los datos y la lógica del juego, incluyendo el movimiento de las raqueta y la pelota, así como la detección de colisiones.

- Vista: Proporciona la interfaz de usuario del juego, incluyendo el panel de juego y el panel de información.

- Presentador: Actúa como un intermediario entre el modelo y la vista, coordinando las actualizaciones de la interfaz de usuario y la lógica del juego.

- Connection: Gestiona las conexiones cliente-servidor y administra los puentes de conexion por medio de sockets.

- Util: Gestiona las propiedades de configuración con las que el proyecto funciona.



## Caractiristicas

- **Multijugador de Red**: Los jugadores se pueden conectar desde diferentes computadoras gracias a la implementación de sockets.

- **Interfaz Grafica**: El proyecto implementa la biblioteca gráfica *swing* de Java.

- **Patron MVP**: El proyecto implementa el patron de diseño Modelo Vista Presentador lo cual ayuda a un orden y mantenimiento eficiente de codigo.

## Valores ajustables por el usuario:

El programa cuenta con 3 archivos de configuración `ModelConfig.properties`,`TextConfig.properties` y `ViewConfig.properties` estos permiten modificar algunos parametros de funcionamiento del programa.

A continuación se listan algunas propiedades importantes de configuración.

 En `ModelConfig.properties`:

 - `port`: Guarda el puerto donde se establecerá la conexion de servidor.
 - `host`: Guarda la dirección IP del servidor.
- `racketsHeight`: Altura de la raqueta.
- `racketsWidth`: Ancho de la raqueta.
- `racketsSpeed`: Velocidad de movimiento de la raqueta.
- `ballSize`: Tamaño de la pelota.
- `ballDx`: Velocidad en el eje x de la pelota.
- `ballDy`: Velocidad en el eje y de la pelota.

























## Ejecución

***Importante:*** 
- Para la correcta ejecución del juego todas las computadoras que deseen unirse deben estar conectadas a la misma red. 
- Para configurar la IP y el puerto para la conexion debe abrir el proyecto, ingresar en la carpeta *src* y ubicar el archivo `ModelConfig.properties`, a continuación encontrara las dos siguientes propiedades listadas de primero: *port* y *host*, modifique los valores segun el puerto que desee usar y la IP del equipo que actuará como servidor. Este paso lo deben realizar todas las maquinas que deseen ingresar al juego teniendo en cuenta que los valores de IP y puerto deben ser los mismos del servidor.



- **EJECUCIÓN EN VISUAL STUDIO CODE**: 

1. **Abrir Proyecto:** Ejecute la aplicación Visual Studio Code, posteriormente ubique el menú superior y seleccione *File/Open Folder* y seleccione la ubicación donde descargó o se encuentra alojado el proyecto.

2. **Creación de archivo .json:** Ubique el menú lateral, posteriormente seleccione *Run and debug*, a continuación seleccione *create a launch.json file*. Se abrirá el archivo `.json`, ahora, borre toda la estructura contenida en el archivo y pegue la siguiente:

```
{
    "version": "0.2.0",
    "configurations": [
        {
            "type": "java",
            "name": "Client",
            "request": "launch",
            "mainClass": "Main",
            "args": ["client"]
        },
        {
            "type": "java",
            "name": "Server",
            "request": "launch",
            "mainClass": "Main",
            "args": ["server"]
        }
    ]
}
```

guarde el archivo. Esto generara un pequeño menu de selección en la parte superior izquierda para alternar entre *server* y *client*.

3. **Ejecución** 

Para ejecutar el juego, primero debe iniciar el programa en modo *servidor*, para esto asegurese que en el menú generado en el paso anterior se encuentre seleccionado "server", y ejecute.

Despues de iniciado el servidor pueden empezar a unirse los jugadores, para esto asegurese que en el menu se encuentre seleccionado "client" y ejecute (Este paso se repite segun la cantidad de jugadores que deseen unirse).

4. **Configuración del juego**

Cuando se abra la ventana para empezar el juego encontrará dos botones: *START* Y *SETTINGS*, oprima el boton *SETTINGS* y configure los botones para mover la raqueta y disparar la bola; posteriormente seleccione *BACK*, y a continuación seleccione *START* para comenzar el juego.

Nota: El juego solo iniciara cuando haya por lo menos dos jugadores, en caso de que un tercero ingrese al juego este ingresara como jugador dos, por lo que el que anteriormente era jugador dos ahora actuara como espectador.

------


*Las condiciones de ejecución pueden variar si se desea ejecutar el proyecto en un entorno de desarrollo diferente al anteriormente especificado.*






