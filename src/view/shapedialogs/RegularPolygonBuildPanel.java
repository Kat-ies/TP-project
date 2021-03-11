package view.shapedialogs;

import shape.RegularPolygon;
import shape.Shape;
import utils.Point;
import view.DataValidateException;
import view.IntegerVerifier;
import view.PointPickerPanel;

import javax.swing.*;
import java.text.ParseException;

public class RegularPolygonBuildPanel extends ShapeBuildPanel {
    private PointPickerPanel centerChooser;
    private JTextField radiusChooser;
    private JSpinner numberOfSidesChooser;

    @Override
    protected Shape createShape() {
        return new RegularPolygon();
    }

    @Override
    protected void setupShape(Shape shape) throws DataValidateException {
        super.setupShape(shape);
        RegularPolygon poly = (RegularPolygon)shape;
        Point center = centerChooser.getPoint();

        try {
            numberOfSidesChooser.commitEdit();
            Number numSides = (Number)numberOfSidesChooser.getValue();
            int radius = Integer.parseInt(radiusChooser.getText());

            poly.setPolygonPoints(center, radius, numSides.intValue());
        } catch (ParseException e) {
            throw new DataValidateException(e.getMessage());
        }
    }

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

        numberOfSidesChooser = new JSpinner();
        numberOfSidesChooser.setModel(new SpinnerNumberModel(5, 1, 100, 1));
        addField("Point on bounding circle: ", numberOfSidesChooser);
    }
}
