package agh.ics.oop.model;



public class RectangularMap extends AbstractWorldMap implements WorldMap {

    int width;
    int height;


    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
    }


    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position) &&
                (position.getY() <= height) &&
                (position.getX() <= width) &&
                (position.getY() >= (-height)) &&
                (position.getX() >= (-width));
    }

    @Override
    public boolean place(WorldElement element) {
        return super.place(element);
    }

    @Override
    public void move(WorldElement worldElement, MoveDirection direction) {
        super.move(worldElement, direction, this);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return super.isOccupied(position);
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        return super.objectAt(position);
    }

    @Override
    public String toString() {
        int maxX = 0;
        int maxY = 0;

        int minX = 0;
        int minY = 0;

        for (Vector2d position : animalsMap.keySet()) {
            maxX = Math.max(maxX, position.getX());
            maxY = Math.max(maxY, position.getY());
            minX = Math.min(minX, position.getX());
            minY = Math.min(minY, position.getY());
        }

        for (Vector2d position : grassMap.keySet()) {
            maxX = Math.max(maxX, position.getX());
            maxY = Math.max(maxY, position.getY());
            minX = Math.min(minX, position.getX());
            minY = Math.min(minY, position.getY());
        }

        MapVisualizer visualizer = new MapVisualizer(this);
        Vector2d lowerLeft = new Vector2d(0, 0);
        Vector2d upperRight = new Vector2d(maxX, maxY);
        return visualizer.draw(lowerLeft, upperRight);
    }
}
