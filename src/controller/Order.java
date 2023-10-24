package controller;

import java.util.ArrayList;
import java.util.List;

public class Order {
	private Client client;
	private List<HotDog> hotDogs;

	public Order(Client client) {
		this.client = client;
		this.hotDogs = new ArrayList<>();
	}

	public void addHotDog(HotDog hotDog) {
		hotDogs.add(hotDog);
	}

	public Client getClient() {
		return client;
	}

	public List<HotDog> getHotDogs() {
		return hotDogs;
	}

}
