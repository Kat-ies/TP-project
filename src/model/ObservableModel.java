package model;

import shape.Shape;
import utils.Point;
import view.Observer;

import java.util.List;

public interface ObservableModel {

    public void addShape(Shape shape);

    public void deleteShape(String name);

    public void drawShape(String name);

    public List<String> getShapeNames();

    public Point getShapeLocation(String name);

    public void moveShape(String name, Point point);

    public void registerObserver(Observer observer);

    public void remoteObserver(Observer observer);

    public void stateChanged();

}
