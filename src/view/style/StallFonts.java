package view.style;

import java.awt.*;
import java.io.InputStream;

public class StallFonts {

    private static String rootPath = "/view/assets/fonts/";

    public static Font importFont(String fontPath, float fontSize) {
        try {
            InputStream is = StallFonts.class.getResourceAsStream(fontPath);
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, is);
            return customFont.deriveFont(Font.PLAIN, fontSize);
        } catch (Exception e) {
            e.printStackTrace();
            // Retornar uma fonte padrão em caso de falha
            return new Font("Arial", Font.PLAIN, (int) fontSize);
        }
    }

    public static Font montserratRegular(float fontSize) {
        return importFont(rootPath + "Montserrat-Regular.ttf", fontSize);
    }

    public static Font montserratMedium(float fontSize) {
        return importFont(rootPath + "Montserrat-Medium.ttf", fontSize);
    }

    public static Font montserratBold(float fontSize) {
        return importFont(rootPath + "Montserrat-Bold.ttf", fontSize);
    }
}
