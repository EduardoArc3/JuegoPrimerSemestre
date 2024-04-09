package objeto;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Be extends superObjetos {
    public Be(){
        nombre = "Be";
        try {
            imagen = ImageIO.read(getClass().getResourceAsStream("/Images/objetos/Be4.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}