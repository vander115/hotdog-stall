package view.windows;

import model.Model;
import view.components.StallButton;
import view.containers.*;
import view.enums.WindowType;
import view.style.StallColors;
import view.style.StallSizes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serial;
import java.util.ArrayList;

public class InitialWindow extends JFrame implements ActionListener {

    @Serial
    private static final long serialVersionUID = 1L;

    Model model = new Model();

    StallHeader header = new StallHeader();
    JPanel root = new JPanel();

    InitialContainer initialContainer = new InitialContainer();
    MakeSaleContainer makeSaleContainer = new MakeSaleContainer(model);
    ListSalesContainer listSalesContainer = new ListSalesContainer(model);
    ShowReportContainer showReportContainer = new ShowReportContainer(model);
    ListClientsContainer listClientsContainer = new ListClientsContainer(model);

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
        WindowButton ShowReport = new WindowButton("Mostar Relatório", WindowType.SHOW_REPORT, this);
        WindowButton listClients = new WindowButton("Listar Clientes", WindowType.LIST_CLIENTS, this);

        windowButtons.add(makeSaleButton);
        windowButtons.add(listSalesButton);
        windowButtons.add(listClients);
        windowButtons.add(ShowReport);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        removeContent();
        for (WindowButton button : windowButtons) {
            if (e.getSource().equals(button)) {
                for (BaseContainer container : containers) {
                    if (container.getType().equals(button.getWindowType())) {
                        container.revalidate();
                        container.repaint();
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
