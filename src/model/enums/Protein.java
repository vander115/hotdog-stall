package model.enums;

public enum Protein {
    SAUSAGE("Salsicha"),
    TUSCAN_SAUSAGE("Linguiça"),
    CHICKEN("Frango"),
    BACON("Bacon");

    final String name;

    Protein(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}
