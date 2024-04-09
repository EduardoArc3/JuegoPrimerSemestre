package main;

import entidad.Entidad;

public class ChecadorColisiones {
    Configuraciones configuraciones;
    public ChecadorColisiones (Configuraciones configuraciones){
        this.configuraciones = configuraciones;
    }
    public void checkSuelo(Entidad entidad){

        int entidadIzquierdaMundoX = entidad.mundoX + entidad.AreaSolida.x;
        int entidadDerechaMundoX   = entidad.mundoX + entidad.AreaSolida.x + entidad.AreaSolida.width;
        int entidadSuperiorMundoY  = entidad.mundoY + entidad.AreaSolida.y;
        int entidadInferiorMundoY  = entidad.mundoY + entidad.AreaSolida.y + entidad.AreaSolida.height;

        int entidadColumnaIzquierda= entidadIzquierdaMundoX/configuraciones.tamaño;
        int entidadColumnaDerecha  = entidadDerechaMundoX/configuraciones.tamaño;
        int entidadFilaSuperior    = entidadSuperiorMundoY/configuraciones.tamaño;
        int entidadFilaInferior    =entidadInferiorMundoY/configuraciones.tamaño;

        int suelo1 , suelo2;

        switch (entidad.direccion){
            case "Back":
                entidadFilaSuperior = (entidadSuperiorMundoY - entidad.vel)/configuraciones.tamaño;
                suelo1 = configuraciones.AS.mapTileNum[entidadColumnaIzquierda][entidadFilaSuperior];
                suelo2 = configuraciones.AS.mapTileNum[entidadColumnaDerecha][entidadFilaSuperior];
                if (configuraciones.AS.suelos[suelo1].colision == true || configuraciones.AS.suelos[suelo2].colision == true){
                    entidad.colisionOn = true;

                }
                break;
            case "Front":
                entidadFilaInferior = (entidadInferiorMundoY + entidad.vel)/configuraciones.tamaño;
                suelo1 = configuraciones.AS.mapTileNum[entidadColumnaIzquierda][entidadFilaInferior];
                suelo2 = configuraciones.AS.mapTileNum[entidadColumnaDerecha][entidadFilaInferior];
                if (configuraciones.AS.suelos[suelo1].colision == true || configuraciones.AS.suelos[suelo2].colision == true){
                    entidad.colisionOn = true;

                }
                break;
            case "Left":
                entidadColumnaIzquierda = (entidadIzquierdaMundoX - entidad.vel)/configuraciones.tamaño;
                suelo1 = configuraciones.AS.mapTileNum[entidadColumnaIzquierda][entidadFilaSuperior];
                suelo2 = configuraciones.AS.mapTileNum[entidadColumnaIzquierda][entidadFilaInferior];
                if (configuraciones.AS.suelos[suelo1].colision == true || configuraciones.AS.suelos[suelo2].colision == true){
                    entidad.colisionOn = true;

                }
                break;
            case "Right":
                entidadColumnaDerecha = (entidadDerechaMundoX + entidad.vel)/configuraciones.tamaño;
                suelo1 = configuraciones.AS.mapTileNum[entidadColumnaDerecha][entidadFilaSuperior];
                suelo2 = configuraciones.AS.mapTileNum[entidadColumnaDerecha][entidadFilaInferior];
                if (configuraciones.AS.suelos[suelo1].colision == true || configuraciones.AS.suelos[suelo2].colision == true){
                    entidad.colisionOn = true;

                }
                break;
        }

    }
    public int checkObject (Entidad entidad, boolean jugador){
        int index = 999;

        for (int i = 0; i <configuraciones.obj.length ; i++) {
            if (configuraciones.obj[i]!=null){
                entidad.AreaSolida.x = entidad.mundoX + entidad.AreaSolida.x;
                entidad.AreaSolida.y = entidad.mundoY + entidad.AreaSolida.y;
                configuraciones.obj[i].AreaSolida.x = configuraciones.obj[i].mundoX+configuraciones.obj[i].AreaSolida.x;
                configuraciones.obj[i].AreaSolida.y = configuraciones.obj[i].mundoY+configuraciones.obj[i].AreaSolida.y;

                switch (entidad.direccion){
                    case"Back":
                        entidad.AreaSolida.y -= entidad.vel;
                        if (entidad.AreaSolida.intersects(configuraciones.obj[i].AreaSolida)){
                            if (configuraciones.obj[i].colision == true){
                                entidad.colisionOn = true;
                            }
                            if (jugador == true){
                                index = i;
                            }

                        }
                        break;
                    case "Front":
                        entidad.AreaSolida.y += entidad.vel;
                        if (entidad.AreaSolida.intersects(configuraciones.obj[i].AreaSolida)){
                            if (configuraciones.obj[i].colision == true){
                                entidad.colisionOn = true;
                            }
                            if (jugador == true){
                                index = i;
                            }
                        }
                        break;
                    case "Left":
                        entidad.AreaSolida.x -= entidad.vel;
                        if (entidad.AreaSolida.intersects(configuraciones.obj[i].AreaSolida)){
                            if (configuraciones.obj[i].colision == true){
                                entidad.colisionOn = true;
                            }
                            if (jugador == true){
                                index = i;
                            }

                        }
                        break;
                    case "Right":
                        entidad.AreaSolida.x += entidad.vel;
                        if (entidad.AreaSolida.intersects(configuraciones.obj[i].AreaSolida)) {
                            if (configuraciones.obj[i].colision == true){
                                entidad.colisionOn = true;
                            }
                            if (jugador == true){
                                index = i;
                            }

                            break;
                        }
                }
                entidad.AreaSolida.x = entidad.AreaSolidaDefaultX;
                entidad.AreaSolida.y = entidad.AreaSolidaDefaultY;
                configuraciones.obj[i].AreaSolida.x = configuraciones.obj[i].AreaSolidaDefaultX;
                configuraciones.obj[i].AreaSolida.y = configuraciones.obj[i].AreaSolidaDefaultY;


            }

        }


        return index;
    }
}
