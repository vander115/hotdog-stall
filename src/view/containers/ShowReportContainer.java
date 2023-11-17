package view.containers;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;

import model.Model;
import view.components.StallLabel;
import view.enums.WindowType;

public class ShowReportContainer extends BaseContainer {

    JPanel reportContent = new JPanel();

    Model model;

    public ShowReportContainer(Model model) {
        super(WindowType.SHOW_REPORT);

        this.model = model;
        reportContent.setLayout(new GridLayout(4, 1));

        if (!model.getSales().isEmpty()) {
            setLabels();
        }

        this.getContent().add(reportContent);
    }

    public void setLabels() {
        reportContent.add(new StallLabel("Total de Vendas: " + model.getTotalOfSales()));
        reportContent.add(new StallLabel("Total de Cachorros Quentes Vendidos: " + model.getTotalOfHotDogs()));
        reportContent.add(new StallLabel("Cachorro Quente mais vendido: " + model.getBestSellingProtein().getName()));
        reportContent.add(new StallLabel("Bebida mais vendida: " + model.getBestSellingDrink().getName()));
    }
}
