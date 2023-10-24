package view.containers;

import view.style.StallSizes;
import view.style.StallColors;

import javax.swing.*;
import java.awt.*;

public class StallHeader extends JPanel {

    Dimension defaultDimension = new Dimension(StallSizes.WINDOW_WIDTH, StallSizes.HEADER_HEIGHT);

    JPanel internalHeader = new JPanel();

    public StallHeader() {
        this.setLayout(new BorderLayout());
        this.setPreferredSize(defaultDimension);
        this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        this.setBackground(StallColors.WINDOW_BACKGROUND_COLOR);

        internalHeader.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 5));
        internalHeader.setSize(defaultDimension);
        internalHeader.setBackground(StallColors.WINDOW_CONTAINERS_COLOR);

        this.add(internalHeader, BorderLayout.CENTER);
    }

    public void add(JComponent component) {
        internalHeader.add(component);
    }

}
