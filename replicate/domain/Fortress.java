package domain;

import java.awt.Color;
/**
 * La clase fortaleza corresponde al ciclo5 del laboratorio: Crear un nuevo elemnto, es un elemento relacionado con la celula especial zombie, este elemnto
 * mata (cambia el atributo isVivo) todos los zombies 
 * 
 * @author Ramos-Parra
 * @version 16/03/2021
 */
public class Fortress implements Thing
{
    protected Color color;
    private AManufacturing am;
    private int row,columna;

    /**
     * Constructor de la clase fortaleza
     * @param Automata Celular
     * @param Fila
     * @param Columna
     */
    public Fortress(AManufacturing am,int row, int columna, boolean active){
        this.am=am;
        this.row=row;
        this.columna=columna;
        color = Color.cyan;
        am.setThing(row,columna,(Thing)this);
    }
    
    /**
     * Retorna la shape de la fortaleza en forma de entero
     * @return Numero entero
     */
    public int shape(){
        return Thing.ROUND;   
    }
    
    /**
     * Retorna el color actual de la fortaleza
     * @return color de la fortaleza
     */
    public Color getColor(){
        return color;
    }
    
    @Override
    public void decide(){
        for(int i = row - 2; i < row + 3; i++){
            for(int j = columna - 2; j < columna + 3; j++){   
                if(i >= 0 && j >=0 && i < am.getSize() && j<am.getSize() && (i != row || j != columna)){
                    if(am.getThing(i,j) instanceof Zombie){
                            ((Zombie)am.getThing(i,j)).nextState = Artefact.INACTIVE;
                    }
                }
            }
        }
    }

    /**
     * La fortaleza siempre esta activa
     * @return Estado de la fortaleza (activa o inactiva)
     */
    public boolean isActive(){
        return true;
    }
}
