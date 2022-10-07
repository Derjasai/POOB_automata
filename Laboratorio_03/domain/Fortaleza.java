




package domain;

import java.awt.Color;
/**
 * La clase fortaleza corresponde al ciclo5 del laboratorio: Crear un nuevo elemnto, es un elemento relacionado con la celula especial zombie, este elemnto
 * mata (cambia el atributo isVivo) todos los zombies 
 * 
 * @author Ramos-Parra
 * @version 16/03/2021
 */
public class Fortaleza implements Elemento
{
    protected Color color;
    private AutomataCelular automata;
    private int fila,columna;

    /**
     * Constructor de la clase fortaleza
     * @param Automata Celular
     * @param Fila
     * @param Columna
     */
    public Fortaleza(AutomataCelular ac,int fila, int columna){
        automata=ac;
        this.fila=fila;
        this.columna=columna;
        color = Color.cyan;
        automata.setElemento(fila,columna,(Elemento)this);
    }
    
    /**
     * Retorna la forma del elemento como entero 
     * @return Numero entero dependiendo si es cuadrada o no
     */
    public int forma(){
        return CUADRADA;   
    }
    
    /**
     * Retorna el color actual de la fortaleza
     * @return color de la fortaleza
     */
    public Color getColor(){
        return color;
    }

    /**
     * Funcion que mata(cambia el estado de ser) los zombies cercanos
     */
    public void cambie(){
        for(int i = fila - 2; i < fila + 3; i++){
            for(int j = columna - 2; j < columna + 3; j++){   
                if(i >= 0 && j >=0 && i < 30 && j<30 && (i != fila || j != columna)){
                    if(automata.getElemento(i,j) instanceof Zombie){
                            ((Zombie)automata.getElemento(i,j)).estadoSiguiente=Ser.MUERTO;
                    }
                }
            }
        }
    }

    /**
     * retorna si la fortaleza esta viva (al ser un elemnto siempre esta vivo)
     * @return Estado de la fortaleza (viva o muerta)
     */
    public boolean isVivo(){
        return true;
    }
}
