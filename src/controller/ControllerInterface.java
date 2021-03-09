package controller;

import shape.ShapeType;

public interface ControllerInterface {
    public void createClicked(ShapeType type);
    public void removeClicked(String name);
    public void moveClicked(String name);
}
