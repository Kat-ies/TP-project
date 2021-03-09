package view.shapedialogs;

import shape.RegularPolygon;
import shape.Shape;
import utils.Point;
import view.DataValidateException;
import view.PointPanel;

import javax.swing.*;
import java.text.ParseException;

public class RegularPolygonBuildPanel extends ShapeBuildPanel {
    private PointPanel centerChooser;
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
        poly.setCenter(centerChooser.getPoint());
        try {
            numberOfSidesChooser.commitEdit();
            Number numSides = (Number)numberOfSidesChooser.getValue();
            poly.setSidesNumber(numSides.intValue());
        } catch (ParseException e) {
            throw new DataValidateException(e.getMessage());
        }
        try {
            int radius = Integer.parseInt(radiusChooser.getText());
            poly.setRadius(radius);
        } catch (NumberFormatException e) {
            throw new DataValidateException(e.getMessage());
        }
    }

    @Override
    public void setupControls() {
        super.setupControls();

        centerChooser = new PointPanel();
        centerChooser.setPoint(new Point(50, 50));
        addField("Center:", centerChooser);

        radiusChooser = new JTextField("40");
        radiusChooser.setColumns(7);
        radiusChooser.setInputVerifier(new InputVerifier() {
           @Override
           public boolean verify(JComponent input) {
               try {
                   int x = Integer.parseInt(((JTextField) input).getText());
                   return x > 0;
               } catch (NumberFormatException e) {
                   return false;
               }
           }
        });
        addField("Point on bounding circle:", radiusChooser);

        numberOfSidesChooser = new JSpinner();
        numberOfSidesChooser.setModel(new SpinnerNumberModel(5, 1, 100, 1));
    }
}
