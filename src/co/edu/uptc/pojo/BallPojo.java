package co.edu.uptc.pojo;

import co.edu.uptc.model.DirectionEnum;

import java.awt.*;
import java.io.Serializable;

public class BallPojo implements Serializable {
    private Point point;
    private int size;
    private DirectionEnum direction;
    private int speed;
    private int dy;  

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public DirectionEnum getDirection() {
        return direction;
    }

    public void setDirection(DirectionEnum direction) {
        this.direction = direction;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }


}