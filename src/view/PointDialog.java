package view;

import javax.swing.*;
import java.awt.*;

import utils.Point;

public class PointDialog extends JDialog {
    private PointPanel panel;
    private boolean isSuccess = false;

    public PointDialog() {
        setupControls();
    }

    private void setupControls() {
        setModalityType(ModalityType.APPLICATION_MODAL);
        setLayout(new BorderLayout());

        setTitle("Choose point...");

        panel = new PointPanel();
        add(panel, BorderLayout.CENTER);

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
    }

    public Point choosePoint(Point old) throws DataValidateException {
        setupDialog(old);
        pack();
        setVisible(true);
        return getMovePoint();
    }

    private void setupDialog(Point point) {
        isSuccess = false;
        panel.setPoint(point);
    }

    private Point getMovePoint() throws DataValidateException {
         return isSuccess ? panel.getPoint() : null;
    }
}
