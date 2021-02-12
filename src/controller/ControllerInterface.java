package controller;

import shape.ShapeType;

public interface ControllerInterface {

    public void changeShapeCreationForm(ShapeType shapeType);

    public void deleteClicked(int id);

    public void getLocationClicked(int id);

    public void moveClicked(int id);

    public void submitClicked();

}
