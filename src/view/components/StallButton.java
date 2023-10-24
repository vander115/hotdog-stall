package view.components;

import view.style.StallFonts;

import javax.swing.*;

public class StallButton extends JButton {

    public StallButton(String text) {
        super(text);

        this.setFont(StallFonts.montserratBold(14));


    }
}
