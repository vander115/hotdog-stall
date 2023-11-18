package model;

import controller.entities.Client;
import controller.entities.HotDog;
import controller.entities.Sale;
import controller.enums.Cheese;
import controller.enums.Complement;
import controller.enums.Drink;
import controller.enums.Protein;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Model {

    private ArrayList<Sale> sales;
    private final FileManager fileManager;

    public Model() {
        sales = new ArrayList<>();
        this.fileManager = new FileManager("src/data/sales.txt");
        try {
            sales = fileManager.getSalesFromFile();
            System.out.println("Vendas carregadas com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
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
    public Sale createSale(String name, int id, Cheese cheese, Protein protein, Drink drink,
            ArrayList<Complement> complements) {

        HotDog hotDog = createHotDog(cheese, protein, drink, complements);
        Client client = createClient(name, id);

        ArrayList<HotDog> hotDogs = new ArrayList<>();
        hotDogs.add(hotDog);

        Sale newSale = new Sale(client, hotDogs);

        for (Sale sale : sales) {
            if (sale.getClient().getId() == id) {
                sale.getHotDogs().add(hotDog);
                fileManager.convertSalesToString(sales);
                return sale;
            }
        }

        sales.add(newSale);

        fileManager.convertSalesToString(sales);

        return newSale;
    }

    public int getTotalOfHotDogs() {
        int total = 0;
        for (Sale sale : sales) {
            total += sale.getHotDogs().size();
        }
        return total;
    }

    public int getTotalOfSales() {
        return sales.size();
    }

    public Drink getBestSellingDrink() {
        Map<Drink, Integer> drinkCountMap = new HashMap<>();

        for (Sale sale : sales) {
            for (HotDog hotDog : sale.getHotDogs()) {

                Drink drink = hotDog.getDrink();
                drinkCountMap.put(drink, drinkCountMap.getOrDefault(drink, 0) + 1);
            }
        }

        Drink bestSellingDrink = null;
        int maxCount = 0;

        for (Map.Entry<Drink, Integer> entry : drinkCountMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                bestSellingDrink = entry.getKey();
            }
        }

        return bestSellingDrink;
    }

    public Protein getBestSellingProtein() {
        Map<Protein, Integer> proteinCountMap = new HashMap<>();

        for (Sale sale : sales) {
            for (HotDog hotDog : sale.getHotDogs()) {

                Protein protein = hotDog.getProtein();
                proteinCountMap.put(protein, proteinCountMap.getOrDefault(protein, 0) + 1);
            }
        }

        Protein bestSellingProtein = null;
        int maxCount = 0;

        for (Map.Entry<Protein, Integer> entry : proteinCountMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                bestSellingProtein = entry.getKey();
            }
        }

        return bestSellingProtein;
    }
}
