package view.containers;

import controller.Controller;
import model.enums.Cheese;
import model.enums.Complement;
import model.enums.Drink;
import model.enums.Protein;
import view.components.*;
import view.enums.WindowType;
import view.style.StallColors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MakeSaleContainer extends BaseContainer implements ActionListener {

    JPanel inputsContent = new JPanel();

    Controller controller = new Controller();

    StallTextInput clientNameInput = new StallTextInput();
    StallTextInput clientIdInput = new StallTextInput();
    StallSelect cheeseSelect;
    StallSelect proteinSelect;

    StallCheckBox mayonnaiseCheckbox = new StallCheckBox("Maionese");
    StallCheckBox ketchupCheckbox = new StallCheckBox("Ketchup");
    StallCheckBox eggCheckbox = new StallCheckBox("Ovo");
    StallCheckBox shoestringPotatoesCheckbox = new StallCheckBox("Batata Palha");


    public MakeSaleContainer(Controller controller) {
        super(WindowType.MAKE_SALE);
        this.controller = controller;

        inputsContent.setLayout(new GridLayout(7, 2, 5, 25));
        inputsContent.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        inputsContent.setBackground(StallColors.WINDOW_CONTAINERS_COLOR);

        setTextInputs();
        setSelects();
        setCheckboxex();

        inputsContent.add(new JLabel());

        StallButton addSaleButton = new StallButton("Realizar Venda");
        addSaleButton.addActionListener(this);

        inputsContent.add(addSaleButton);
        this.getContent().add(inputsContent);

    }

    private void setTextInputs() {
        inputsContent.add(new StallLabel("Nome do Cliente:"));
        inputsContent.add(clientNameInput);

        inputsContent.add(new StallLabel("Identificação"));
        inputsContent.add(clientIdInput);
    }

    private void setSelects() {
        inputsContent.add(new StallLabel("Opção de Queijo:"));

        Cheese[] cheeses = Cheese.values();
        String[] cheeseNames = new String[cheeses.length];
        for (int i = 0; i < cheeses.length; i++) {
            cheeseNames[i] = cheeses[i].getName();
        }
        cheeseSelect = new StallSelect(cheeseNames);
        inputsContent.add(cheeseSelect);

        inputsContent.add(new StallLabel("Opção de Proteína:"));
        Protein[] proteins = Protein.values();
        String[] proteinNames = new String[proteins.length];
        for (int i = 0; i < proteins.length; i++) {
            proteinNames[i] = proteins[i].getName();
        }
        proteinSelect = new StallSelect(proteinNames);
        inputsContent.add(proteinSelect);

        inputsContent.add(new StallLabel("Opção de Bebida"));
        Drink[] drinks = Drink.values();
        String[] drinkNames = new String[drinks.length];
        for (int i = 0; i < drinks.length; i++) {
            drinkNames[i] = drinks[i].getName();
        }
        StallSelect drinkSelect = new StallSelect(drinkNames);
        inputsContent.add(drinkSelect);
    }

    private void setCheckboxex() {

        inputsContent.add(new StallLabel("Escolha os acompanhamentos:"));

        JPanel checkboxContent = new JPanel();
        checkboxContent.setBackground(null);
        checkboxContent.setLayout(new GridLayout(2, 2));

        checkboxContent.add(mayonnaiseCheckbox);
        checkboxContent.add(ketchupCheckbox);
        checkboxContent.add(eggCheckbox);
        checkboxContent.add(shoestringPotatoesCheckbox);

        inputsContent.add(checkboxContent);
    }

    private void resetInputs() {
        clientNameInput.setText("");
        clientIdInput.setText("");
        cheeseSelect.setSelectedIndex(0);
        proteinSelect.setSelectedIndex(0);
        mayonnaiseCheckbox.setSelected(false);
        ketchupCheckbox.setSelected(false);
        eggCheckbox.setSelected(false);
        shoestringPotatoesCheckbox.setSelected(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String clientName = clientNameInput.getText();
        String clientId = clientIdInput.getText();

        if (clientName.isEmpty() || clientId.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Cheese cheese = Cheese.values()[cheeseSelect.getSelectedIndex()];

        Protein protein = Protein.values()[proteinSelect.getSelectedIndex()];

        Drink drink = Drink.values()[proteinSelect.getSelectedIndex()];

        ArrayList<Complement> complements = new ArrayList<>();

        if (mayonnaiseCheckbox.isSelected()) {
            complements.add(Complement.MAYONNAISE);
        }
        if (ketchupCheckbox.isSelected()) {
            complements.add(Complement.KETCHUP);
        }
        if (eggCheckbox.isSelected()) {
            complements.add(Complement.EGG);
        }
        if (shoestringPotatoesCheckbox.isSelected()) {
            complements.add(Complement.SHOESTRING_POTATOES);
        }

        try {
            controller.createSale(clientName, clientId, cheese, protein, drink, complements);
            resetInputs();
            JOptionPane.showMessageDialog(null, "Venda realizada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
