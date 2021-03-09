package view.shapedialogs;

import shape.Shape;
import shape.ShapeException;
import view.DataValidateException;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.text.ParseException;

public abstract class ShapeBuildPanel extends JPanel {
    private JTextField nameField;
    private JSpinner frameWidthChooser;
    private Color fillColor = new Color(255, 255, 255);
    private Color frameColor = new Color(0, 0, 0);

    public Shape getShape() throws ShapeException, DataValidateException {
        Shape shape = createShape();
        setupShape(shape);
        shape.validate();
        return shape;
    }

    protected void addField(String label, Component field) {
        JPanel helperPanel = new JPanel();
        helperPanel.setLayout(new BorderLayout(10, 0));
        helperPanel.add(new JLabel(label), BorderLayout.WEST);
        helperPanel.add(field, BorderLayout.CENTER);
        add(helperPanel);
    }

    public void setupControls() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        nameField = new JTextField("Shape");
        nameField.setColumns(30);
        addField("Name:", nameField);

        JButton fillColorChooser = new JButton("Choose...");
        fillColorChooser.addActionListener(actionEvent -> {
            fillColor = JColorChooser.showDialog(this, "Choose color...", fillColor);
        });
        addField("Fill color:", fillColorChooser);

        JButton frameColorChooser = new JButton("Choose...");
        frameColorChooser.addActionListener(actionEvent -> {
            frameColor = JColorChooser.showDialog(this, "Choose color...", frameColor);
        });
        addField("Border color:", frameColorChooser);

        frameWidthChooser = new JSpinner();
        frameWidthChooser.setModel(new SpinnerNumberModel(1, 1, 20, 1));
        addField("Frame width:", frameWidthChooser);
    }

    protected void setupShape(Shape shape) throws DataValidateException {
        shape.setName(nameField.getText());
        shape.setFillColor(fillColor);
        shape.setFrameColor(frameColor);
        try {
            frameWidthChooser.commitEdit();
        } catch (ParseException e) {
            throw new DataValidateException(e.getMessage());
        }
        Number value = (Number)frameWidthChooser.getValue();
        shape.setFrameWidth(value.intValue());
    }

    protected abstract Shape createShape();
}
