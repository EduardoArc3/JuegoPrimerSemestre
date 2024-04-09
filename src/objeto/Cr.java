package objeto;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Cr extends superObjetos {
    public Cr(){
        nombre = "Cr";
        try {
            imagen = ImageIO.read(getClass().getResourceAsStream("/Images/objetos/Cr24.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}