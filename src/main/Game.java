package main;

import main.Configuraciones;

import javax.sound.sampled.LineUnavailableException;
import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.util.concurrent.Callable;

public class Game {
    public static void main(String[] args) throws LineUnavailableException {

        // Crear la ventana
        JFrame ventana = new JFrame();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setTitle("After the journey");

        Configuraciones configuraciones = new Configuraciones();
        ventana.add(configuraciones);

        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        configuraciones.setupGame();
        configuraciones.startgameThread();

        ImageIcon img= new ImageIcon("src/Images/player/Personaje_Front.png");
        ventana.setIconImage(img.getImage());





    }
}
