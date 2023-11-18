package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.entities.HotDog;
import controller.entities.Sale;
import controller.enums.Cheese;
import controller.enums.Complement;
import controller.enums.Drink;
import controller.enums.Protein;
import model.Model;

public class Menu {
  Model model;

  public Menu() {
    this.model = new Model();

    showFirstMenu();
  }

  public void showFirstMenu() {
    Scanner scanner = new Scanner(System.in);
    int option;

    do {
      System.out.println("BEM VINDO A BARRAQUINHA DE CACHORROS QUENTES\n\n");
      System.out.println("1 - Realizar Venda");
      System.out.println("2 - Outras Opções");
      System.out.println("3 - Sair");

      option = scanner.nextInt();

      if (option == 1) {
        createSaleOptions();
      }

      if (option < 1 || option > 3) {
        System.out.println("Opção inválida, tente novamente");
      }
    } while (option != 3);

  }

  public void createSaleOptions() {

    Scanner createSaleScanner = new Scanner(System.in);

    System.out.println("Digite o nome do cliente: ");
    String clientName = createSaleScanner.nextLine();
    System.out.println();

    System.out.println("Digite a identificação do cliente: ");
    int id = createSaleScanner.nextInt();
    System.out.println();

    Protein protein = chooseProtein();
    System.out.println();

    Cheese cheese = chooseCheese();
    System.out.println();

    Drink drink = chooseDrink();
    System.out.println();

    ArrayList<Complement> complements = chooseComplements();
    System.out.println();

    try {
      Sale sale = model.createSale(clientName, id, cheese, protein, drink, complements);
      System.out.println("Venda realizada com sucesso!");
      if (sale != null) {
        showSale(sale);
      }
    } catch (Exception e) {
      System.out.println("Erro ao realizar venda");
    }
  }

  public Protein chooseProtein() {
    Scanner scanner = new Scanner(System.in);
    int proteinOption;

    do {
      System.out.println("Escolha a proteina: ");
      for (Protein protein : Protein.values()) {
        System.out.println((protein.ordinal() + 1) + " - " + protein.getName());
      }

      proteinOption = scanner.nextInt();
    } while (proteinOption < 1 || proteinOption > Protein.values().length);
    return Protein.values()[proteinOption - 1];
  }

  public Cheese chooseCheese() {
    Scanner scanner = new Scanner(System.in);
    int option;

    do {
      System.out.println("Escolha o queijo: ");
      for (Cheese cheese : Cheese.values()) {
        System.out.println((cheese.ordinal() + 1) + " - " + cheese.getName());
      }

      option = scanner.nextInt();
    } while (option < 1 || option > Cheese.values().length);

    return Cheese.values()[option - 1];
  }

  public Drink chooseDrink() {
    Scanner scanner = new Scanner(System.in);

    int option;

    do {
      System.out.println("Escolha o queijo: ");
      for (Drink drink : Drink.values()) {
        System.out.println((drink.ordinal() + 1) + " - " + drink.getName());
      }

      option = scanner.nextInt();
    } while (option < 1 || option > Drink.values().length);
    return Drink.values()[option - 1];
  }

  public ArrayList<Complement> chooseComplements() {
    int option;
    Scanner scanner = new Scanner(System.in);

    ArrayList<Complement> complements = new ArrayList<Complement>();

    for (Complement complement : Complement.values()) {
      do {
        System.out.println("Deseja adicionar " + complement.getName() + "?");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");

        option = scanner.nextInt();

        if (option < 1 || option > 2) {
          System.out.println("Opção inválida, tente novamente");
        }

      } while (option < 1 || option > 2);
      if (option == 1) {
        complements.add(complement);
      }
    }

    return complements;
  }

  public void showSale(Sale sale) {
    System.out.println("Cliente: " + sale.getClient().getName() + ", ID: " + sale.getClient().getId());
    for (int i = 0; i < sale.getHotDogs().size(); i++) {

      HotDog hotDog = sale.getHotDogs().get(i);

      System.out.println("\tHot Dog " + (i + 1) + ":");
      System.out.println("\tQueijo: " + hotDog.getCheese().getName() + ", Proteina: "
          + hotDog.getProtein().getName() + ", Bebida: " + hotDog.getDrink().getName());
      if (!hotDog.getComplements().isEmpty()) {
        System.out.print("\tComplementos: ");
        for (Complement complement : hotDog.getComplements()) {
          System.out.print(complement.getName() + "; ");
        }
        System.out.println();
      }
      System.out.println();
    }
    System.out.println();
  }

  public void showOthersOptionsMenu() {
    Scanner scanner = new Scanner(System.in);
    int option;


    do {
      System.out.println("O que você deseja vizualizar?");
      System.out.println("1 - Total de Cachorros Quentes Vendidos");
      System.out.println("2 - Cachorro Quente mais vendido por Proteina");
      System.out.println("3 - Bebida mais vendida");
    } while ();
  }
}