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

public class Builder {

    private final Model model = new Model();

    public Client createClient(String name, int id) {
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
    public void createSale(String name, int id, Cheese cheese, Protein protein, Drink drink, ArrayList<Complement> complements) {

        HotDog hotDog = createHotDog(cheese, protein, drink, complements);

        for (Sale sale : model.getSales()) {
            if (sale.getClient().getId() == id) {
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


}
