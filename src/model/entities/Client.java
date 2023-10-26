package model.entities;

public class Client {

    String name;
    String Id;

    public Client(String name, String Id) {
        this.name = name;
        this.Id = Id;
    }

    public String getName() {
        return this.name;
    }

    public String getId() {
        return this.Id;
    }

}
