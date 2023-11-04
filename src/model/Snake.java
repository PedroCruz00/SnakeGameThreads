package model;
import java.awt.Point;
import java.util.LinkedList;

public class Snake {
    private LinkedList<Point> body;
    private Direction direction;
    private int valueFood;
    private Barrier barriers;

    public Snake(int x, int y,Barrier barriers) {
        body = new LinkedList<>();
        body.add(new Point(x, y)); // Agregar la cabeza de la serpiente al inicio
        direction = Direction.UP;
        this.barriers = barriers;
        valueFood = 0;
    }

    public LinkedList<Point> getBody() {
        return body;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void move() {
        Point head = body.getFirst();
        int x = head.x;
        int y = head.y;

        if (direction == Direction.UP) {
            y--;
        } else if (direction == Direction.RIGHT) {
            x++;
        } else if (direction == Direction.DOWN) {
            y++;
        } else if (direction == Direction.LEFT) {
            x--;
        }

        // Crear una nueva cabeza en la nueva posición
        Point newHead = new Point(x, y);

        // Agregar la nueva cabeza al inicio del cuerpo
        body.addFirst(newHead);

        // Eliminar la última parte del cuerpo (la cola)
        body.removeLast();
    }

    public void grow() {
        // Obtener la posición de la última parte del cuerpo
        Point ultimaParte = body.getLast();

        // Agregar una nueva parte al final del cuerpo en la misma posición
        body.addLast(new Point(ultimaParte.x, ultimaParte.y));
    }

    public boolean collideSelf() {
        // Obtener la posición de la cabeza
        Point head = body.getFirst();

        // Verificar si la cabeza se encuentra en alguna parte del cuerpo
        for (int i = 1; i < body.size(); i++) {
            if (head.equals(body.get(i))) {
                return true; // La cabeza colisionó con alguna parte del cuerpo
            }
        }
        return false; // No hubo colisión con el cuerpo
    }
    private int adjustLimit(int coor, int maxCoor) {
        if (coor < 0) {
            return maxCoor;
        } else if (coor > maxCoor) {
            return 0;
        } else {
            return coor;
        }
    }

    public int getValueFood() {
        return valueFood;
    }

    public void setValueFood(int valueFood) {
        this.valueFood = valueFood;
    }
    public boolean collisionBarrier() {
        Point head = body.getFirst();
        return barriers.isBarrier(head.x, head.y);
    }
}
