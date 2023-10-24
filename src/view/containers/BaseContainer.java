package view.containers;

import view.style.StallSizes;
import view.enums.WindowType;
import view.style.StallColors;

import javax.swing.*;
import java.awt.*;

public abstract class BaseContainer extends JPanel {

    protected JPanel content = new JPanel();
    protected WindowType type;

    public BaseContainer(WindowType type) {
        this.type = type;
        this.setPreferredSize(new Dimension(StallSizes.WINDOW_WIDTH - 25, StallSizes.WINDOW_HEIGHT - StallSizes.HEADER_HEIGHT - 20));
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        this.setBackground(StallColors.WINDOW_BACKGROUND_COLOR);

        content.setBackground(StallColors.WINDOW_CONTAINERS_COLOR);
        content.setLayout(new BorderLayout());

        this.add(content, BorderLayout.CENTER);


        this.setVisible(true);
    }

    public JPanel getContent() {
        return content;
    }

    public WindowType getType() {
        return type;
    }
}
