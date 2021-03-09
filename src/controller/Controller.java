package controller;

import model.ObservableModel;
import shape.ShapeType;
import view.View;

public class Controller implements ControllerInterface {

    private ObservableModel model;
    private View view;

    public Controller(ObservableModel model) {
        this.model = model;
    }

    public void setView(View view) {
        this.view = view;
        view.setController(this);
    }

    @Override
    public void createClicked(ShapeType type) {
        model.addShape(view.buildShape(type));
    }

    @Override
    public void removeClicked(String name) {
        model.removeShape(name);
    }

    @Override
    public void moveClicked(String name) {
        model.moveShape(name, view.askMovePoint(model.getShapeLocation(name)));
    }

}
