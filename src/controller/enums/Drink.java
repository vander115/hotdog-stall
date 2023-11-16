package controller.enums;

public enum Drink {

    COKE("Coca-Cola"),
    DEL_RIO("Del Rio"),
    CHAVES_JUICE("Suco do Chaves");

    final String name;
    final int index;

    Drink(String name) {
        this.name = name;
        this.index = this.ordinal() + 1;
    }

    public String getName() {
        return this.name;
    }

    public int getIndex() {
        return this.index;
    }
}
