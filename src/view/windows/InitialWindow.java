package view.windows;

import constants.MyColors;

import javax.swing.*;
import java.awt.*;

public class InitialWindow extends JFrame {

    private final int WINDOW_HEIGHT = 540;
    private final int WINDOW_WIDTH = 960;


    public InitialWindow() {
        this.setVisible(true);
        this.setResizable(false);
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.getContentPane().setBackground(MyColors.WINDOW_BACKGROUND_COLOR);

        JPanel root = new JPanel();
        root.setLayout(new BorderLayout());
        root.setBackground(MyColors.WINDOW_BACKGROUND_COLOR);
        root.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        root.add(header());
        root.add(content());

        root.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        this.add(root);

    }

    private JPanel header() {
        JPanel header = new JPanel();
        header.setLayout(new BorderLayout());
        header.setSize(WINDOW_WIDTH, 200);
        header.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JPanel internalHeader = new JPanel();
        internalHeader.setLayout(new FlowLayout());
        internalHeader.setSize(WINDOW_WIDTH, 200);
        internalHeader.setBackground(MyColors.WINDOW_CONTAINERS_COLOR);
        header.add(internalHeader, BorderLayout.CENTER);

        return header;
    }

    private JPanel content() {
        JPanel content = new JPanel();

        content.setLayout(new BorderLayout());
        content.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JPanel internalContent = new JPanel();
        internalContent.setLayout(new BorderLayout());
        internalContent.setBackground(MyColors.WINDOW_CONTAINERS_COLOR);

        content.add(internalContent, BorderLayout.CENTER);
        return content;
    }


}
