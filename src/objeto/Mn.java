package objeto;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Mn  extends superObjetos {
    public Mn(){
        nombre = "Mn";
        try {
            imagen = ImageIO.read(getClass().getResourceAsStream("/Images/objetos/Mn25.png"));

        } catch (IOException e) {
            e.printStackTrace();

        }


    }

}