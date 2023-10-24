package view.components;

import view.style.StallFonts;

import javax.swing.*;

public class StallCheckBox extends JCheckBox {

    public StallCheckBox(String text) {
        super(text);
        this.setBackground(null);
        this.setFont(StallFonts.montserratMedium(14));
    }

    public StallCheckBox() {
        this("");
    }

}
