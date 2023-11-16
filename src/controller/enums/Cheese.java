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

}
