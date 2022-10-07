
package domain;

import java.awt.Color;
/**
 * La clase calefactor es un elemnto solicitado en el laboratorio, sus caracteristicas especiales ademas de ser un elemento este cambia de color con cada
 * turno que pasa de amarillo a rojo
 * 
 * @author Ramos-Parra
 * @version 17/03/2021
 */
public class Calefactor implements Elemento 
{
    protected Color color;
    private AutomataCelular automata;
    private int fila,columna;

    /**
     * Constructor de la clase calefactor
     * @param Automata celular
     * @param fila
     * @param columna
     */
    public Calefactor(AutomataCelular ac,int fila, int columna){
        automata=ac;
        this.fila=fila;
        this.columna=columna;
        color = Color.red;
        automata.setElemento(fila,columna,(Elemento)this);
    }

    /**
     * La forma que tiene el calefactor(por ser un elemento este es cuadrado)
     * @return Cuadrada(la forma del calefactor)
     */
    public int forma(){
        return CUADRADA;   
    }
    
    /**
     * Retorna el color actual del calefactor
     * @return Color del calefactor
     */
    public Color getColor(){
        return color;
    }
    
    /**
     * Con esta funcion cambiamos el color del calefactor cada turno
     */
    public void cambie(){
        if(this.color.equals(Color.red)){
            color = Color.yellow;
        }
        else{
            color = Color.red;
        }
    }
    
    /**
     * Retorna si el calfactor esta "vivo", ya que los elemntos no mueren la respuesta es true
     * @return si el elemento esta vivo o no
     */
    public boolean isVivo(){
        return true;
    }
}
