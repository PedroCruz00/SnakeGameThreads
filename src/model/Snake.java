package model;
import java.awt.Point;
import java.util.LinkedList;

public class Snake {
    private LinkedList<Point> body;
    private Direction direction;
    private int valueFood;
    private Food food;
    private Barrier barriers;

    public Snake(int x, int y,Food food,Barrier barriers) {
        body = new LinkedList<>();
        body.add(new Point(x, y));
        direction = Direction.UP;
        this.food = food;
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

        Point newHead = new Point(x, y);

        body.addFirst(newHead);

        body.removeLast();
    }

    public void grow() {
        Point ultimaParte = body.getLast();

        body.addLast(new Point(ultimaParte.x, ultimaParte.y));
    }

    public boolean collideSelf() {
        Point head = body.getFirst();

        for (int i = 1; i < body.size(); i++) {
            if (head.equals(body.get(i))) {
                return true;
            }
        }
        return false;
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
    public boolean eat() {
        Point cabeza = body.getFirst();
        Point positionFood = new Point(food.getX(),food.getY());
        if (cabeza.equals(positionFood)) {
            return true;
        }
        return false;
    }
    public boolean collideFood() {
        for (Point p : body) {
            if (p.x == food.getX() && p.y == food.getY()) {
                return true;
            }
        }
        return false;
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
