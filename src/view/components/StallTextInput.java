package view.components;

import view.style.StallFonts;

import javax.swing.*;

public class StallTextInput extends JTextField {

    public StallTextInput(int columns) {
        super(columns);
        this.setFont(StallFonts.montserratMedium(14));


    }

    public StallTextInput() {
        this(10);
    }
}
