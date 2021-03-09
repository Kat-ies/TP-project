package view;

import controller.ControllerInterface;
import model.ObservableModel;
import shape.Shape;
import shape.ShapeException;

import javax.swing.*;
import java.awt.*;

import java.util.Vector;

import utils.Point;
import view.shapedialogs.ShapeBuildDialog;

public class View implements Observer {
    private ControllerInterface controller;
    private ObservableModel model;
    private JFrame frame;
    private JList<String> shapeList;
    private JButton createButton;
    private JButton removeButton;
    private JButton moveButton;
    private PointDialog pointDialog;
    private ShapeBuildDialog shapeDialog;

    public View(ObservableModel model) {
        this.model = model;
        model.registerObserver(this);
        setupControls();
    }

    public void setController(ControllerInterface controller) {
        this.controller = controller;
    }

    public void showError(String message) {
        JOptionPane.showMessageDialog(frame, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public Shape buildShape() throws ShapeException, DataValidateException {
        return shapeDialog.chooseShape();
    }

    public Point askMovePoint(Point oldPoint) throws DataValidateException {
        return pointDialog.choosePoint(oldPoint);
    }

    private void setupControls() {
        frame = new JFrame();
        frame.setLocationRelativeTo(null);
        frame.setTitle("Shape Builder");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setSize(new Dimension(640, 480));

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new BorderLayout());
        frame.add(controlPanel, BorderLayout.WEST);

        DrawPanel drawPanel = new DrawPanel(model);
        frame.add(drawPanel, BorderLayout.CENTER);

        shapeList = new JList<>();
        shapeList.setLayoutOrientation(JList.VERTICAL);
        shapeList.addListSelectionListener(listSelectionEvent -> updateButtonsEnabled());
        controlPanel.add(shapeList, BorderLayout.CENTER);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(shapeList);
        controlPanel.add(scrollPane);

        createButton = new JButton("Create...");
        removeButton = new JButton("Remove");
        moveButton = new JButton("Move...");

        createButton.addActionListener(actionEvent -> controller.createClicked());
        removeButton.addActionListener(actionEvent -> controller.removeClicked(shapeList.getSelectedValue()));
        moveButton.addActionListener(actionEvent -> controller.moveClicked(shapeList.getSelectedValue()));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(createButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(moveButton);
        controlPanel.add(buttonPanel, BorderLayout.NORTH);

        pointDialog = new PointDialog();
        pointDialog.setLocationRelativeTo(frame);

        shapeDialog = new ShapeBuildDialog();
        shapeDialog.setLocationRelativeTo(frame);
    }

    public void show() {
        update();
        frame.setVisible(true);
    }

    private void updateButtonsEnabled() {
        boolean hasSelection = !shapeList.getSelectedValuesList().isEmpty();
        createButton.setEnabled(true);
        removeButton.setEnabled(hasSelection);
        moveButton.setEnabled(hasSelection);
    }

    private void updateShapeList() {
        Vector<String> shapeNames = new Vector<>(model.getShapeNames());
        shapeNames.sort(String::compareTo);
        String oldSelection = shapeList.getSelectedValue();
        shapeList.setListData(shapeNames);

        // Restore selection
        shapeList.setSelectedValue(oldSelection, true);
        if (shapeList.getSelectedIndex() == -1 && !shapeNames.isEmpty()) {
            shapeList.setSelectedIndex(0);
        }
        shapeList.ensureIndexIsVisible(shapeList.getSelectedIndex());
    }

    @Override
    public void update() {
        frame.repaint();
        updateShapeList();
        updateButtonsEnabled();
    }
}
