package objeto;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Co extends superObjetos {
    public Co(){
        nombre = "Co";
        try {
            imagen = ImageIO.read(getClass().getResourceAsStream("/Images/objetos/Co27.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}