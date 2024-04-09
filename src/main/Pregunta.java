package main;

import javax.swing.*;
import java.util.Objects;

public class Pregunta {
    String comparador;
    String entrada;
    boolean bol;
    int IDitem;


    // True = Continua / False = Repetir metodo

    public boolean comprobar(int _IDitem){



        //String comparador;
        boolean resultado = framePregunta(_IDitem);

        return resultado;
    }


    public boolean framePregunta(int _IDitem1){
        entrada = JOptionPane.showInputDialog("Escribe el nombre del elemento:");
        //Comparacion
        if (Objects.equals(entrada, getName(_IDitem1))){
            bol = true;
        }else{
            bol = false;
        }
        return bol;
    }

    String Arreglo[] = new String[118];
    Configuraciones configuraciones;
    public String getName(int _IDitem2){
        Arreglo[0]="Calcio";
        Arreglo[1]="Aluminio";
        Arreglo[2]="Arsenico";
        Arreglo[3]="Berilio";
        Arreglo[4]="Carbono";
        Arreglo[5]="Cobalto";
        Arreglo[6]="Manganeso";
        Arreglo[7]="Cobre";
        Arreglo[8]="Hierro";
        Arreglo[9]="Potasio";
        Arreglo[10]="Magnesio";
        Arreglo[11]="Nitrogeno";
        Arreglo[12]="Litio";
        Arreglo[13]="Cromo";
        Arreglo[14]="Fosforo";
        Arreglo[15]="Hidrogeno";
        Arreglo[16]="";
        Arreglo[17]="";
        Arreglo[18]="";
        return Arreglo[_IDitem2];
    }


}
