package view.containers;

import model.Model;
import view.components.table.SaleTableModel;
import view.enums.WindowType;

import java.awt.Dimension;

import javax.swing.*;

public class ListSalesContainer extends BaseContainer {

    Model model;

    public ListSalesContainer(Model model) {

    	super(WindowType.LIST_SALES);
        this.model = model;

        SaleTableModel tableModel = new SaleTableModel(model.getSales());
        JTable tabela = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setPreferredSize(new Dimension(600, 400)); // Ajuste as dimensões conforme necessário

        this.getContent().add(scrollPane);
    }

}
