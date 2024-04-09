package objeto;

import javax.imageio.ImageIO;
import java.io.IOException;

public class As extends superObjetos {
    public As(){
        nombre = "As";
        try {
            imagen = ImageIO.read(getClass().getResourceAsStream("/Images/objetos/As33.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}