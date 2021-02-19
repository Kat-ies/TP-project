package view;

import controller.ControllerInterface;
import model.ObservableModel;
import shape.Shape;
import shape.ShapeType;

public class View implements Observer {

    private ControllerInterface controller;
    private ObservableModel model;

    public View() {

    }

    public Shape buildShape(ShapeType shapeType) {
        return null;
    }

    private void createControls() {

    }

    @Override
    public void update() {

    }

}
