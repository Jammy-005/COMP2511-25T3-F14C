package thrones.factories;

import java.util.Random;

import thrones.characters.Dragon;
import thrones.characters.King;
import thrones.characters.Knight;
import thrones.characters.Queen;

public abstract class CharacterFactory {
    private Random r = new Random();
    
    public abstract King createKing();
    public abstract Queen createQueen();
    public abstract Knight createKnight();
    public abstract Dragon createDragon();
    
    public int getInt(int bound) {
        return r.nextInt(bound);
    }

    public int getIntDivisbleBy(int n) {
        return Math.floorDiv(r.nextInt(), n) * n;
    }
}
