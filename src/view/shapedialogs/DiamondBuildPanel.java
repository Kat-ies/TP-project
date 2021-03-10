package view.shapedialogs;

import shape.Diamond;
import shape.Shape;
import utils.Point;
import view.DataValidateException;
import view.PointPickerPanel;

public class DiamondBuildPanel extends ShapeBuildPanel {
    private PointPickerPanel topPointChooser;
    private PointPickerPanel rightPointChooser;

    @Override
    public void setupControls() {
        super.setupControls();

        topPointChooser = new PointPickerPanel();
        topPointChooser.setPoint(new Point(50, 1));
        addField("Top point:", topPointChooser);

        rightPointChooser = new PointPickerPanel();
        rightPointChooser.setPoint(new Point(100, 100));
        addField("Right point:", rightPointChooser);
    }

    @Override
    protected void setupShape(Shape shape) throws DataValidateException {
        super.setupShape(shape);
        Diamond diamond = (Diamond)shape;
        diamond.setPoints(topPointChooser.getPoint(), rightPointChooser.getPoint());
    }

    @Override
    protected Shape createShape() {
        return new Diamond();
    }
}
