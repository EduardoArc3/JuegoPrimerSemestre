package entidad;

import main.Configuraciones;
import main.Controles;
import main.Pregunta;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Jugador extends Entidad   {

    Configuraciones configuraciones;
    Controles c;

    public final int screenX;
    public final int screenY;

    public int contador;






    public Jugador(Configuraciones configuraciones, Controles c) {

        this.configuraciones = configuraciones;
        this.c = c;

        //Esto es para el el personaje aparezca centrado en la pantalla
        screenX = configuraciones.anchoPantalla/2 - (configuraciones.tamaño/2);
        screenY = configuraciones.alturaPantalla/2- (configuraciones.tamaño/2);
        AreaSolida = new Rectangle();
        AreaSolida.x = 8;
        AreaSolida.y = 16;
        AreaSolidaDefaultX = AreaSolida.x;
        AreaSolidaDefaultY = AreaSolida.y;
        AreaSolida.width = 32;
        AreaSolida.height =32;

        valoresIni();
        getJugadorImag();
    }

    public void valoresIni() {

        mundoX = configuraciones.tamaño*23;
        mundoY = configuraciones.tamaño*21;
        vel = 2;
        direccion = "Front";

    }
    public void getJugadorImag() {
        try {
            Front = ImageIO.read(getClass().getResourceAsStream("/Images/player/Personaje_Front.png"));
            Back = ImageIO.read(getClass().getResourceAsStream("/Images/player/Personaje_Back.png"));
            Left = ImageIO.read(getClass().getResourceAsStream("/Images/player/Personaje_Left.png"));
            Right = ImageIO.read(getClass().getResourceAsStream("/Images/player/Personaje_Right.png"));

        }catch (IOException e ){
            e.printStackTrace();
        }

    }

    public void actualizaciones () {
        if (c.Arriba == true || c.Abajo == true || c.Izquierda == true || c.Derecha == true) {


            if (c.Arriba == true) {
                direccion = "Back";

                // Y es -= porque se restarán 4 pixeles (4 por el valor de la velocidad) a la posición del jugador/personaje
                // al ir hacia Arriba porque entre más alto se esté en el panel, el valor de Y es menor por lo que expliqué
                // en el comentario anterior.
            } else if (c.Abajo == true) {
                direccion = "Front";

                // Y es += porque se suman 4 pixeles a la posición del jugador  al ir hacia abajo debido a que el valor de Y
                // aumenta en el panel al ir hacia abajo.
            } else if (c.Izquierda == true) {
                direccion = "Left";


                // X es -= porque se restan 4 pixeles a la posición del jugador al ir hacia la izquierda debido a que en el
                // panel, entre más a la izquierda se acerque el eje, más cerca a 0 se está y por eso se resta.
            } else if (c.Derecha == true) {
                direccion = "Right";

                //X es += porque se suman 4 pixeles a la posición del jugador al ir hacia la derecha porque el valor en X
                // en el panel aumenta al ir hacia la derecha.
            }
            //Compruebe la colisión de suelos
            colisionOn = false;
            configuraciones.ChecC.checkSuelo(this);

            int objIndex = configuraciones.ChecC.checkObject(this,true);
            RecogerObjeto(objIndex);
            //Si la colisión es falsa, el jugador puede moverse.
            if (colisionOn == false) {

                switch (direccion) {
                    case "Back":
                        mundoY -= vel;
                        break;
                    case "Front":
                        mundoY += vel;
                        break;
                    case "Left":
                        mundoX -= vel;
                        break;
                    case "Right":
                        mundoX += vel;
                        break;

                }
            }

        }
    }

    JFrame vWin = new JFrame();
    JLabel etiqueta = new JLabel("Ganaste");

    public void win(){
        vWin.setVisible(true);
        vWin.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        vWin.setBounds(300,300,40,70);
        vWin.setLocationRelativeTo(null);{
            vWin.setBackground(Color.black);

            vWin.add(etiqueta);
        }

    }

    //Elegí 999 pero básicamente cualquier número está bien siempre que no sea utilizado por el índice de la matriz de objetos.
    public void RecogerObjeto (int i) {
        if (i != 999){
            // Crear objeto de la clase pregunta para usar sus metodos
            Pregunta objQ = new Pregunta();

            if(configuraciones.obj[i]==null) throw new IllegalArgumentException("array is null");

            if (objQ.comprobar(i) == true) {

                try {
                    configuraciones.obj[i]= null;
                } catch (Exception e) {
                    // TODO: handle exception
                }
                contador++;
                if (contador == 10){
                    System.out.println("Ganaste");
                    win();
                }

            }
            else {
                RecogerObjeto(i);
            }


        }

    }
    public void dibujar (Graphics2D ChacaChacaLaMachaca2){

        // ChacaChacaLaMachaca2.setColor(Color.WHITE);
        // genera el color del primer atributo del juego
        // ChacaChacaLaMachaca2.fillRect(x, y, configuraciones.tamaño, configuraciones.tamaño);
        // se usa el tamaño que establecimos al principio como ancho y largo porque estamos
        // intentando que el personaje sea a escala

        BufferedImage image = null;

        switch (direccion) {
            case "Back":
                image = Back;
                break;
            case "Front":
                image = Front;
                break;
            case "Left":
                image = Left;
                break;
            case "Right":
                image = Right;
                break;
        }

        ChacaChacaLaMachaca2.drawImage(image, screenX, screenY, configuraciones.tamaño, configuraciones.tamaño, null);



    }
}

