package objeto;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Mg  extends superObjetos {
    public Mg(){
        nombre = "Mg";
        try {
            imagen = ImageIO.read(getClass().getResourceAsStream("/Images/objetos/Mg12.png"));

        } catch (IOException e) {
            e.printStackTrace();

        }


    }

}