package controller.entities;

public class Client {

    String name;
    int id;

    public Client(String name, int Id) {
        this.name = name;
        this.id = Id;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

}
