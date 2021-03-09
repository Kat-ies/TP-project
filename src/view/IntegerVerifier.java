package view;

import javax.swing.*;

public class IntegerVerifier extends InputVerifier {
    @Override
    public boolean verify(JComponent input) {
        try {
            Integer.parseInt(((JTextField)input).getText());
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
