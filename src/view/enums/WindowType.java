package view.enums;

public enum WindowType {
    INITIAL("Página Inicial"),
    MAKE_SALE("Realizar Venda"),
    LIST_SALES("Listar Vendas"),
    SHOW_REPORT("Exibir Relatório"),
    LIST_CLIENTS("Listar Clientes");

    private final String name;

    WindowType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    ;

}
