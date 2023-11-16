package view.containers;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.plaf.DimensionUIResource;

import model.Model;
import view.components.table.ClientTableModel;

import view.enums.WindowType;

public class ListClientsContainer extends BaseContainer {

    Model model;

    public ListClientsContainer(Model model) {

        super(WindowType.LIST_CLIENTS);
        this.model = model;

        ClientTableModel tableModel = new ClientTableModel(model.getSales());
        JTable tabela = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setPreferredSize(new DimensionUIResource(600, 400)); // Ajuste as dimensões conforme necessário

        this.getContent().add(scrollPane);
    }
}
