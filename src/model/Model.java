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
    public int addShape(Shape shape) {
        return 0;
    }

    @Override
    public void deleteShape(int id) {

    }

    @Override
    public void drawShape(int id) {

    }

    @Override
    public List<Integer> getIds() {
        return null;
    }

    @Override
    public Point getShapeLocation(int id) {
        return null;
    }

    @Override
    public void moveShape(int id, Point point) {

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
