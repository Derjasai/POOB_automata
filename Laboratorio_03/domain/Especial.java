package domain;

import java.awt.Color;
/**
 * Celula solicitada para el ciclo4: Nueva Celula
 * 
 * Daniel Ramos - Andres Parra
 * @version 17/03/2021
 */
public class Especial extends Celula
{
    private AutomataCelular automata;
    /**
     * Constructo de la casle especial
     * @param: automataCelular automata celular en donde se encuentra la celula
     * @param: fila posicion de la celula
     * @param: columna posicion de la celula
     */
    public Especial (AutomataCelular ac,int fila, int columna){
        super(ac,fila,columna);
        automata = ac;
        color = Color.green;
    }

    /**
     * Esta funcion revisa los alrededores e identifica si la celula tiene que morir
     */
    private void todosMuertos(){
        int fila = this.getFila();
        int columna = this.getColumma();
        boolean var = true;
        boolean ningunoNull = true;

        for(int i = fila - 1; i < fila + 2; i++){
            for(int j = columna - 1; j < columna + 2; j++){   
                if(i >= 0 && j >=0 && i < 30 && j<30 && (i != fila || j != columna)){
                    if(automata.getElemento(i,j) != null ){
                        if(automata.getElemento(i,j).isVivo()){
                            var = var && false;
                        }
                    }
                    else{
                        ningunoNull = ningunoNull && false;
                    }
                }
            }
        }
        if(var && ningunoNull){estadoSiguiente = Ser.MUERTO;}
    }

    /**
     * permite saber si es necesaria añadir una celula alrededor
     * @param fila posicion de la celula
     * @param columna posicion de la celula
     */
    private boolean añadir(int fila, int columna){
        boolean añadir = true; 
        for(int i = fila - 1; i < fila + 2; i++){
            for(int j = columna - 1; j < columna + 2; j++){
                if(i >= 0 && j >=0 && i < 30 && j<30 && (i != fila || j != columna)){
                    if(automata.getElemento(i,j) != null ){
                        if(automata.getElemento(i,j).isVivo()){
                            añadir = añadir && false;
                        }
                    }
                }
            }
        }
        return añadir;
    }

    /**
     * decide la primera posicion posible donde crear una nueva celula
     * @param fila posicion de la celula
     * @param columna posicion de la celula 
     */
    private void nacer(int fila, int columna){
        boolean verif;
        for(int i = fila - 1; i < fila + 2; i++){
            verif = false;
            for(int j = columna - 1; j < columna + 2; j++){
                if(i >= 0 && j >=0 && i < 30 && j<30 && (i != fila || j != columna)){
                    if(automata.getElemento(i,j) == null){
                        Celula celula = new Celula(automata,i,j);
                        automata.setElemento(i,j,celula);
                        verif = true;
                        break;
                    }
                }
            }
            if(verif){break;} 
        }
    }

    /**
     * decide cual es el estado de la celula
     */
    public void decida(){
        int fila = this.getFila();
        int columna = this.getColumma();
        boolean añadir = añadir(fila, columna);

        todosMuertos();

        if(añadir && estadoSiguiente != Ser.MUERTO){
            nacer(fila, columna);
        }
    }
}
