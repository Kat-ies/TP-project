package view;

import utils.Point;

import javax.swing.*;
import java.awt.*;

public class PointPanel extends JPanel {
    private JTextField xPointField;
    private JTextField yPointField;

    public PointPanel() {
        xPointField = new JTextField("0.0");
        yPointField = new JTextField("0.0");

        setLayout(new FlowLayout());
        add(new JLabel("X: "));
        add(xPointField);
        add(new JLabel("Y: "));
        add(yPointField);

        InputVerifier verifier = new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                try {
                    Integer.parseInt(((JTextField)input).getText());
                } catch (NumberFormatException e) {
                    return false;
                }
                return true;
            }
        };

        xPointField.setInputVerifier(verifier);
        yPointField.setInputVerifier(verifier);
    }

    public Point getPoint() {
        try {
            return new Point(Integer.parseInt(xPointField.getText()), Integer.parseInt(yPointField.getText()));
        } catch (NumberFormatException e) {
            throw new PointFormatException();
        }
    }

}
