package domain;

import java.awt.Color;
/**
 * Write a description of class Conway here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Conway extends Celula
{
    private AutomataCelular automata;
    public Conway (AutomataCelular ac,int fila, int columna){
        super(ac,fila,columna);
        automata = ac;
        color = Color.green;
    }
    
    public void decida(){
        
    }
}
