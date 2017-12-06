package test.pack;

import Storage.pack.TypesOfPackage;
import Storage.pack.coordinates.Coordinates;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import Storage.pack.Package;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PackageTest {

    @Test
    public void constructorTest(){
        Package p = new Package(TypesOfPackage.toys, "sssss", 1, 1);
        assertTrue(p.getType()==TypesOfPackage.toys);
        assertTrue(p.getDescription()=="sssss");
        assertTrue(p.getNumber()==1);
        assertTrue(p.getPriority()==1);
        assertEquals(p.getMoves(),0);
        assertEquals(p.getHistoryOfMoves().size(),0);
        assertNull(p.getCoordniates());

    }
    @Test
    public void setCoordinates(){
        Package p = new Package(TypesOfPackage.toys, "sssss", 1, 1);
        p.setCoordinates(1,1,1);
        assertEquals(p.getCoordniates().getW(),1);
        assertEquals(p.getCoordniates().getL(),1);
        assertEquals(p.getCoordniates().getH(),1);
    }

    @Test
    public void getHistoryOfMoves() throws Exception {
        Package p = new Package(TypesOfPackage.toys, "sssss", 1, 1);
        ArrayList<Coordinates> result = p.getHistoryOfMoves();
        assertEquals(result.size(),0);
        p.setCoordinates(1,2,3);
        result = p.getHistoryOfMoves();
        assertEquals(result.size(),1);
    }

}