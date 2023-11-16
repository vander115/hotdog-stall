package model.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.entities.Client;
import controller.entities.HotDog;
import controller.entities.Sale;
import model.ModelConnection;

public class SaleDAO {

  public void insertSale(Sale sale) {

    Client client = sale.getClient();
    ArrayList<HotDog> hotDogs = sale.getHotDogs();

    for (HotDog hotDog : hotDogs) {
      try {
        Connection connection = new ModelConnection().getConnection();

        PreparedStatement insert = connection.prepareStatement(
            "INSERT INTO cachorro_quente (nome, matricula, op_queijo, op_proteina, ingredientes, bebida, valor)VALUES (?, ?, ?, ?, ?, ?, ?)");

        insert.setString(1, client.getName());
        insert.setInt(2, client.getId());
        insert.setInt(3, hotDog.getCheese().getIndex());
        insert.setInt(4, hotDog.getProtein().getIndex());
        insert.setString(5, hotDog.getComplementsString());
        insert.setInt(6, hotDog.getDrink().getIndex());
        insert.setDouble(7, hotDog.getPrice());

        insert.execute();

        connection.close();
      } catch (SQLException exception) {
        exception.printStackTrace();
      }
    }
  }

}
