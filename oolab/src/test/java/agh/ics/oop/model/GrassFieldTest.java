package agh.ics.oop.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GrassFieldTest {
    @Test
    public void checkCorrectPlaceGrasses(){
        //given
        GrassField sandbox = new GrassField(11);

        //then
        Assertions.assertEquals(11, sandbox.getElements().size());
    }

    @Test
    public void checkNotPlaceAnimalsOnSamePlace(){
        //given
        GrassField sandbox = new GrassField(10);
        Animal rabbit = new Animal(new Vector2d(2, 3));
        Animal wolf = new Animal(new Vector2d(2, 3));

        //when
        boolean insertedRabbit  = sandbox.place(rabbit);
        boolean insertedWolf = sandbox.place(wolf);

        //then
        Assertions.assertTrue(insertedRabbit);
        Assertions.assertFalse(insertedWolf);
        Assertions.assertEquals(sandbox.objectAt(new Vector2d(2,3)), rabbit);
    }

    @Test
    public void checkUpdatePlaceKeyAnimalsAfterMove(){
        //given
        GrassField sandbox = new GrassField(10);
        Animal rabbit = new Animal(new Vector2d(2, 3));
        Animal wolf = new Animal(new Vector2d(2, 4));

        //when
        boolean insertedRabbit  = sandbox.place(rabbit);
        boolean insertedWolf = sandbox.place(wolf);

        Animal rabbitInSandbox = (Animal) sandbox.objectAt(new Vector2d(2,3));
        Animal wolfInSandbox = (Animal) sandbox.objectAt(new Vector2d(2,4));
        sandbox.move(wolf, MoveDirection.FORWARD);
        sandbox.move(rabbit, MoveDirection.FORWARD);

        //then
        Assertions.assertTrue(insertedRabbit);
        Assertions.assertTrue(insertedWolf);
        Assertions.assertEquals(rabbitInSandbox, rabbit);
        Assertions.assertEquals(wolfInSandbox, wolf);
        Assertions.assertEquals(sandbox.objectAt(new Vector2d(2,4)), rabbit);
        Assertions.assertEquals(sandbox.objectAt(new Vector2d(2,5)), wolf);
    }

    @Test
    public void checkNotMoveAnimalsInSamePositionMove(){
        //given
        GrassField sandbox = new GrassField(10);
        Animal rabbit = new Animal(new Vector2d(2, 3));
        Animal wolf = new Animal(new Vector2d(2, 4));

        //when
        boolean insertedRabbit  = sandbox.place(rabbit);
        boolean insertedWolf = sandbox.place(wolf);

        Animal rabbitInSandbox = (Animal)sandbox.objectAt(new Vector2d(2,3));
        Animal wolfInSandbox = (Animal)sandbox.objectAt(new Vector2d(2,4));

        sandbox.move(rabbit, MoveDirection.FORWARD);
        //then
        Assertions.assertTrue(insertedRabbit);
        Assertions.assertTrue(insertedWolf);
        Assertions.assertEquals(rabbitInSandbox, rabbit);
        Assertions.assertEquals(wolfInSandbox, wolf);
        Assertions.assertEquals(sandbox.objectAt(new Vector2d(2,3)), rabbit);
    }
}