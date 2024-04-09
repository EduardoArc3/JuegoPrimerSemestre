package objeto;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Ca extends superObjetos {

    public Ca(){
        nombre = "Ca";
        try {
            imagen = ImageIO.read(getClass().getResourceAsStream("/Images/objetos/20.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}