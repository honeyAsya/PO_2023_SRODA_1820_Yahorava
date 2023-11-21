package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.RectangularMap;
import agh.ics.oop.model.Vector2d;

import java.util.List;

public class World {

    public static void run(List<MoveDirection> moves) {
        for (MoveDirection move : moves) {
            if (move != null) {
                switch (move) {
                    case FORWARD:
                        System.out.println("zwierzak idzie do przodu");
                        break;
                    case RIGHT:
                        System.out.println("zwierzak skręca w prawo");
                        break;
                    case BACKWARD:
                        System.out.println("zwierzak idzie do tyłu");
                        break;
                    case LEFT:
                        System.out.println("zwierzak skręca w lewo");
                        break;
                    default:
                        break;
                }
            }
        }

    }


    public static void main(String[] args) {
        System.out.println("Start");
        run(OptionsParser.parseOptions(args));
        System.out.println("Stop");

        Animal szajluszaj = new Animal();
        System.out.println(szajluszaj);

        List<MoveDirection> directions = OptionsParser.parseOptions(args);
        List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(3, 4));
        Simulation simulation = new Simulation(positions, directions, new RectangularMap(10,10));
        simulation.run();

    }
}