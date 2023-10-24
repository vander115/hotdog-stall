package entities;

import java.util.ArrayList;

public class Sale {

    Client client;
    ArrayList<HotDog> hotDogs;

    public Sale(Client client, ArrayList<HotDog> hotDogs) {
        this.client = client;
        this.hotDogs = hotDogs;
    }

    public Client getClient() {
        return this.client;
    }

    public ArrayList<HotDog> getHotDogs() {
        return this.hotDogs;
    }

}
