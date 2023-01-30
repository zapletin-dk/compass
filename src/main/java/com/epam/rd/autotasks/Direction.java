package com.epam.rd.autotasks;


public enum Direction {
    N(0), NE(45), E(90), SE(135), S(180), SW(225), W(270), NW(315);

    Direction(final int degrees) {
        this.degrees = degrees;
    }

    private final int degrees;

    public static Direction ofDegrees(int degrees) {
        degrees = degreesToLimit(degrees);
        for (Direction dir : Direction.values()){
            if (dir.degrees == degrees) { return dir; }
        }
        return null;
    }

    public static Direction closestToDegrees(int degrees) {
        degrees = degreesToLimit(degrees);
        int temp = Math.abs(degrees - Direction.N.degrees);
        Direction out = Direction.N;
        for (Direction dir : Direction.values()){
            if (Math.abs(degrees - dir.degrees) <  temp) {
                out = dir;
                temp = Math.abs(degrees - dir.degrees);
            }
        }
        return out;
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
