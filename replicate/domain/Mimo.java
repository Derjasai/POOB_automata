package domain;
import java.awt.Color;
import java.util.ArrayList;

/**
 * Write a description of class CellMimo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Mimo extends Cell{
    
    private AManufacturing am;
    
    public Mimo(AManufacturing am,int row, int column, boolean active){
        super(am, row, column, active);
        color = Color.ORANGE;
        this.am = am;
    }
    
    @Override
    public void decide(){
        int fila = this.getRow();
        int columna = this.getColumn();
        boolean noBreaks = true;
        for(int i = fila - 1; i < fila +2; i++){
            for(int j = columna -1; j < columna +2; j++){
                if(i >= 0 && j >=0 && i < am.getSize() && j<am.getSize() && (i != fila || j != columna) && am.getThing(i,j) != null && am.getThing(i,j) instanceof Cell){
                    if((i != fila -1 || j != columna-1) && noBreaks){
                        nextState = am.getThing(i,j).isActive() ? Artefact.ACTIVE: Artefact.INACTIVE;
                        noBreaks = false;
                    }
                }
            }
        }
        if(noBreaks){
            nextState = am.getThing(fila-1,columna-1).isActive() ? Artefact.ACTIVE: Artefact.INACTIVE;
        }
    }
}
