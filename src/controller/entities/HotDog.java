package entities;

import enums.Cheese;
import enums.Complement;
import enums.Drink;
import enums.Protein;

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

    public ArrayList<Complement> getComplements() {
        return complements;
    }

}
