package model.entities;

import model.enums.Cheese;
import model.enums.Complement;
import model.enums.Drink;
import model.enums.Protein;

import java.util.ArrayList;

public class HotDog {
    Cheese cheese;
    Protein protein;
    Drink drink;
    ArrayList<Complement> complements = new ArrayList<>();

    public HotDog(Cheese cheese, Protein protein, Drink drink, ArrayList<Complement> complements) {
        this.cheese = cheese;
        this.protein = protein;
        this.drink = drink;
        this.complements = complements;
    }

    public HotDog(Cheese cheese, Protein protein, Drink drink) {
        this.cheese = cheese;
        this.protein = protein;
        this.drink = drink;
    }

    public Cheese getCheese() {
        return cheese;
    }

    public Protein getProtein() {
        return protein;
    }

    public Drink getDrink() {
        return drink;
    }

    public ArrayList<Complement> getComplements() {
        return complements;
    }

    public ArrayList<String> getComplementsNames() {
        ArrayList<String> names = new ArrayList<>();
        for (Complement complement : complements) {
            names.add(complement.getName());
        }
        return names;
    }

}
