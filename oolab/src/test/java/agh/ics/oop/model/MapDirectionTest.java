package agh.ics.oop.model;

import agh.ics.oop.model.MapDirection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class MapDirectionTest {
    @Test
    public void nextVerificate(){
        //then
        Assertions.assertEquals(MapDirection.EAST, MapDirection.NORTH.next());
        Assertions.assertEquals(MapDirection.SOUTH, MapDirection.EAST.next());
        Assertions.assertEquals(MapDirection.WEST, MapDirection.SOUTH.next());
        Assertions.assertEquals(MapDirection.NORTH, MapDirection.WEST.next());
    }

    @Test
    public void previousnextVerificate(){
        //then
        Assertions.assertEquals(MapDirection.EAST, MapDirection.SOUTH.previous());
        Assertions.assertEquals(MapDirection.SOUTH, MapDirection.WEST.previous());
        Assertions.assertEquals(MapDirection.WEST, MapDirection.NORTH.previous());
        Assertions.assertEquals(MapDirection.NORTH, MapDirection.EAST.previous());
    }
}