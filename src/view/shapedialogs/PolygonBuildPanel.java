package view.shapedialogs;

import shape.Polygon;
import shape.Shape;
import utils.Point;
import view.DataValidateException;
import view.PointDialog;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class PolygonBuildPanel extends ShapeBuildPanel {
    private Vector<Point> points;
    private JList<Point> pointList;
    private JButton addButton;
    private JButton removeButton;
    private PointDialog pointDialog;

    private void addPoint() {
        try {
            Point point = pointDialog.choosePoint(new Point(0, 0));
            if (point != null) {
                points.add(point);
            }
        } catch (DataValidateException e) {
            JOptionPane.showMessageDialog(this, "Invalid point", "Error", JOptionPane.ERROR_MESSAGE);
        }
        pointList.updateUI();
        updateButtons();
    }

    private void removePoint() {
        points.remove(pointList.getSelectedValue());
        pointList.updateUI();
        pointList.setSelectedIndex(0);
    }

    private void updateButtons() {
        addButton.setEnabled(true);
        removeButton.setEnabled(!points.isEmpty() && pointList.getSelectedIndex() >= 0);
    }

    @Override
    public void setupControls() {
        super.setupControls();

        pointDialog = new PointDialog();
        pointDialog.setLocationRelativeTo(this);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        addButton = new JButton("Add");
        addButton.addActionListener(actionEvent -> addPoint());
        controlPanel.add(addButton);

        removeButton = new JButton("Remove");
        removeButton.addActionListener(actionEvent -> removePoint());
        controlPanel.add(removeButton);

        add(controlPanel);

        JPanel pointListContainer = new JPanel();
        pointListContainer.setLayout(new BorderLayout());
        add(pointListContainer);

        pointList = new JList<>();
        pointList.setLayoutOrientation(JList.VERTICAL);
        pointList.addListSelectionListener(listSelectionEvent -> updateButtons());
        pointListContainer.add(pointList, BorderLayout.CENTER);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(pointList);
        pointListContainer.add(scrollPane);

        resetPointList();
        updateButtons();
    }

    private void resetPointList() {
        points = new Vector<>();
        points.add(new Point(1, 1));
        points.add(new Point(1, 50));
        points.add(new Point(50, 50));
        pointList.setListData(points);
    }

    @Override
    protected void setupShape(Shape shape) throws DataValidateException {
        super.setupShape(shape);
        Polygon poly = (Polygon)shape;
        poly.setPoints(points);
        resetPointList();
    }

    @Override
    protected Shape createShape() {
        return new Polygon();
    }
}
