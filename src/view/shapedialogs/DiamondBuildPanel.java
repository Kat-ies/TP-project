package view.shapedialogs;

import shape.Diamond;
import shape.Shape;
import utils.Point;
import view.DataValidateException;
import view.PointPanel;

public class DiamondBuildPanel extends ShapeBuildPanel {
    private PointPanel topPointChooser;
    private PointPanel rightPointChooser;

    @Override
    public void setupControls() {
        super.setupControls();

        topPointChooser = new PointPanel();
        topPointChooser.setPoint(new Point(50, 1));
        addField("Top point:", topPointChooser);

        rightPointChooser = new PointPanel();
        rightPointChooser.setPoint(new Point(100, 100));
        addField("Right point:", rightPointChooser);
    }

    @Override
    protected void setupShape(Shape shape) throws DataValidateException {
        super.setupShape(shape);
        Diamond diamond = (Diamond)shape;
        diamond.setTopPoint(topPointChooser.getPoint());
        diamond.setRightPoint(rightPointChooser.getPoint());
    }

    @Override
    protected Shape createShape() {
        return new Diamond();
    }
}
