package objeto;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Li extends superObjetos {
    public Li() {
        nombre = "Li";
        try {
            imagen = ImageIO.read(getClass().getResourceAsStream("/Images/objetos/Li3.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}