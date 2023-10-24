package model;

import model.entities.Sale;

import java.util.ArrayList;

public class Model {

    private final ArrayList<Sale> sales;

    public Model() {
        sales = new ArrayList<>();
    }

    public void addSale(Sale sale) {
        sales.add(sale);
    }

    public ArrayList<Sale> getSales() {
        return sales;
    }

}
