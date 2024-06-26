package co.edu.uptc.pojo;

import java.awt.*;
import java.io.Serializable;

public class RacketPojo implements Serializable {
    private Point point;
    private int width;
    private int height;
    private int speed;


    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "point=" + point +
                ", width=" + width +
                ", height=" + height +
                ", speed=" + speed + "\n";
    }
}
