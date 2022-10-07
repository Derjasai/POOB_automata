package domain;
import java.awt.Color;
import java.util.ArrayList;

/**
 * Write a description of class CellKriptonita here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Kriptonita extends Artefact implements Thing{
    protected char nextState;
    protected Color color;
    private AManufacturing am;
    private int row,column;
    
    public Kriptonita(AManufacturing am,int row, int column, boolean active){
        this.am=am;
        this.row=row;
        this.column=column;
        state=(active ? Artefact.ACTIVE: Artefact.INACTIVE);
        nextState=(active ? Artefact.ACTIVE: Artefact.INACTIVE);
        am.setThing(row,column,(Thing)this);    
        color=Color.GREEN;
    }
    
    @Override
    public void decide(){
        if(am.neighborsActive(row, column) >= 1){
            nextState = Artefact.ACTIVE;
            for(int i = row - 1; i < row +2; i++){
                for(int j = column -1; j < column +2; j++){
                    if(i >= 0 && j >=0 && i < am.getSize() && j<am.getSize() && (i != row || j != column) && am.getThing(i,j) == null){
                        Kriptonita newKriptonita = new Kriptonita(am,i,j,false);
                    }
                }
            }
        }else{
            nextState = Artefact.INACTIVE;
        }
    }
    
    public final Color getColor(){
        return color;
    }
    
    public void change(){
        step();
        state=nextState;
    }
    
    @Override
    public int shape(){
        return Thing.ROUND;
    }
}
