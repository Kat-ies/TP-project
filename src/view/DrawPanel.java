package view;

import model.ObservableModel;

import javax.swing.*;
import java.awt.*;

class DrawPanel extends JPanel {
    private ObservableModel model;

    public DrawPanel(ObservableModel model) {
        this.model = model;
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.clearRect(0, 0, getWidth(), getHeight());
        model.getShapeNames().stream().sorted().forEach(name -> model.drawShape(name, (Graphics2D) g));
    }
}
