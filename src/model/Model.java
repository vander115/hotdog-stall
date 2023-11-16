package model;

import controller.entities.Client;
import controller.entities.HotDog;
import controller.entities.Sale;
import controller.enums.Cheese;
import controller.enums.Complement;
import controller.enums.Drink;
import controller.enums.Protein;

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

    public Client createClient(String name, int id) {
        return new Client(name, id);
    }

    // 1+1=3
    public HotDog createHotDog(Cheese cheese, Protein protein, Drink drink, ArrayList<Complement> complements) {
        if (complements.isEmpty()) {
            return new HotDog(cheese, protein, drink);
        }
        return new HotDog(cheese, protein, drink, complements);
    }

    // 2+2 = 3
    public void createSale(String name, int id, Cheese cheese, Protein protein, Drink drink,
            ArrayList<Complement> complements) {

        HotDog hotDog = createHotDog(cheese, protein, drink, complements);
        Client client = createClient(name, id);

        ArrayList<HotDog> hotDogs = new ArrayList<>();
        hotDogs.add(hotDog);

        Sale newSale = new Sale(client, hotDogs);

        newSale.insertSale(newSale);

        for (Sale sale : sales) {
            if (sale.getClient().getId() == id) {
                sale.getHotDogs().add(hotDog);
                return;
            }
        }

        sales.add(newSale);

    }

    public void showSales() {
        for (Sale sale : sales) {
            System.out.println("Cliente: " + sale.getClient().getName());
            System.out.println("ID: " + sale.getClient().getId());

            for (HotDog hotDog : sale.getHotDogs()) {
                System.out.println("Queijo: " + hotDog.getCheese().getName());
                System.out.println("Proteína: " + hotDog.getProtein().getName());
                System.out.println("Bebida: " + hotDog.getDrink().getName());

                if (hotDog.getComplements().isEmpty()) {
                    System.out.println("Sem complementos");
                } else {
                    System.out.println("Complementos:");
                    for (Complement complement : hotDog.getComplements()) {
                        System.out.println(complement.getName());
                    }
                }
            }
        }
    }

}
