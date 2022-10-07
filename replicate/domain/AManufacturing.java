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
        
        Zombie nombreEstudiante1 = new Zombie(this,30,30,true);
        
        //Probar que se infecten diferentes tipos de celulas
        Cell testZombie1 = new Cell(this,11,11,true);
        Cell testZombie2 = new Mimo(this,9,9,true);
        Cell testZombie3 = new Cell(this,10,11,true);
        Cell testZombie4 = new Mimo(this,12,11,true);
        Cell testZombie5 = new Cell(this,13,11,true);
        Zombie nombreEstudiante2 = new Zombie(this,10,10,true);
        
        //Probar que maten los zombies a su alrededor
        Fortress nombreSemantico1 = new Fortress(this, 35,20,true);
        Zombie zombieTest1 = new Zombie(this,34,20,true);
        Zombie zombieTest2 = new Zombie(this,35,21,true);
        Zombie zombieTest3 = new Zombie(this,34,21,true);
        Zombie zombieTest4 = new Zombie(this,34,19,true);
        Zombie zombieTest5 = new Zombie(this,35,19,true);
        
        
        Fortress nombreSemantico2 = new Fortress(this, 40,40,true);
        Cell testFrotress1 = new Cell(this,40,39,true);
        Cell testFrotress2 = new Mimo(this,41,41,true);
        Cell testFrotress3 = new Cell(this,41,39,true);
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
