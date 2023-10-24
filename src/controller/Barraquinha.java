package controller;

import java.util.Scanner;

public class Barraquinha {
	private static Scanner scanner = new Scanner(System.in);
	private static int selector;

	public static Client registerNewClient() {
		System.out.println("Digite o nome do cliente: ");
		String clientName = scanner.nextLine();

		System.out.println("Digite a matrícula do cliente: ");
		int clientId = scanner.nextInt();

		return new Client(clientName, clientId);
	}

	public static String selectProtein() {

		do {
			selector = 0;
			System.out.println(
					"Escolha a proteína do cachorro-quente:\n1 - Salsicha\n2 - Linguiça\n3 - Frango\n4 - Bacon");

			selector = scanner.nextInt();

			if (selector < 1 || selector > 4) {

				System.out.println("Opção inválida! Tente novamente:");

			} else {

				switch (selector) {

				case 1:
					return "Salsicha";
				case 2:
					return "Linguiça";
				case 3:
					return "Frango";
				case 4:
					return "Bacon";

				}

			}

		} while (selector < 1 || selector > 4);

		return "Salsicha";
	}

	public static String selectCheese() {
		do {
			selector = 0;
			System.out.println(
					"Escolha o queijo do cachorro-quente:\n1 - Mussarela\n2 - Prato\n3 - Parmesão\n4 - Coalho");

			selector = scanner.nextInt();

			if (selector < 1 || selector > 4) {

				System.out.println("Opção inválida! Tente novamente:");

			} else {

				switch (selector) {

				case 1:
					return "Mussarela";
				case 2:
					return "Prato";
				case 3:
					return "Parmesão";
				case 4:
					return "Coalho";

				}

			}

		} while (selector < 1 || selector > 4);

		return "Mussarela";
	}

	public static boolean selectComplement(String complement) {

		do {
			selector = 0;
			System.out.println("Deseja adicionar " + complement + "? (1 - Sim / 2 - Não): ");

			selector = scanner.nextInt();

			if (selector < 1 || selector > 2) {

				System.out.println("Opção inválida! Tente novamente:");

			} else {

				switch (selector) {

				case 1:
					return true;
				case 2:
					return false;
				}

			}

		} while (selector < 1 || selector > 2);

		return false;
	}

	public static String selectDrink() {
		do {
			selector = 0;
			System.out.println("Escolha a bebida:\n1 - Coca-cola\n2 - Del Rio\n3 - Suco do Chaves");

			selector = scanner.nextInt();

			if (selector < 1 || selector > 3) {

				System.out.println("Opção inválida! Tente novamente:");

			} else {

				switch (selector) {

				case 1:
					return "Coca-cola";
				case 2:
					return "Del Rio";
				case 3:
					return "Suco do Chaves";

				}

			}

		} while (selector < 1 || selector > 3);

		return "Coca-cola";
	}

	public static boolean buyAgain() {

		do {
			selector = 0;

			System.out.println("Deseja comprar mais um cachorro-quente? (1 - Sim / 2 - Não)");
			selector = scanner.nextInt();

			if (selector < 1 || selector > 3) {

				System.out.println("Opção Inválida! Tente novamente:");

			} else {

				switch (selector) {

				case 1:
					return true;
				case 2:
					return false;
				}

			}

		} while (selector < 1 || selector > 2);

		return false;
	}

	public static void showOrder(Order order) {
		System.out.println("Vamos revisar sua compra: ");

		Client client = order.getClient();

		System.out.println("-- CLIENTE --\nNome: " + client.getName() + "\nMatrícula: " + client.getID());
		System.out.println("-- CACHORROS-QUENTES --\n");

		for (int i = 0; i < order.getHotDogs().size(); i++) {
			HotDog hotDog = order.getHotDogs().get(i);
			System.out.println("Cachorro Quente N°" + (i + 1));
			System.out.println("Proteina: " + hotDog.protein);
			System.out.println("Queijo: " + hotDog.cheese);
			System.out.println("Bebida: " + hotDog.drink);
			if (hotDog.hasMayonnaise || hotDog.hasKetchup || hotDog.hasEgg || hotDog.hasPotatoes)
				System.out.print("Complementos: ");
			if (hotDog.hasMayonnaise)
				System.out.print("Maionese; ");
			if (hotDog.hasKetchup)
				System.out.print("Ketchup; ");
			if (hotDog.hasEgg)
				System.out.print("Ovo; ");
			if (hotDog.hasPotatoes)
				System.out.print("Batata Palha; ");
			System.out.print("\n\n");
		}
	}

	public static void main(String[] args) {
		boolean buyAgain = false;

		Client client = registerNewClient();

		Order order = new Order(client);

		System.out.println("\nVamos comprar cachorros-quentes!\n");

		do {

			String protein = selectProtein();
			String cheese = selectCheese();

			boolean hasMayonnaise = selectComplement("maionese");
			boolean hasKetchup = selectComplement("ketchup");
			boolean hasEgg = selectComplement("ovo");
			boolean hasPotatoes = selectComplement("batatas");

			String drink = selectDrink();

			HotDog hotDog = new HotDog(protein, cheese, drink);
			hotDog.setComplements(hasMayonnaise, hasKetchup, hasEgg, hasPotatoes);
			order.addHotDog(hotDog);

			buyAgain = buyAgain();

		} while (buyAgain);

		showOrder(order);

	}

}
