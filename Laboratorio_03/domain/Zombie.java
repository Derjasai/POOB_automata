package domain;

import java.awt.Color;
/**
 * La clase zombie es una celula especial correspondiente al ciclo4:Nueva celula
 * 
 * @author Ramos-Parra 
 * @version 17/03/2021
 */
public class Zombie extends Celula
{
    private AutomataCelular automata;
    /**
     * Constructor de la celula especial Zombie
     * @param Automata Celular
     * @parm fila
     * @param columna
     */
    public Zombie (AutomataCelular ac,int fila, int columna){
        super(ac,fila,columna);
        automata = ac;
        color = Color.black;
    }

    /**
     * Esta funcion ejecuta las caracteristicas especiales de la celula Zombie, poder infectar a sus cercanos y morira despues de 3 "turnos"
     */
    public void decida(){
        int fila = this.getFila();
        int columna = this.getColumma();
        for(int i = fila - 1; i < fila + 2; i++){
            for(int j = columna - 1; j < columna + 2; j++){
                if(i >= 0 && j >=0 && i < 30 && j<30 && (i != fila || j != columna) && automata.getElemento(i,j) != null ){
                    if(! (automata.getElemento(i,j) instanceof Zombie) && estado == Ser.VIVO && automata.getElemento(i,j) instanceof Celula){
                        this.edad = 0;
                        Zombie zombieMasivo = new Zombie(automata,i,j);
                        automata.setElemento(i,j,null);
                        automata.setElemento(i,j,zombieMasivo);
                    }
                }
            }
        }
        if (getEdad()>=3){
            estadoSiguiente=Ser.MUERTO;
        }  

    }
}
