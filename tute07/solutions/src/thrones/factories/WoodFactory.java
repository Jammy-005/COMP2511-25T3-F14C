package thrones.factories;

import thrones.characters.Dragon;
import thrones.characters.King;
import thrones.characters.Knight;
import thrones.characters.Queen;
import thrones.characters.wood.WoodDragon;
import thrones.characters.wood.WoodKing;
import thrones.characters.wood.WoodKnight;
import thrones.characters.wood.WoodQueen;

public class WoodFactory extends CharacterFactory {

    private int n;

    public WoodFactory(int n) {
        this.n = n;
    }

    @Override
    public King createKing() {
        return new WoodKing(getIntDivisbleBy(n), getIntDivisbleBy(n));
    }
    
    @Override
    public Queen createQueen() {
        return new WoodQueen(getIntDivisbleBy(n), getIntDivisbleBy(n));
    }
    
    @Override
    public Knight createKnight() {
        return new WoodKnight(getIntDivisbleBy(n), getIntDivisbleBy(n));
    }
    
    @Override
    public Dragon createDragon() {
        return new WoodDragon(getIntDivisbleBy(n), getIntDivisbleBy(n));
    }
}