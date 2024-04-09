package entidad;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entidad {
    public int mundoX,mundoY;
    public int vel;
    public BufferedImage Back, Front, Left, Right;
    // BufferedImage se usa para mantener una representación de una imagen en memoria dentro de una aplicación Java, de modo
    // que la puedes modificar o guardar en cualquiera de los formatos estándar propios de imágenes.
    public String direccion;
    public Rectangle AreaSolida;

    public int AreaSolidaDefaultX, AreaSolidaDefaultY;
    public boolean colisionOn = false;


}
