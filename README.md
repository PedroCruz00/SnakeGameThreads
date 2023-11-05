# SnakeGame

## Descripción
Este proyecto consiste en la implementación de un juego de la serpiente en Java, un videojuego clásico de estilo arcade en el que el jugador controla una serpiente que debe moverse por un tablero o pantalla, comer alimentos y evitar colisionar con su propia cola o con obstáculos del juego.

## Características del Juego

### Puntuación
Hemos implementado un hilo para gestionar la puntuación del juego. La puntuación se actualiza cada vez que la serpiente consume un alimento. La estrategia de aumento de puntuación se basa en el valor de los alimentos.

### Comida
El juego incluye un hilo para mostrar la comida en la pantalla. La comida aparece y desaparece a intervalos regulares. Si la serpiente se come la comida, inmediatamente aparece un nuevo alimento en el tablero. Si no se consume antes de que expire el tiempo, aparece un nuevo alimento en otro lugar.
### Niveles
Se han implementado 3 niveles(1,2,3) siendo 1(con el que por defecto se empieza) el de dificultad minima y 3 el de maxima dificultad. Despues de la primera partida, el jugador puede cambiar la dificultad a la que desee

### Barreras
Se ha implementado un hilo para gestionar los obstáculos del juego. Las barreras aparecen y desaparecen a intervalos de tiempo determinados. Si la serpiente choca con una barrera, el juego termina.

### Movimiento
Hemos creado un hilo para permitir que la serpiente se mueva continuamente. La dirección de la serpiente se puede cambiar mediante las teclas de flecha o las teclas personalizadas (w, s, d, a). La serpiente aparece en el lado opuesto si choca contra una pared.

## Configuración
Todas las configuraciones del juego se encuentran en un archivo de configuración en formato `.properties`.

## Menú Principal
El juego tiene un menú principal con las siguientes secciones:
- Nombre del jugador
- Iniciar juego
- Historial de puntuaciones
- Información del desarrollador

## Historial de Puntuaciones
El juego muestra un historial de puntuaciones en una tabla que incluye la fecha y hora del juego, el nombre del jugador y la puntuación.


---
Autor: [Pedro Eduardo Cruz López]
Codigo del Alumno: [202128778]
Facultad: [Ingenieria]
Escuela: [Ingenieria de Sistemas y Computación]
Año: [2023]
Curso: [Programacion III]
Universidad: [Universidad Pedagógica y Tecnológica de Colombia]
