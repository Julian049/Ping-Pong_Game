package co.edu.uptc.pojo;

import co.edu.uptc.model.DirectionEnum;

import java.awt.*;
import java.io.Serializable;

public class BallPojo implements Serializable {
    private Point point;
    private int size;
    private int angle;
    private DirectionEnum direction;
    private int speed;

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

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    @Override
    public String toString() {
        return "point=" + point +
                ", size=" + size +
                ", angle=" + angle +
                ", direction=" + direction +
                ", speed=" + speed + "\n";
    }
}
