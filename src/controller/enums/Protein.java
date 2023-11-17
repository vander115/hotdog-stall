package controller.enums;

public enum Protein {
    SAUSAGE("Salsicha", 2.0),
    TUSCAN_SAUSAGE("Linguiça", 3.0),
    CHICKEN("Frango", 2.5),
    BACON("Bacon", 3.5);

    final String name;
    final double price;
    final int index;

    Protein(String name, double price) {
        this.name = name;
        this.price = price;
        this.index = this.ordinal() + 1;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return price;
    }

    public int getIndex() {
        return this.index;
    }

    public static Protein convertValueToEnum(String value) {
        for (Protein protein : Protein.values()) {
            if (protein.getName().equalsIgnoreCase(value)) {
                return protein;
            }
        }
        throw new IllegalArgumentException("Nenhum enum encontrado para o valor: " + value);
    }
}
