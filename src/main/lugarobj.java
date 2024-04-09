package main;

import objeto.*;

public class lugarobj {
    Configuraciones configuraciones;
    public lugarobj(Configuraciones configuraciones){
        this.configuraciones = configuraciones;
    }
    public void posObjeto(){
        configuraciones.obj[0] = new Ca();
        configuraciones.obj[0].mundoX = 23 * configuraciones.tamaño;
        configuraciones.obj[0].mundoY = 7 * configuraciones.tamaño;

        configuraciones.obj[1]= new Al();
        configuraciones.obj[1].mundoX = 26 * configuraciones.tamaño;
        configuraciones.obj[1].mundoY = 38 * configuraciones.tamaño;

        configuraciones.obj[2]= new As();
        configuraciones.obj[2].mundoX = 19 * configuraciones.tamaño;
        configuraciones.obj[2].mundoY = 36 * configuraciones.tamaño;

        configuraciones.obj[3]= new Be();
        configuraciones.obj[3].mundoX = 19 * configuraciones.tamaño;
        configuraciones.obj[3].mundoY = 41 * configuraciones.tamaño;

        configuraciones.obj[4]= new C();
        configuraciones.obj[4].mundoX = 14 * configuraciones.tamaño;
        configuraciones.obj[4].mundoY = 34 * configuraciones.tamaño;

        configuraciones.obj[5]= new Co();
        configuraciones.obj[5].mundoX = 10 * configuraciones.tamaño;
        configuraciones.obj[5].mundoY = 31 * configuraciones.tamaño;

        configuraciones.obj[6]= new Mn();
        configuraciones.obj[6].mundoX = 31 * configuraciones.tamaño;
        configuraciones.obj[6].mundoY = 15 * configuraciones.tamaño;

        configuraciones.obj[7]= new Cu();
        configuraciones.obj[7].mundoX = 40 * configuraciones.tamaño;
        configuraciones.obj[7].mundoY = 12 * configuraciones.tamaño;

        configuraciones.obj[8]= new Fe();
        configuraciones.obj[8].mundoX = 10 * configuraciones.tamaño;
        configuraciones.obj[8].mundoY = 7 * configuraciones.tamaño;

        configuraciones.obj[9]= new K();
        configuraciones.obj[9].mundoX = 11 * configuraciones.tamaño;
        configuraciones.obj[9].mundoY = 10 * configuraciones.tamaño;

        configuraciones.obj[10]= new Mg();
        configuraciones.obj[10].mundoX = 15 * configuraciones.tamaño;
        configuraciones.obj[10].mundoY = 47 * configuraciones.tamaño;

        configuraciones.obj[11]= new N();
        configuraciones.obj[11].mundoX = 37 * configuraciones.tamaño;
        configuraciones.obj[11].mundoY = 43 * configuraciones.tamaño;

        configuraciones.obj[12]= new Li();
        configuraciones.obj[12].mundoX = 20 * configuraciones.tamaño;
        configuraciones.obj[12].mundoY = 28 * configuraciones.tamaño;

        configuraciones.obj[13]= new Cr();
        configuraciones.obj[13].mundoX = 32 * configuraciones.tamaño;
        configuraciones.obj[13].mundoY = 38 * configuraciones.tamaño;

        configuraciones.obj[14]= new P();
        configuraciones.obj[14].mundoX = 36 * configuraciones.tamaño;
        configuraciones.obj[14].mundoY = 31 * configuraciones.tamaño;

        configuraciones.obj[15]= new H();
        configuraciones.obj[15].mundoX = 38 * configuraciones.tamaño;
        configuraciones.obj[15].mundoY = 8 * configuraciones.tamaño;
    }
}
