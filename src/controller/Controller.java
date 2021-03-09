package controller;

import model.ObservableModel;
import shape.Shape;
import shape.ShapeException;
import view.DataValidateException;
import view.PointFormatException;
import view.View;
import utils.Point;

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
            Shape shape = view.buildShape();
            if (shape == null) {
                return;
            }
            model.addShape(shape);
        } catch (ShapeException e) {
            view.showError("Cannot create shape: " + e.getMessage());
        } catch (DataValidateException e) {
            view.showError("Invalid data: " + e.getMessage());
        }
    }

    @Override
    public void removeClicked(String name) {
        model.removeShape(name);
    }

    @Override
    public void moveClicked(String name) {
        try {
            Point point = view.askMovePoint(model.getShapeLocation(name));
            if (point == null) {
                return;
            }
            model.moveShape(name, point);
        } catch (DataValidateException e) {
            view.showError("Invalid data: " + e.getMessage());
        }
    }

}
