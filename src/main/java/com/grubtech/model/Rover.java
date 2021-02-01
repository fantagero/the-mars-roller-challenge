package com.grubtech.model;

import com.grubtech.command.CommandType;

import java.util.List;

public class Rover {

    private Point point;

    private DirectionType direction;

    private List<CommandType> commands;

    public Rover(Point point, DirectionType direction, List<CommandType> commands) {
        this.point = point;
        this.direction = direction;
        this.commands = commands;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public DirectionType getDirection() {
        return direction;
    }

    public void setDirection(DirectionType direction) {
        this.direction = direction;
    }

    public List<CommandType> getCommands() {
        return commands;
    }

    public void setCommands(List<CommandType> commands) {
        this.commands = commands;
    }
}
