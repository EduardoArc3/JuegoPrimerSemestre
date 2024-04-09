package objeto;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Fe extends superObjetos {
    public Fe() {
        nombre = "Fe";
        try {
            imagen = ImageIO.read(getClass().getResourceAsStream("/Images/objetos/Fe26.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}