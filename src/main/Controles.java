package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controles implements KeyListener {

    public boolean Arriba, Abajo, Izquierda, Derecha;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            Arriba = true;
        }
        if (code == KeyEvent.VK_S) {
            Abajo = true;
        }
        if (code == KeyEvent.VK_A) {
            Izquierda = true;
        }
        if (code == KeyEvent.VK_D) {
            Derecha = true;

            // el keyPressed sirve para al momento de aplastar la tecla comience a haber movimiento.
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            Arriba = false;
        }
        if (code == KeyEvent.VK_S) {
            Abajo = false;
        }
        if (code == KeyEvent.VK_A) {
            Izquierda = false;
        }
        if (code == KeyEvent.VK_D) {
            Derecha = false;

            // el keyReleased sirve para al momento de soltar la tecla deje de haber movimiento.
        }
    }
}