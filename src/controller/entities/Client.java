package entities;

public class Client {

    String name;
    int ID;

    public Client(String name, int ID) {
        this.name = name;
        this.ID = ID;
    }

    public String getName() {
        return this.name;
    }

    public int getID() {
        return this.ID;
    }

}
