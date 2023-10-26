package controller;

import model.Model;
import model.entities.Client;
import model.entities.HotDog;
import model.entities.Sale;
import model.enums.Cheese;
import model.enums.Complement;
import model.enums.Drink;
import model.enums.Protein;

import java.util.ArrayList;

public class Controller {

    private final Model model = new Model();

    public Client createClient(String name, String id) {
        return new Client(name, id);
    }

    //1+1=3
    public HotDog createHotDog(Cheese cheese, Protein protein, Drink drink, ArrayList<Complement> complements) {
        if (complements.isEmpty()) {
            return new HotDog(cheese, protein, drink);
        }
        return new HotDog(cheese, protein, drink, complements);
    }

    //2+2 = 3
    public void createSale(String name, String id, Cheese cheese, Protein protein, Drink drink, ArrayList<Complement> complements) {

        HotDog hotDog = createHotDog(cheese, protein, drink, complements);

        for (Sale sale : model.getSales()) {
            if (sale.getClient().getId().equals(id)) {
                sale.getHotDogs().add(hotDog);
                return;
            }
        }

        Client client = createClient(name, id);

        ArrayList<HotDog> hotDogs = new ArrayList<>();
        hotDogs.add(hotDog);

        Sale sale = new Sale(client, hotDogs);

        model.addSale(sale);

    }

    public ArrayList<Sale> getSales() {
        return model.getSales();
    }

    public void showSales() {
        for (Sale sale : model.getSales()) {
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
