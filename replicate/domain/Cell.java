package domain;

import java.awt.Color;
import java.util.ArrayList;

/**Information about a cell<br>
<b>(am,row,column,age,state,nextState, color)</b><br>
<br>
 */
public class Cell extends Artefact implements Thing{
    protected char nextState;
    protected Color color;
    private AManufacturing am;
    private int row,column;

    /**Create a new cell (<b>row,column</b>) in the am <b>ac</b>..
     * @param am 
     * @param row 
     * @param column 
     * @param active
     */
    public Cell(AManufacturing am,int row, int column, boolean active){
        this.am=am;
        this.row=row;
        this.column=column;
        state=(active ? Artefact.ACTIVE: Artefact.INACTIVE);
        nextState=(active ? Artefact.ACTIVE: Artefact.INACTIVE);
        am.setThing(row,column,(Thing)this);    
        color=Color.black;
    }
    

    /**Returns the row
    @return 
     */
    public final int getRow(){
        return row;
    }

    /**Returns tha column
    @return 
     */
    public final int getColumn(){
        return column;
    }
    
    /**Returns the color
    @return 
     */
    public final Color getColor(){
        return color;
    }


    /**Decide its next state
     */
    public void decide(){
         nextState=(getSteps() % 3 ==0 ? Artefact.ACTIVE:Artefact.INACTIVE);
    }

    /**Change its actual state
     */
    public final void change(){
        step();
        state=nextState;
    }
    
   
    public int neighborsActive(){
        return am.neighborsActive(row,column);
    }
    
    public boolean neighborIsEmpty(int dr,int dc){
        return am.isEmpty(row+dr,column+dc);
    }    
    
}
