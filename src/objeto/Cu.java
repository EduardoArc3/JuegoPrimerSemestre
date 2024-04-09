package objeto;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Cu extends superObjetos {
    public Cu() {
        nombre = "Cu";
        try {
            imagen = ImageIO.read(getClass().getResourceAsStream("/Images/objetos/Cu29.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}