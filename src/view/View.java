package view;

import controller.ControllerInterface;
import model.ObservableModel;
import shape.Shape;

public class View implements Observer {

    private ControllerInterface controller;
    private ObservableModel model;

    public View() {

    }

    public Shape buildCircle() {
        return null;
    }

    public Shape buildDiamond() {
        return null;
    }

    public Shape buildEllipse() {
        return null;
    }

    public Shape buildLine() {
        return null;
    }

    public Shape buildPolygon() {
        return null;
    }

    public void buildRay() {

    }

    public Shape buildRectangle() {
        return null;
    }

    public Shape buildRegularPolygon() {
        return null;
    }

    public void buildSegment() {

    }

    public Shape buildTriangle() {
        return null;
    }

    private void createControls() {

    }

    public void displayCircleCreationForm() {

    }

    public void displayDiamondCreationForm() {

    }

    public void displayEllipseCreationForm() {

    }

    public void displayLineCreationForm() {

    }

    public void displayPolygonCreationForm() {

    }

    public void displayRayCreationForm() {

    }

    public void displayRectangleCreationForm() {

    }

    public void displayRegularPolygonCreationForm() {

    }

    public void displaySegmentCreationForm() {

    }

    public void displayTriangleCreationForm() {

    }

    @Override
    public void update() {

    }
}