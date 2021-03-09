package model;

import shape.Shape;
import utils.Point;
import view.Observer;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Model implements ObservableModel {

    private List<Observer> observers;
    private Map<String, Shape> shapes;

    public Model() {
        this.observers = new ArrayList<>();
        this.shapes = new HashMap<>();
    }

    @Override
    public void addShape(Shape shape) throws ModelException {
        if (shapes.containsKey(shape.getName())) {
            throw new ModelException("Shape with name " + shape.getName() + " already exists");
        }
        shapes.put(shape.getName(), shape);
        stateChanged();
    }

    @Override
    public void removeShape(String name) {
        shapes.remove(name);
        stateChanged();
    }

    @Override
    public void drawShape(String name, Graphics graphics) {
        shapes.get(name).draw(graphics);
    }

    @Override
    public List<String> getShapeNames() {
        return new ArrayList<>(shapes.keySet());
    }

    @Override
    public Point getShapeLocation(String name) {
        return shapes.get(name).location();
    }

    @Override
    public void moveShape(String name, Point point) {
        shapes.get(name).move(point);
        stateChanged();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void stateChanged() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
