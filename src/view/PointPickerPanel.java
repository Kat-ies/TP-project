package view;

import utils.Point;

import javax.swing.*;
import java.awt.*;

public class PointPickerPanel extends JPanel {
    private JTextField xPointField;
    private JTextField yPointField;

    public PointPickerPanel() {
        xPointField = new JTextField("0");
        yPointField = new JTextField("0");

        xPointField.setColumns(7);
        yPointField.setColumns(7);

        setLayout(new FlowLayout());
        add(new JLabel("X: "));
        add(xPointField);
        add(new JLabel("    ")); // Gap
        add(new JLabel("Y: "));
        add(yPointField);

        xPointField.setInputVerifier(new IntegerVerifier());
        yPointField.setInputVerifier(new IntegerVerifier());
    }

    public void setPoint(Point point) {
        xPointField.setText(Integer.toString(point.x));
        yPointField.setText(Integer.toString(point.y));
    }

    public Point getPoint() throws PointFormatException {
        try {
            return new Point(Integer.parseInt(xPointField.getText()), Integer.parseInt(yPointField.getText()));
        } catch (NumberFormatException e) {
            throw new PointFormatException(e.getMessage());
        }
    }

}
