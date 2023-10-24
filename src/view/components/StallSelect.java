package view.components;

import view.style.StallFonts;

import javax.swing.*;

public class StallSelect extends JComboBox<String> {

    public StallSelect(String[] options) {
        super(options);
        this.setBackground(null);
        this.setFont(StallFonts.montserratMedium(14));
        
    }


    public StallSelect() {
        this(new String[]{});
    }


}
