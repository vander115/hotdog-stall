package view.components.table;

import controller.entities.Sale;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ClientTableModel extends AbstractTableModel {
    private final List<Sale> sales;
    private final String[] columns = { "Nome", "Id", "Cachorros Quentes" };

    public ClientTableModel(List<Sale> sales) {
        this.sales = sales;
    }

    @Override
    public int getRowCount() {
        return sales.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Sale sale = getVenda(rowIndex);

        return switch (columnIndex) {
            case 0 -> {
                assert sale != null;
                yield sale.getClient().getName();
            }
            case 1 -> {
                assert sale != null;
                yield sale.getClient().getId();
            }
            case 2 -> {
                assert sale.getHotDogs() != null;
                yield sale.getHotDogs().size();
            }
            default -> null;
        };
    }

    private Sale getVenda(int rowIndex) {
        int rowCount = 0;
        for (Sale venda : sales) {
            int hotDogsCount = venda.getHotDogs().size();
            if (rowCount + hotDogsCount > rowIndex) {
                return venda;
            }
            rowCount += hotDogsCount;
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
}
