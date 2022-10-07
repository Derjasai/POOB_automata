package domain;

import java.awt.Color;
/**
 * La clase zombie es una Cell especial correspondiente al ciclo4:Nueva Cell
 * 
 * @author Ramos-Parra 
 * @version 17/03/2021
 */
public class Zombie extends Cell
{
    private AManufacturing am;
    /**
     * Constructor de la Cell especial Zombie
     * @param Automata Cellr
     * @parm fila
     * @param columna
     */
    public Zombie (AManufacturing am,int row, int column, boolean active){
        super(am, row, column, active);
        this.am = am;
        color = Color.RED;
    }

    /**
     * Esta funcion ejecuta las caracteristicas especiales de la Cell Zombie, poder infectar a sus cercanos y morira despues de 3 "turnos"
     */
    public void decide(){
        int fila = this.getRow();
        int columna = this.getColumn();
        for(int i = fila - 1; i < fila + 2; i++){
            for(int j = columna - 1; j < columna + 2; j++){
                if(i >= 0 && j >=0 && i < 30 && j<30 && (i != fila || j != columna) && am.getThing(i,j) != null ){
                    if(! (am.getThing(i,j) instanceof Zombie) && nextState == Artefact.ACTIVE && am.getThing(i,j) instanceof Cell){
                        this.steps = 0;
                        Zombie zombieMasivo = new Zombie(am,i,j,true);
                        am.setThing(i,j,null);
                        am.setThing(i,j,zombieMasivo);
                    }
                }
            }
        }
        if (getSteps()>=3){
            nextState=Artefact.INACTIVE;
        }  

    }
}
