package controller.enums;

public enum Complement {

    MAYONNAISE("Maionese"),
    KETCHUP("Ketchup"),
    EGG("Ovo"),
    SHOESTRING_POTATOES("Batata Palha");

    final String name;

    Complement(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static Complement convertValueToEnum(String value) {
        for (Complement complement : Complement.values()) {
            if (complement.getName().equalsIgnoreCase(value)) {
                return complement;
            }
        }
        throw new IllegalArgumentException("Nenhum enum encontrado para o valor: " + value);
    }

}
