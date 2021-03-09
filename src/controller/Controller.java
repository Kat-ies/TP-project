package controller;

import model.ObservableModel;
import shape.ShapeException;
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
    public void createClicked() {
        try {
            model.addShape(view.buildShape());
        } catch (ShapeException e) {
            view.showError("Cannot create shape: " + e.getMessage());
        }
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
