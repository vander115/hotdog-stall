package view.containers;

import view.enums.WindowType;

import javax.swing.*;

public class InitialContainer extends BaseContainer {

    public InitialContainer() {
        super(WindowType.INITIAL);
        JLabel title = new JLabel("Bem Vindo a Barraquinha de Cachorro Quente!");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.CENTER);

        this.getContent().add(title);
    }


}
