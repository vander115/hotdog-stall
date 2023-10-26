package model.enums;

public enum Drink {

    COKE("Coca-Cola"),
    DEL_RIO("Del Rio"),
    CHAVES_JUICE("Suco do Chaves");

    final String name;

    Drink(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
