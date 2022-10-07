package tests;

import domain.*;
import org.junit.jupiter.api.*;
import java.awt.Color;
import static org.junit.jupiter.api.Assertions.*;
/**
 * Write a description of class AManufacturingTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AManufacturingTest
{
    @Test
    public void deberiaCrearCelulaViva(){
        AManufacturing am = new AManufacturing();
        assertEquals(am.getThing(1,1).isActive(), true);
    }

    @Test
    public void deberiaEstarMuertaCelula(){
        AManufacturing am = new AManufacturing();
        for(int i = 0; i < 5; i++){
            am.ticTac();
        }
        assertEquals(am.getThing(1,1).isActive(), false);
    }

    @Test
    public void deberiaCrearMimo(){
        AManufacturing am = new AManufacturing();
        assertEquals(am.getThing(3,3).getColor(), Color.ORANGE);
        assertEquals(am.getThing(3,4).getColor(), Color.ORANGE);
        assertEquals(am.getThing(3,5).getColor(), Color.ORANGE);
    }

    @Test
    public void deberiaCopiarEstadoMimo(){
        AManufacturing am = new AManufacturing();
        for(int i = 0; i < 6; i++){
            am.ticTac();
        }
        assertEquals(am.getThing(3,3).isActive(), false);
        assertEquals(am.getThing(3,4).isActive(), true);
        assertEquals(am.getThing(3,5).isActive(), false);

        am.ticTac();

        assertEquals(am.getThing(3,3).isActive(), false);
        assertEquals(am.getThing(3,4).isActive(), false);
        assertEquals(am.getThing(3,5).isActive(), true);

        am.ticTac();

        assertEquals(am.getThing(3,3).isActive(), true);
        assertEquals(am.getThing(3,4).isActive(), false);
        assertEquals(am.getThing(3,5).isActive(), false);
    }

    @Test
    public void deberiaCrearKriptonita(){
        AManufacturing am = new AManufacturing();

        assertEquals(am.getThing(0,0).getColor(), Color.GREEN);
        assertEquals(am.getThing(49,49).getColor(), Color.GREEN);
        assertEquals(am.getThing(0,49).getColor(), Color.GREEN);
        assertEquals(am.getThing(49,0).getColor(), Color.GREEN);

        assertEquals(am.getThing(0,0).shape(), Thing.ROUND);
        assertEquals(am.getThing(49,49).shape(), Thing.ROUND);
        assertEquals(am.getThing(0,49).shape(), Thing.ROUND);
        assertEquals(am.getThing(49,0).shape(), Thing.ROUND);

        assertEquals(am.getThing(0,0).isActive(), true);
        assertEquals(am.getThing(49,49).isActive(), true);
        assertEquals(am.getThing(0,49).isActive(), true);
        assertEquals(am.getThing(49,0).isActive(), true);
    }

    @Test
    public void deberiaDesactivarseKriptonitaTresEsquinas(){
        AManufacturing am = new AManufacturing();
        am.ticTac();

        assertEquals(am.getThing(49,49).isActive(), false);
        assertEquals(am.getThing(0,49).isActive(), false);
        assertEquals(am.getThing(49,0).isActive(), false);
    }

    @Test
    public void deberiaReplicarseKriptonita(){
        AManufacturing am = new AManufacturing();
        am.ticTac();

        assertEquals(am.getThing(0,0).isActive(), true);

        assertEquals(am.getThing(1,0).getColor(), Color.GREEN);
        assertEquals(am.getThing(1,0).shape(), Thing.ROUND);

        assertEquals(am.getThing(0,1).getColor(), Color.GREEN);
        assertEquals(am.getThing(0,1).shape(), Thing.ROUND);
    }

    @Test 
    public void deberiaZombieInfectarCelulasCercanas(){
        AManufacturing am = new AManufacturing();
        am.ticTac();

        assertEquals(am.getThing(11,11).getColor(), Color.RED);
        assertEquals(am.getThing(9,9).getColor(), Color.RED);
        assertEquals(am.getThing(10,11).getColor(), Color.RED);
        assertEquals(am.getThing(12,11).getColor(), Color.RED);
        assertEquals(am.getThing(13,11).getColor(), Color.RED);
    }
    
    @Test
    public void deberiaMatarZombiesCercanos(){
        AManufacturing am = new AManufacturing();
        am.ticTac();

        assertEquals(am.getThing(35,20).isActive(), true);
        assertEquals(am.getThing(35,20).getColor(), Color.CYAN);
        
        assertEquals(am.getThing(34,20).isActive(), false);
        assertEquals(am.getThing(34,21).isActive(), false);
        assertEquals(am.getThing(35,21).isActive(), false);
        assertEquals(am.getThing(34,19).isActive(), false);
        assertEquals(am.getThing(35,19).isActive(), false);
    }
}
