package test.storage;

import Storage.Storage;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class StorageTest {
    @Test
    public void constructorTest(){
        Storage s= Storage.getInstance(3,4,5);
        assertNotNull(s);
        assertEquals(s.getWidth(),3);
        assertEquals(s.getLength(),4);
        assertEquals(s.getHeight(),5);
        assertFalse(s.getMap().isEmpty());
        assertEquals(s.getMap().size(),12);
        assertTrue(s.getMap().get(new Point(1,1)).isEmpty());
    }



}