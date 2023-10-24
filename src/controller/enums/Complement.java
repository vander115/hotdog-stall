package enums;

public enum Complement {

    MAYONNAISE("Maionese"),
    KETCHUP("Ketchup"),
    EGG("Ovo"),
    POTATO_STICK("Batata Palha");

    final String name;

    Complement(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}
