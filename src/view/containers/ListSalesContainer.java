package view.containers;

import controller.Controller;
import view.enums.WindowType;

import javax.swing.*;

public class ListSalesContainer extends BaseContainer {

    Controller controller;


    public ListSalesContainer(Controller controller) {

        super(WindowType.LIST_SALES);
        this.controller = controller;

        StallTableModel tableModel = new StallTableModel(controller.getSales());

        JTable tabela = new JTable(tableModel);

        this.getContent().add(tabela);
    }

}
