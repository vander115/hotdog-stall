package model.enums;

public enum Cheese {

    MOZZARELLA("Mussarela"),
    CHEDDAR("Prato"),
    PARMESAN("Parmesão"),
    CURD("Coalho");

    final String name;

    Cheese(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}
