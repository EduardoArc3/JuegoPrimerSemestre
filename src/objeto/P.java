package objeto;

import javax.imageio.ImageIO;
import java.io.IOException;

public class P extends superObjetos {
    public P() {
        nombre = "P";
        try {
            imagen = ImageIO.read(getClass().getResourceAsStream("/Images/objetos/P15.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}