package suelos;

import main.Configuraciones;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class AdministradorSuelos {
    Configuraciones configuraciones;
    public Suelos[] suelos;
    public int mapTileNum [][];

    public AdministradorSuelos(Configuraciones configuraciones){

        this.configuraciones=configuraciones;

        suelos = new Suelos[10];

        mapTileNum = new int[configuraciones.maxColMapita][configuraciones.maxFilaMapita];

        suelito();
        loadMap("/images/maps/salamanca.txt");



    }
    public void suelito(){

        try{
            //IMAGENES IMPLEMENTADAS
            suelos[0] = new Suelos();
            suelos[0].image= ImageIO.read(getClass().getResourceAsStream("/tiles/F3.png"));


            suelos[1] = new Suelos();
            suelos[1].image= ImageIO.read(getClass().getResourceAsStream("/tiles/Florecitauwu.png"));
            suelos[1].colision = true;


            suelos[2] = new Suelos();
            suelos[2].image= ImageIO.read(getClass().getResourceAsStream("/tiles/F1.png"));
            suelos[2].colision = false;

            suelos[3] = new Suelos();
            suelos[3].image= ImageIO.read(getClass().getResourceAsStream("/tiles/F2.png"));


            suelos[4] = new Suelos();
            suelos[4].image= ImageIO.read(getClass().getResourceAsStream("/tiles/D5.png"));
            suelos[4].colision = true;


            suelos[5] = new Suelos();
            suelos[5].image= ImageIO.read(getClass().getResourceAsStream("/tiles/D3.png"));


            suelos[6] = new Suelos();
            suelos[6].image= ImageIO.read(getClass().getResourceAsStream("/tiles/D3.png"));
            suelos[6].colision = true;

            suelos[7] = new Suelos();
            suelos[7].image= ImageIO.read(getClass().getResourceAsStream("/tiles/D4.png"));






        }catch (IOException e){
            e.printStackTrace();


        }

    }
    public void loadMap(String rutaArchivo){
        try {
            InputStream is = getClass().getResourceAsStream(rutaArchivo);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int fil = 0;

            while (col < configuraciones.maxColMapita && fil < configuraciones.maxFilaMapita){

                String line = br.readLine();

                while (col < configuraciones.maxColMapita){

                    String numbers[] = line.split(" ") ;

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][fil] = num;
                    col++;

                }
                if (col == configuraciones.maxColMapita){
                    col = 0;
                    fil++;
                }
            }
            br.close();


        }catch (Exception e){

        }
    }
    public void dibujar(Graphics2D ChacaChacaLaMachaca2){
        int worldCol =0;
        int worldFil =0;

        while (worldCol<configuraciones.maxColMapita && worldFil <configuraciones.maxFilaMapita){

            int tileNum = mapTileNum [worldCol][worldFil];

            int mundoX = worldCol * configuraciones.tamaño;
            int mundoY = worldFil * configuraciones.tamaño;
            int screenX = mundoX - configuraciones.jugador.mundoX+configuraciones.jugador.screenX;
            int screenY = mundoY - configuraciones.jugador.mundoY+configuraciones.jugador.screenY;

            if (mundoX + configuraciones.tamaño> configuraciones.jugador.mundoX - configuraciones.jugador.screenX &&
                    mundoX - configuraciones.tamaño < configuraciones.jugador.mundoX + configuraciones.jugador.screenX &&
                    mundoY + configuraciones.tamaño > configuraciones.jugador.screenY &&
                    mundoY - configuraciones.tamaño < configuraciones.jugador.mundoY + configuraciones.jugador.screenY){

                ChacaChacaLaMachaca2.drawImage(suelos[tileNum].image ,screenX , screenY ,configuraciones.tamaño,configuraciones.tamaño,null);

            }

            worldCol++;

            if (worldCol==configuraciones.maxColMapita){
                worldCol=0;
                worldFil++;

            }
        }





    }
}
