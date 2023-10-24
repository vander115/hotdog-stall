package model.entities;

public class Client {

    String name;
    int Id;

    public Client(String name, int Id) {
        this.name = name;
        this.Id = Id;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.Id;
    }

}
