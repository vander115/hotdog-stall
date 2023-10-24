package view.components;

import view.style.StallFonts;

import javax.swing.*;

public class StallLabel extends JLabel {

    public StallLabel(String text) {
        super(text);
        this.setFont(StallFonts.montserratMedium(14));
    }

}
