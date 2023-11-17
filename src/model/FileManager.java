package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import controller.entities.Client;
import controller.entities.HotDog;
import controller.entities.Sale;
import controller.enums.Cheese;
import controller.enums.Complement;
import controller.enums.Drink;
import controller.enums.Protein;

public class FileManager {

  private String stringData;
  private String path;

  public FileManager(String path) {

    this.path = path;

    StringBuilder stringBuilder = new StringBuilder();

    try (BufferedReader reader = new BufferedReader(new FileReader(this.path))) {
      String line;
      while ((line = reader.readLine()) != null) {
        stringBuilder.append(line).append("\n");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    stringData = stringBuilder.toString();
  }

  public void convertSalesToString(ArrayList<Sale> sales) {
    StringBuilder stringBuilder = new StringBuilder();

    for (Sale sale : sales) {
      // Adiciona o nome do cliente e ID ao StringBuilder
      stringBuilder.append("Client: ").append(sale.getClient().getName()).append(", ID: ")
          .append(sale.getClient().getId()).append("\n");

      // Adiciona os detalhes de cada hot dog ao StringBuilder
      for (HotDog hotDog : sale.getHotDogs()) {
        stringBuilder.append("\tCheese: ").append(hotDog.getCheese().getName())
            .append(", Protein: ").append(hotDog.getProtein().getName())
            .append(", Drink: ").append(hotDog.getDrink().getName())
            .append(", Complements: ").append(String.join(", ", hotDog.getComplementsNames()))
            .append("\n");
      }

      // Adiciona uma linha em branco para separar diferentes vendas
      stringBuilder.append("\n");
    }

    stringData = stringBuilder.toString();

    saveStringToFile(path, stringData);
  }

  public ArrayList<Sale> getSalesFromFile() {
    ArrayList<Sale> sales = new ArrayList<>();

    // Divide a String em linhas para obter cada venda separadamente
    String[] saleStrings = stringData.split("\n");

    // Variáveis temporárias para armazenar informações durante a iteração
    Client currentClient = null;
    ArrayList<HotDog> currentHotDogs = new ArrayList<>();

    for (String saleString : saleStrings) {
      if (saleString.trim().isEmpty()) {
        // Se a linha estiver vazia, isso indica o final de uma venda
        if (currentClient != null && !currentHotDogs.isEmpty()) {
          Sale sale = new Sale(currentClient, currentHotDogs);
          sales.add(sale);
          // Limpa as variáveis temporárias para a próxima venda
          currentClient = null;
          currentHotDogs = new ArrayList<>();
        }
      } else if (saleString.startsWith("Client:")) {
        // Se a linha começa com "Client:", extrai as informações do cliente
        String[] clientInfo = saleString.split(", ID: ");
        String name = clientInfo[0].substring("Client: ".length()).trim();
        int id = Integer.parseInt(clientInfo[1].trim());
        currentClient = new Client(name, id);
      } else if (saleString.startsWith("\tCheese:")) {
        // Se a linha começa com "\tCheese:", extrai as informações do hot dog
        String[] hotDogInfo = saleString.split(", Protein: |, Drink: |, Complements: ");
        Cheese cheese = Cheese.convertValueToEnum(hotDogInfo[0].substring("\tCheese: ".length()).trim());
        Protein protein = Protein.convertValueToEnum(hotDogInfo[1].trim());
        Drink drink = Drink.convertValueToEnum(hotDogInfo[2].trim());
        // Extrai os complementos
        HotDog hotDog;

        if (!(hotDogInfo.length < 4)) {
          String[] complementNames = hotDogInfo[3].split(", ");
          ArrayList<Complement> complements = new ArrayList<>();
          for (String complementName : complementNames) {
            complements.add(Complement.convertValueToEnum(complementName.trim()));
          }
          // Cria o objeto HotDog
          hotDog = new HotDog(cheese, protein, drink, complements);
        } else {
          hotDog = new HotDog(cheese, protein, drink);
        }

        currentHotDogs.add(hotDog);
      }
    }

    // Verifica se há uma venda pendente no final da String
    if (currentClient != null && !currentHotDogs.isEmpty()) {
      Sale sale = new Sale(currentClient, new ArrayList<>(currentHotDogs));
      sales.add(sale);
    }

    return sales;
  }

  public void saveStringToFile(String fileName, String data) {
    try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
      writer.print(data);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
