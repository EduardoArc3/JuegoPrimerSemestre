package main;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.sql.Time;
import java.util.concurrent.Callable;

public class UI {
    Configuraciones configuraciones;
    Graphics2D ChacaChacaLaMachaca2;
    Font TimesRoman_20;
    public int comandoNum = 0;


    public UI(Configuraciones configuraciones){
        this.configuraciones = configuraciones;

        TimesRoman_20 = new Font("TimesRoman", Font.PLAIN,20);
    }

    public void dibujar(Graphics2D ChacaChacaLaMachaca2) {
        this.ChacaChacaLaMachaca2 = ChacaChacaLaMachaca2;

        ChacaChacaLaMachaca2.setFont(new Font("TimesRoman", Font.PLAIN, 20));

        ChacaChacaLaMachaca2.setFont(TimesRoman_20);
        ChacaChacaLaMachaca2.setColor(Color.white);
        ChacaChacaLaMachaca2.drawString("Elementos = "+ configuraciones.jugador.contador, 25, 50);


        }


    }
