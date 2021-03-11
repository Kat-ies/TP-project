package view.shapedialogs;

import shape.Circle;
import shape.Shape;
import utils.Point;
import view.DataValidateException;
import view.IntegerVerifier;
import view.PointPickerPanel;

import javax.swing.*;

public class CircleBuildPanel extends ShapeBuildPanel {
    private PointPickerPanel centerChooser;
    private JTextField radiusChooser;

    @Override
    public void setupControls() {
        super.setupControls();

        centerChooser = new PointPickerPanel();
        centerChooser.setPoint(new Point(50, 50));
        addField("Center:", centerChooser);

        radiusChooser = new JTextField("40");
        radiusChooser.setColumns(7);
        radiusChooser.setInputVerifier(new IntegerVerifier());
        addField("Radius:", radiusChooser);
    }

    @Override
    protected void setupShape(Shape shape) throws DataValidateException {
        super.setupShape(shape);
        int radius;
        try {
            radius = Integer.parseInt(radiusChooser.getText());
        } catch (NumberFormatException e) {
            throw new DataValidateException(e.getMessage());
        }
        Circle circle = (Circle)shape;
        circle.setPoints(centerChooser.getPoint(), radius);
    }

    @Override
    protected Shape createShape() {
        return new Circle();
    }
}
