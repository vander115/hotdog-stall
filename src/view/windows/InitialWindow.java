package view.windows;

import constants.StallSizes;
import enums.WindowType;
import view.components.StallButton;
import view.containers.*;
import view.style.StallColors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serial;
import java.util.ArrayList;

public class InitialWindow extends JFrame implements ActionListener {

    @Serial
    private static final long serialVersionUID = 1L;


    StallHeader header = new StallHeader();

    JPanel root = new JPanel();

    InitialContainer initialContainer = new InitialContainer();
    MakeSaleContainer makeSaleContainer = new MakeSaleContainer();
    ListSalesContainer listSalesContainer = new ListSalesContainer();
    ShowReportContainer showReportContainer = new ShowReportContainer();
    ListClientsContainer listClientsContainer = new ListClientsContainer();

    ArrayList<WindowButton> windowButtons = new ArrayList<>();
    ArrayList<BaseContainer> containers = new ArrayList<>();

    public InitialWindow() {
        super("Barraquinha de Cachorro Quente");
        this.setResizable(false);
        this.setSize(StallSizes.WINDOW_WIDTH, StallSizes.WINDOW_HEIGHT);
        this.getContentPane().setBackground(StallColors.WINDOW_BACKGROUND_COLOR);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        root.setLayout(new BorderLayout(0, 0));
        root.setBackground(StallColors.WINDOW_BACKGROUND_COLOR);
        root.setSize(this.getWidth(), this.getHeight());

        setButtons();
        for (WindowButton windowButton : windowButtons) {
            header.add(windowButton);
        }

        setContainers();

        root.add(header, BorderLayout.NORTH);

        initialContainer.setVisible(true);

        root.add(initialContainer, BorderLayout.CENTER);
        root.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        this.add(root);

        this.setVisible(true);

    }

    private void setButtons() {
        WindowButton makeSaleButton = new WindowButton("Realizar Venda", WindowType.MAKE_SALE, this);
        WindowButton listSalesButton = new WindowButton("Listar Vendas", WindowType.LIST_SALES, this);
        WindowButton ShowReport = new WindowButton("Relatório", WindowType.SHOW_REPORT, this);
        WindowButton listClients = new WindowButton("Listar Clientes", WindowType.LIST_CLIENTS, this);

        windowButtons.add(makeSaleButton);
        windowButtons.add(listSalesButton);
        windowButtons.add(ShowReport);
        windowButtons.add(listClients);
    }

    private void setContainers() {
        containers.add(initialContainer);
        containers.add(makeSaleContainer);
        containers.add(listSalesContainer);
        containers.add(showReportContainer);
        containers.add(listClientsContainer);
    }


    private void removeContent() {
        for (BaseContainer container : containers) {
            root.remove(container);
        }
    }

    private JPanel content() {
        JPanel content = new JPanel();

        content.setLayout(new BorderLayout());
        content.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        content.setBackground(StallColors.WINDOW_BACKGROUND_COLOR);

        JPanel internalContent = new JPanel();
        internalContent.setLayout(new BorderLayout());
        internalContent.setBackground(StallColors.WINDOW_CONTAINERS_COLOR);

        content.add(internalContent, BorderLayout.CENTER);

        return content;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        removeContent();
        for (WindowButton button : windowButtons) {
            if (e.getSource().equals(button)) {
                for (BaseContainer container : containers) {
                    if (container.getType().equals(button.getWindowType())) {
                        root.add(container, BorderLayout.CENTER);
                    }
                }
            }
        }
        root.revalidate();
        root.repaint();
    }

    private class WindowButton extends StallButton {

        WindowType windowType;

        public WindowButton(String text, WindowType windowType, ActionListener actionListener) {
            super(text);
            this.windowType = windowType;
            this.addActionListener(actionListener);
        }

        public WindowType getWindowType() {
            return windowType;
        }
    }

}
