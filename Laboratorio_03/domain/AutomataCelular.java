package domain;
import java.util.*;

/**
 * 
 */
public class AutomataCelular{
    static private int LONGITUD=30;
    private Elemento[][] automata;

    /**
     * Constructor de la clase automata celular, crea un nuevo simulador y agrega algunos elementos
     */
    public AutomataCelular() {
        automata=new Elemento[LONGITUD][LONGITUD];
        for (int f=0;f<LONGITUD;f++){
            for (int c=0;c<LONGITUD;c++){
                automata[f][c]=null;
            }
        }
        algunosElementos();
    }
    
    /**
     * retorna la longitud del simulardor
     */
    public int  getLongitud(){
        return LONGITUD;
    }

    /**
     * Retorna el elemento en la fila y columna correspondientes a (f,c)
     * @param fila
     * @param columna 
     */
    public Elemento getElemento(int f,int c){
        return automata[f][c];
    }
    
    /**
     * crea un nuevo elemento en la posicion solicitada
     * @param fila
     * @param columna
     * @param elemento nuevo
     */
    public void setElemento(int f, int c, Elemento nueva){
        automata[f][c]=nueva;
    }

    /**
     * Inicializa algunos elementos solicitados previamente
     */
    public void algunosElementos(){
        Celula indiana = new Celula(this,1,1);
        Celula Celula_007 = new Celula(this,2,2);
        Especial agamenon = new Especial(this, 4,4);
        Especial venus = new Especial(this, 4, 29);
        Calefactor noreste = new Calefactor(this, 1,28);
        Calefactor suroeste = new Calefactor(this,28,1);
        Zombie andresParra = new Zombie(this, 1,2);
        Zombie danielRamos = new Zombie(this, 14,14);
        Fortaleza marineFord = new Fortaleza(this, 3, 2);
        Fortaleza eniesLobby = new Fortaleza(this, 4, 27);
    }

    /**
     * A medida que va revisando cada casilla ejecuta sus "funciones"
     */
    public void ticTac(){
        for(Elemento[] listaCelulas: automata){
            for(Elemento elemento: listaCelulas){
                if(elemento != null){
                    elemento.decida();
                    elemento.cambie();
                }
            }
        }
    }

}
