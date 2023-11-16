package controller.entities;

import java.util.ArrayList;

import model.entities.SaleDAO;

public class Sale {

    Client client;
    ArrayList<HotDog> hotDogs;
    SaleDAO saleDAO = new SaleDAO();

    public Sale(Client client, ArrayList<HotDog> hotDogs) {
        this.client = client;
        this.hotDogs = hotDogs;
    }

    public Client getClient() {
        return this.client;
    }

    public ArrayList<HotDog> getHotDogs() {
        return this.hotDogs;
    }

    public void insertSale(Sale sale) {

        saleDAO.insertSale(sale);

    }

}
