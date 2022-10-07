package domain;
import java.util.*;


/*No olviden adicionar la documentacion*/
public class AManufacturing{
    static private int SIZE=50;
    private Thing[][] lattice;
    static private int numTicTacs = 0;
    
    public AManufacturing() {
        lattice=new Thing[SIZE][SIZE];
        for (int r=0;r<SIZE;r++){
            for (int c=0;c<SIZE;c++){
                lattice[r][c]=null;
            }
        }
        someThings();
    }

    public int  getSize(){
        return SIZE;
    }

    public Thing getThing(int r,int c){
        return lattice[r][c];
    }

    public void setThing(int r, int c, Thing e){
        lattice[r][c]=e;
    }

    public void someThings(){
        Cell simba = new Cell(this, 1, 1, true);
        Cell dala = new Cell(this, 2, 2, true);
        
        Cell testMimos = new Cell(this,2,3,true);
        Mimo mufasa = new Mimo(this, 3,3,true);
        Mimo scar = new Mimo(this,3,4,true);
        Mimo rafiki = new Mimo(this,3,5,true);
        
        Kriptonita uone = new Kriptonita(this,0,0,true);
        Kriptonita two = new Kriptonita(this,49,0,true);
        Kriptonita three = new Kriptonita(this,0,49,true);
        Kriptonita four = new Kriptonita(this,49,49,true);
    }
    
    public int neighborsActive(int r, int c){
        int num=0;
        for(int dr=-1; dr<2;dr++){
            for (int dc=-1; dc<2;dc++){
                if ((dr!=0 || dc!=0) && inLatice(r+dr,c+dc) && 
                    (lattice[r+dr][c+dc]!=null) &&  (lattice[r+dr][c+dc].isActive())) num++;
            }
        }
        return (inLatice(r,c) ? num : 0);
    }
  
   
    public boolean isEmpty(int r, int c){
        return (inLatice(r,c) && lattice[r][c]==null);
    }    
        
    private boolean inLatice(int r, int c){
        return ((0<=r) && (r<SIZE) && (0<=c) && (c<SIZE));
    }
    
    public void ticTac(){
        for(Thing[] latticeArray:lattice){
            for(Thing element:latticeArray){
                if(element != null){
                    element.decide();
                    //element.change();
                }
            }
        }
        for(Thing[] latticeArray:lattice){
            for(Thing element:latticeArray){
                if(element != null){
                    //element.decide();
                    element.change();
                }
            }
        }
    }
    

}
