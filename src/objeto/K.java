package objeto;

import javax.imageio.ImageIO;
import java.io.IOException;

public class K extends superObjetos {
    public K() {
        nombre = "K";
        try {
            imagen = ImageIO.read(getClass().getResourceAsStream("/Images/objetos/K19.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}