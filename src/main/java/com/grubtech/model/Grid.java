package com.grubtech.model;

public class Grid {

    private DirectionType[][] plateau;

    private final int upperRightX;

    private final int upperRightY;

    private Point activePoint;

    private DirectionType activeDirection;

    public Grid(int upperRightX, int upperRightY) {
        this.upperRightX = upperRightX;
        this.upperRightY = upperRightY;
        plateau = new DirectionType[upperRightX+1][upperRightY+1];
    }

    public Point getActivePoint() {
        return activePoint;
    }

    public void setActivePoint(Point activePoint) {
        this.activePoint = activePoint;
    }

    public void setPlateau(DirectionType[][] plateau) {
        this.plateau = plateau;
    }

    public DirectionType[][] getPlateau() {
        return plateau;
    }

    public DirectionType getActiveDirection() {
        return activeDirection;
    }

    public void setActiveDirection(DirectionType activeDirection) {
        this.activeDirection = activeDirection;
    }

    public int getUpperRightX() {
        return upperRightX;
    }

    public int getUpperRightY() {
        return upperRightY;
    }
}