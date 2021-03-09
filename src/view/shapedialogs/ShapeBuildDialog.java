package view.shapedialogs;

import model.ModelException;
import view.DataValidateException;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import shape.Shape;

public class ShapeBuildDialog extends JDialog {
    private boolean isSuccess = false;
    private JComboBox<String> typeChooser;
    private JPanel mainPanel;
    private ShapeBuildPanel activePanel;
    private ArrayList<ShapeBuildPanel> shapePanels;

    private void registerShapeType(String name, ShapeBuildPanel panel) {
        panel.setupControls();
        shapePanels.add(panel);
        typeChooser.addItem(name);
    }

    private void registerShapeTypes() {
        registerShapeType("Rectangle", new RectangleBuildPanel());
        registerShapeType("Ellipse", new EllipseBuildPanel());
        registerShapeType("Circle", new CircleBuildPanel());
        registerShapeType("Diamond", new DiamondBuildPanel());
        registerShapeType("Segment", new SegmentBuildPanel());
        registerShapeType("Ray", new RayBuildPanel());
        registerShapeType("Line", new LineBuildPanel());
        registerShapeType("Triangle", new TriangleBuildPanel());
        registerShapeType("Regular polygon", new RegularPolygonBuildPanel());
        registerShapeType("Polygon", new PolygonBuildPanel());
    }

    private void updateShownPanel() {
        int index = typeChooser.getSelectedIndex();
        if (activePanel != null) {
            mainPanel.remove(activePanel);
        }
        activePanel = shapePanels.get(index);
        mainPanel.add(activePanel, BorderLayout.NORTH);
        pack();
    }

    public ShapeBuildDialog() {
        shapePanels = new ArrayList<>();
        setupControls();
    }

    private void setupControls() {
        setModalityType(ModalityType.APPLICATION_MODAL);
        setLayout(new BorderLayout());

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);

        JPanel typeChooserPanel = new JPanel();
        typeChooserPanel.setLayout(new BorderLayout(10, 0));
        typeChooserPanel.add(new JLabel("Type:"), BorderLayout.WEST);
        typeChooser = new JComboBox<>();
        typeChooserPanel.add(typeChooser, BorderLayout.CENTER);
        typeChooser.addItemListener(itemEvent -> updateShownPanel());

        registerShapeTypes();

        typeChooser.setSelectedIndex(0);
        add(typeChooserPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(buttonPanel, BorderLayout.SOUTH);

        JButton okButton = new JButton("OK");
        JButton cancelButton = new JButton("Cancel");

        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);

        okButton.addActionListener(actionEvent -> {
            isSuccess = true;
            setVisible(false);
        });
        cancelButton.addActionListener(actionEvent -> setVisible(false));

        pack();
    }

    public Shape chooseShape() throws ModelException, DataValidateException {
        isSuccess = false;
        setVisible(true);
        return isSuccess ? activePanel.getShape() : null;
    }
}
