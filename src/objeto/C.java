package objeto;

import javax.imageio.ImageIO;
import java.io.IOException;

public class C extends superObjetos {
    public  C(){
        nombre = "C";
        try {
            imagen = ImageIO.read(getClass().getResourceAsStream("/Images/objetos/C6.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}