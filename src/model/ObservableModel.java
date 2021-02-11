package model;

import shape.Shape;
import utils.Point;

import java.util.List;

public interface ObservableModel {

    public int addShape(Shape shape);

    public void deleteShape(int id);

    public void drawShape(int id);

    public List<Integer> getIds();

    public Point getShapeLocation(int id);

    public void moveShape(int id, Point point);

    public void stateChanged();

}