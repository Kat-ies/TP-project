package model;

import shape.Shape;
import shape.ShapeException;
import utils.Point;
import view.Observer;

import java.awt.*;
import java.util.List;

public interface ObservableModel {

    public void addShape(Shape shape) throws ShapeException;

    public void removeShape(String name);

    public void drawShape(String name, Graphics graphics);

    public List<String> getShapeNames();

    public Point getShapeLocation(String name);

    public void moveShape(String name, Point point);

    public void registerObserver(Observer observer);

    public void unregisterObserver(Observer observer);

    public void stateChanged();

}
