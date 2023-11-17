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

    public static Drink convertValueToEnum(String value) {
        for (Drink drink : Drink.values()) {
            if (drink.getName().equalsIgnoreCase(value)) {
                return drink;
            }
        }
        throw new IllegalArgumentException("Nenhum enum encontrado para o valor: " + value);
    }
}
