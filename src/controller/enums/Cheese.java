package controller.enums;

public enum Cheese {

    MOZZARELLA("Mussarela"),
    CHEDDAR("Prato"),
    PARMESAN("Parmesão"),
    CURD("Coalho");

    final String name;
    final int index;

    Cheese(String name) {
        this.name = name;
        this.index = this.ordinal() + 1;
    }

    public String getName() {
        return this.name;
    }

    public int getIndex() {
        return this.index;
    }

    public static Cheese convertValueToEnum(String value) {
        for (Cheese cheese : Cheese.values()) {
            if (cheese.getName().equalsIgnoreCase(value)) {
                return cheese;
            }
        }
        throw new IllegalArgumentException("Nenhum enum encontrado para o valor: " + value);
    }

}
