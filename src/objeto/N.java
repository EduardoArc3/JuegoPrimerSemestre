package objeto;

import javax.imageio.ImageIO;
import java.io.IOException;

public class N  extends superObjetos {
    public N(){
        nombre = "N";
        try {
            imagen = ImageIO.read(getClass().getResourceAsStream("/Images/objetos/N7.png"));

        } catch (IOException e) {
            e.printStackTrace();

        }


    }

}