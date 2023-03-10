package com.epam.rd.autotasks;
public enum Direction {
    N(0), NE(45), E(90), SE(135), S(180), SW(225), W(270), NW(315);
    private final int degrees;
    Direction(final int degrees) {
        this.degrees = degrees;
    }
    public static Direction ofDegrees(int degrees) {
        degrees = degreesToLimit(degrees);
        for (Direction direction : Direction.values()){
            if (direction.degrees == degrees) { return direction; }
        }
        return null;
    }

    public static Direction closestToDegrees(int degrees) {
        degrees = degreesToLimit(degrees);
        int temp = Math.abs(degrees - Direction.N.degrees);
        Direction closestDirection = Direction.N;
        for (Direction direction : Direction.values()){
            if (Math.abs(degrees - direction.degrees) <  temp) {
                closestDirection = direction;
                temp = Math.abs(degrees - direction.degrees);
            }
        }
        return closestDirection;
    }

    public Direction opposite() {
        return this.ordinal() < 4 ?
                Direction.values()[this.ordinal() + 4] :
                Direction.values()[this.ordinal() -4];
    }

    public int differenceDegreesTo(Direction direction) {
        return Math.abs(this.degrees - direction.degrees) < 180 ?
                Math.abs(this.degrees - direction.degrees) :
                360 - Math.abs(this.degrees - direction.degrees);
    }

    public static int degreesToLimit(int degrees){
        while (degrees >= 360 ){
            degrees -= 360;
        }
        while (degrees < 0 ){
            degrees += 360;
        }
        return  degrees;
    }
}
