/* Credits to ChatGPT

   This file is used to import and apply fonts that are not
   available in Java

*/

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class FontManager {

    private Font headingFont;
    private Font textFont;

    public FontManager() {
        loadFonts();
    }

    private void loadFonts() {
        try {
            // Load MyFont
            InputStream myFontStream = getClass().getResourceAsStream("/font/TT Ricordi Greto Trial DemiBold.ttf");
            headingFont = Font.createFont(Font.TRUETYPE_FONT, myFontStream);

            // Load AnotherFont
            InputStream anotherFontStream = getClass().getResourceAsStream("/font/Golden Lights.ttf");
            textFont = Font.createFont(Font.TRUETYPE_FONT, anotherFontStream);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
    }

    public Font getHeadingFont() {
        return headingFont;
    }

    public Font getTextFont() {
        return textFont;
    }

}
