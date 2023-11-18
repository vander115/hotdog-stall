package controller.entities;

public class Client {

    String name;
    int id;

    public Client(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

}
