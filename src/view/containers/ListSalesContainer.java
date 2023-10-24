package view.containers;

import enums.WindowType;

import javax.swing.*;

public class ListSalesContainer extends BaseContainer {

    public ListSalesContainer() {
        super(WindowType.LIST_SALES);
        this.getContent().add(new JLabel("Listar Vendas"));
    }

}
