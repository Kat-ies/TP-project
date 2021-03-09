package view;

import controller.ControllerInterface;
import model.ObservableModel;
import shape.Rectangle;
import shape.Shape;
import shape.ShapeType;

import javax.swing.*;
import java.awt.*;

import java.util.Random;
import java.util.Vector;

import utils.Point;

public class View implements Observer {
    private ControllerInterface controller;
    private ObservableModel model;
    private JFrame frame;
    private JList<String> list;
    private JButton createButton;
    private JButton removeButton;
    private JButton moveButton;

    public View(ObservableModel model) {
        this.model = model;
        model.registerObserver(this);
        createControls();
    }

    public void setController(ControllerInterface controller) {
        this.controller = controller;
    }

    static Random random = new Random();

    public Shape buildShape(ShapeType shapeType) {
        // TODO
        return new Rectangle(new Point(random.nextInt(300), random.nextInt(300)),
                             new Point(random.nextInt(300), random.nextInt(300)),
                             random.nextInt(3) + 1,
                             new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)),
                             new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
    }

    public Point askMovePoint(Point oldPoint) {
        // TODO
        return new Point(0, 0);
    }

    private void createControls() {
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

        list = new JList<>();
        list.setPreferredSize(new Dimension(200, 200));
        list.addListSelectionListener(listSelectionEvent -> updateButtonsEnabled());
        controlPanel.add(list, BorderLayout.CENTER);

        createButton = new JButton("Create...");
        removeButton = new JButton("Remove");
        moveButton = new JButton("Move...");

        // TODO : create figures of ANY type
        createButton.addActionListener(actionEvent -> controller.createClicked(ShapeType.RECTANGLE));
        removeButton.addActionListener(actionEvent -> controller.removeClicked(list.getSelectedValue()));
        moveButton.addActionListener(actionEvent -> controller.moveClicked(list.getSelectedValue()));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(createButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(moveButton);
        controlPanel.add(buttonPanel, BorderLayout.NORTH);
    }

    public void show() {
        update();
        frame.setVisible(true);
    }

    private void updateButtonsEnabled() {
        boolean hasSelection = !list.getSelectedValuesList().isEmpty();
        createButton.setEnabled(true);
        removeButton.setEnabled(hasSelection);
        moveButton.setEnabled(hasSelection);
    }

    @Override
    public void update() {
        frame.repaint();
        Vector<String> shapeNames = new Vector<>(model.getShapeNames());
        shapeNames.sort(String::compareTo);
        String oldSelection = list.getSelectedValue();
        list.setListData(shapeNames);
        list.setSelectedValue(oldSelection, true);
    }
}
