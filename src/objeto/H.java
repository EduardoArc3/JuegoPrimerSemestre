package objeto;

import javax.imageio.ImageIO;
import java.io.IOException;

public class H extends superObjetos {
    public H() {
        nombre = "H";
        try {
            imagen = ImageIO.read(getClass().getResourceAsStream("/Images/objetos/H1.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}