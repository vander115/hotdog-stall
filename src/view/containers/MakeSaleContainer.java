package view.containers;

import view.enums.WindowType;
import view.components.*;
import view.style.StallColors;

import javax.swing.*;
import java.awt.*;

public class MakeSaleContainer extends BaseContainer {

    StallTextInput clientNameInput;
    StallTextInput clientIdInput;
    StallSelect cheeseSelect;
    StallSelect proteinSelect;

    StallCheckBox maioneseCheckbox;
    StallCheckBox ketchupCheckbox;
    StallCheckBox ovoCheckbox;
    StallCheckBox batataPalhaCheckbox;

    public MakeSaleContainer() {
        super(WindowType.MAKE_SALE);

        JPanel inputsContent = new JPanel();
        inputsContent.setLayout(new GridLayout(6, 2, 5, 25));
        inputsContent.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        inputsContent.setBackground(StallColors.WINDOW_CONTAINERS_COLOR);

        inputsContent.add(new StallLabel("Nome do Cliente:"));
        inputsContent.add(new StallTextInput());

        inputsContent.add(new StallLabel("Identificação"));
        inputsContent.add(new StallTextInput());

        inputsContent.add(new StallLabel("Opção de Queijo:"));
        inputsContent.add(new StallSelect(new String[]{"Sem Queijo", "Com Queijo"}));

        inputsContent.add(new StallLabel("Opção de Proteina:"));
        inputsContent.add(new StallSelect(new String[]{"Sem Proteina", "Com Proteina"}));

        inputsContent.add(new StallLabel("Escolha os acompanhamentos:"));

        JPanel checkboxContent = new JPanel();
        checkboxContent.setBackground(null);
        checkboxContent.setLayout(new GridLayout(2, 2));
        checkboxContent.add(new StallCheckBox("Maionese"));
        checkboxContent.add(new StallCheckBox("Ketchup"));
        checkboxContent.add(new StallCheckBox("Ovo"));
        checkboxContent.add(new StallCheckBox("Batata Palha"));

        inputsContent.add(checkboxContent);
        inputsContent.add(new JLabel());
        inputsContent.add(new StallButton("Finalizar Venda"));
        this.getContent().add(inputsContent);

    }
}
