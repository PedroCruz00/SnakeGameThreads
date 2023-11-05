package model;

import java.awt.*;
import java.util.LinkedList;

public class Snake {
    private LinkedList<Point> body;
    private Direction direction;
    private int boardWidth;
    private int boardHeight;

    public Snake(int x, int y,int initialSize, int boardWidth, int boardHeight) {
        body = new LinkedList<>();
        for (int i = 0; i < initialSize; i++) {
            body.add(new Point(x, y + i));
        }
        direction = Direction.UP;
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
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
        x = (x + boardWidth) % boardWidth;
        y = (y + boardHeight) % boardHeight;
        Point newHead = new Point(x, y);

        body.addFirst(newHead);
        body.removeLast();

    }

    public void grow() {
        Point lastPart = body.getLast();
        body.addLast(new Point(lastPart.x, lastPart.y));
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

}

