package model;

import shape.Shape;
import utils.Point;
import view.Observer;

import java.util.List;

public class Model implements ObservableModel {

    private List<Observer> observers;
    private List<Shape> shapes;

    public Model() {

    }

    @Override
    public void addShape(Shape shape) {

    }

    @Override
    public void deleteShape(String name) {

    }

    @Override
    public void drawShape(String name) {

    }

    @Override
    public List<String> getShapeNames() {
        return null;
    }

    @Override
    public Point getShapeLocation(String name) {
        return null;
    }

    @Override
    public void moveShape(String name, Point point) {

    }

    @Override
    public void registerObserver(Observer observer) {

    }

    @Override
    public void remoteObserver(Observer observer) {

    }

    @Override
    public void stateChanged() {

    }

}
