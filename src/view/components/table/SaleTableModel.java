package view.components.table;

import controller.entities.HotDog;
import controller.entities.Sale;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class SaleTableModel extends AbstractTableModel {
    private final List<Sale> vendas;
    private final String[] colunas = { "Nome C.", "Id C.", "Queijo", "Proteína", "Bebida", "Complementos" };

    public SaleTableModel(List<Sale> vendas) {
        this.vendas = vendas;
    }

    @Override
    public int getRowCount() {
        // Retorna o total de linhas necessárias
        return vendas.stream().mapToInt(v -> v.getHotDogs().size()).sum();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Sale venda = getVenda(rowIndex);
        HotDog hotDog = getHotDog(rowIndex);

        return switch (columnIndex) {
            case 0 -> {
                assert venda != null;
                yield venda.getClient().getName();
            }
            case 1 -> {
                assert venda != null;
                yield venda.getClient().getId();
            }
            case 2 -> {
                assert hotDog != null;
                yield hotDog.getCheese().getName();
            }
            case 3 -> {
                assert hotDog != null;
                yield hotDog.getProtein().getName();
            }
            case 4 -> {
                assert hotDog != null;
                yield hotDog.getDrink().getName();
            }
            case 5 -> {
                assert hotDog != null;
                yield hotDog.getComplementsNames();
            }
            default -> null;
        };
    }

    private Sale getVenda(int rowIndex) {
        int rowCount = 0;
        for (Sale venda : vendas) {
            int hotDogsCount = venda.getHotDogs().size();
            if (rowCount + hotDogsCount > rowIndex) {
                return venda;
            }
            rowCount += hotDogsCount;
        }
        return null;
    }

    private HotDog getHotDog(int rowIndex) {
        int rowCount = 0;
        for (Sale venda : vendas) {
            int hotDogsCount = venda.getHotDogs().size();
            if (rowCount + hotDogsCount > rowIndex) {
                return venda.getHotDogs().get(rowIndex - rowCount);
            }
            rowCount += hotDogsCount;
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
}
