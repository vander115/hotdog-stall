package view.windows;

import constants.MyColors;
import constants.MySizes;

import javax.swing.*;
import java.awt.*;

public class InitialWindow extends JFrame {

    private static final long serialVersionUID = 1L;

    public InitialWindow() {
        
        this.setResizable(false);
        this.setSize(MySizes.WINDOW_WIDTH, MySizes.WINDOW_HEIGHT);
        this.getContentPane().setBackground(MyColors.WINDOW_BACKGROUND_COLOR);

        JPanel root = new JPanel();
//        root.setLayout(new BoxLayout(root, BoxLayout.PAGE_AXIS));
        root.setLayout(new BorderLayout());
        root.setBackground(MyColors.WINDOW_BACKGROUND_COLOR);
        root.setSize(this.getWidth(), this.getHeight());

        root.add(header(), BorderLayout.NORTH);
        root.add(content(), BorderLayout.CENTER);

        root.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        this.add(root);
        
        this.setVisible(true);

    }

    private JPanel header() {
        JPanel header = new JPanel();
        
        Dimension defaultDimension = new Dimension(this.getWidth(), (this.getHeight()/ 5));
        
        header.setLayout(new BorderLayout());
        header.setPreferredSize(defaultDimension);
        header.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        header.setBackground(MyColors.WINDOW_BACKGROUND_COLOR);
        
        JPanel internalHeader = new JPanel();
        internalHeader.setLayout(new FlowLayout());
        internalHeader.setPreferredSize(defaultDimension);
        internalHeader.setBackground(MyColors.WINDOW_CONTAINERS_COLOR);
        header.add(internalHeader, BorderLayout.CENTER);

        return header;
    }

    private JPanel content() {
        JPanel content = new JPanel();

        content.setLayout(new BorderLayout());
        content.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        content.setBackground(MyColors.WINDOW_BACKGROUND_COLOR);

        JPanel internalContent = new JPanel();
        internalContent.setLayout(new BorderLayout());
        internalContent.setBackground(MyColors.WINDOW_CONTAINERS_COLOR);

        content.add(internalContent, BorderLayout.CENTER);
        return content;
    }


}
