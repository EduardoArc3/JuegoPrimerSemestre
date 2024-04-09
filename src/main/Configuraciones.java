package main;

import entidad.Jugador;
import suelos.AdministradorSuelos;
import objeto.superObjetos;

import javax.swing.*;
import java.awt.*;

public class Configuraciones extends JPanel implements Runnable {
    // main.Configuraciones de la pantalla

    /* Esto lo cambiaremos despues cuando estemos testeando el juego */
    final int tamañoCuadricula = 80; // 64*64 (tamaño de cada cuadricula en pixeles)
    final int escala = 1;
    public int tamaño = tamañoCuadricula * escala;

    public final int MaxCol = 16; // Maximas columnas en la pantalla
    public final int MaxFila = 12; // Fila maxima

    public final int anchoPantalla = tamaño * MaxCol;
    public final int alturaPantalla = tamaño * MaxFila;

    //CONFIGURACIONES DEL MUNDITO
    public final int maxColMapita = 50;
    public final int maxFilaMapita = 50;
    public final int mapaAncho = tamaño * maxColMapita;
    public final int mapaAltura = tamaño * maxFilaMapita;

    int FPS = 60;
    public UI ui = new UI(this);
    AdministradorSuelos AS = new AdministradorSuelos(this);

    Controles c = new Controles();
    Thread gameThread;
    public ChecadorColisiones ChecC = new ChecadorColisiones(this);
    // el thread=hilo permite que se realicen varias operaciones/tareas en el mismo
    // proceso.
    // crea un reloj/cronometraje en el juego lo que nos permite darle un orden a
    // los procesos como las animaciones.
    public lugarobj lugarO = new lugarobj(this);
    public Jugador jugador = new Jugador(this, c);


    // posicion inicial del personaje


    // el 4 es la velocidad a la que irá el personaje, que serían 4 pixeles ajustándolo a la velocidad que puede haber
    // en el panel

    public superObjetos obj[] = new superObjetos[17];

    public int gameState;
    public final int playState = 1;
    public final int pauseState = 2;

    public Configuraciones() {
        // vamos a establecer el tamaño del panel

        this.setPreferredSize(new Dimension(anchoPantalla, alturaPantalla));
        this.setBackground(Color.darkGray);
        this.setDoubleBuffered(true); // debe establecerse en verdadero.
        this.addKeyListener(c);
        this.setFocusable(true);
    }

    public void setupGame() {

        lugarO.posObjeto();
        gameState = playState;
    }

    public void startgameThread() {
        gameThread = new Thread(this);
        // el this es la class configuraciones, está pasando por el thread.
        gameThread.start();
    }

    // El contrato general del método run es que puede realizar cualquier acción.
    // podemos ejecutar dos o mas procesos al mismo tiempo, sin tener que esperar a
    // que finalice un proceso

    @Override
    public void run() {

        double Intervalo = 1000000000 / FPS; // 0.01666 segundos
        double delta = 0;
        long Tiempo = System.nanoTime();
        long currentTime;
        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - Tiempo) / Intervalo;

            Tiempo = currentTime;

            if (delta >= 1) {
                actualizaciones();
                repaint();
                delta--;

                // se debe crear una restricción en el loop  que creamos con el hilo para que los procesos que le asignamos
                //  no se repita infinitamente sin parar, para que nuestro objeto creado que se moverá en el panel, no
                // desaparezca del panel/frame, debido a la velocidad a la que iba por la cantidad de veces que el proceso
                // sin restricciones logra repetirse.
                // para esto, se necesita saber qué hora es en el momento  y cuánto tiempo ha pasado desde que se actualizó
                //la información de la posición del jugador y el momento en que apareción en el panel la información actualizada.
            }


            // este while indica que mientras exista el hilo, se repetirá lo del sout.
            // si funciona, el juego será capaz de ir actualizando información como la
            // posición del jugador
            // o información general como la puntuación.

        }
    }

    // En el panel, la coordenada (0,0) es la esquina superior izquierda del panel/frame, el valor de X incrementa al
    // moverse a la derecha y el valor de Y aumenta al ir hacia abajo.
    public void actualizaciones() {

        jugador.actualizaciones();
        if (gameState == playState) {
            jugador.actualizaciones();
        }
        if (gameState == pauseState) {

        }
    }

    //para dibujar en el panel
    public void paintComponent(Graphics ChacaChacaLaMachaca) {

        super.paintComponent(ChacaChacaLaMachaca);

        Graphics2D ChacaChacaLaMachaca2 = (Graphics2D) ChacaChacaLaMachaca;
        // La clase Graphics2D funciona como una extension mas sofisticada "perfecta para juegos 2D"
        // esta clase sirve para mejor control sobre lo dibujado en el panel.
        ui.dibujar(ChacaChacaLaMachaca2);
        AS.dibujar(ChacaChacaLaMachaca2);

        //Objeto
        for (int i = 0; i < obj.length; i++) {
            if (obj[i] != null) {
                obj[i].dibujar(ChacaChacaLaMachaca2, this);
            }
        }
        ui.dibujar(ChacaChacaLaMachaca2);
        jugador.dibujar(ChacaChacaLaMachaca2);

        ChacaChacaLaMachaca2.dispose();
        //dispose sirve para utilizar la informacion que metimos en el graphics y que se utilice
        // todo esto es para dibujar un cuadrado en el panel, que utilizaremos como personaje
        // en lo que programamos botones
    }
}