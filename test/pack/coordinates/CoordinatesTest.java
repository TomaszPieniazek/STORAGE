package test.pack.coordinates;

import Storage.pack.coordinates.Coordinates;
import org.junit.Test;

import static org.junit.Assert.*;

public class CoordinatesTest {
    @Test
    public void setCoordinatesTest(){
        Coordinates c = new Coordinates(1,2,3);
        c.setCoordinatesWLH(6,6,6);
        int expectedW=6, expectedL=6, expectedH=6;
        assertTrue(c.getW()==expectedW && c.getL()==expectedL && c.getH()==expectedH);

    }

    @Test
    public void properCordsTest(){
        Coordinates c = new Coordinates(1,2,3);
        boolean result = c.areCordsProper();
        assertTrue(result);
    }

    @Test
    public void wrongCordsTest(){
        Coordinates c = new Coordinates(-1,-1,-1);
        boolean result = c.areCordsProper();
        assertFalse(result);
    }


}