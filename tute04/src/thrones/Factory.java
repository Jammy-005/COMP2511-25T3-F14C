package thrones;

import java.util.Random;

public class Factory {
    private static Random random = new Random();

    public static King createKing() {
        return new King(random.nextInt(5), random.nextInt(5));
    }

    public static Queen createQueen() {
        return new Queen(random.nextInt(5), random.nextInt(5));
    }

    public static Knight createKnight() {
        return new Knight(random.nextInt(5), random.nextInt(5));
    }

    public static Dragon createDragon() {
        return new Dragon(random.nextInt(5), random.nextInt(5));
    }
}
