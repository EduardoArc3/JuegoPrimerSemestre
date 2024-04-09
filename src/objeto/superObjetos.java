package objeto;

import java.awt.*;
import java.awt.image.BufferedImage;

import main.Configuraciones;

public class superObjetos {

    public BufferedImage imagen;
    public String nombre;
    public boolean colision = false;
    public int mundoX, mundoY;
    public Rectangle AreaSolida = new Rectangle(0,0,48,48);
    public int AreaSolidaDefaultX = 0;
    public int AreaSolidaDefaultY = 0;

    public void dibujar (Graphics2D ChacaChacaLaMachaca2, Configuraciones configuraciones) {

        int screenX = mundoX - configuraciones.jugador.mundoX + configuraciones.jugador.screenX;
        int screenY = mundoY - configuraciones.jugador.mundoY + configuraciones.jugador.screenY;

        if (mundoX + configuraciones.tamaño > configuraciones.jugador.mundoX - configuraciones.jugador.screenX &&
                mundoX - configuraciones.tamaño < configuraciones.jugador.mundoX + configuraciones.jugador.screenX &&
                mundoY + configuraciones.tamaño > configuraciones.jugador.screenY &&
                mundoY - configuraciones.tamaño < configuraciones.jugador.mundoY + configuraciones.jugador.screenY) {

            ChacaChacaLaMachaca2.drawImage(imagen, screenX, screenY, configuraciones.tamaño, configuraciones.tamaño, null);

        }

    }
}
