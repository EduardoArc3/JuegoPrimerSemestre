package objeto;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Al  extends superObjetos {
    public Al(){
        nombre = "Al";
        try {
            imagen = ImageIO.read(getClass().getResourceAsStream("/Images/objetos/Al13.png"));

        } catch (IOException e) {
            e.printStackTrace();

        }


    }

}