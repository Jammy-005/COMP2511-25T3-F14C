package thrones.factories;

import thrones.characters.Dragon;
import thrones.characters.King;
import thrones.characters.Knight;
import thrones.characters.Queen;
import thrones.characters.metal.MetalDragon;
import thrones.characters.metal.MetalKing;
import thrones.characters.metal.MetalKnight;
import thrones.characters.metal.MetalQueen;

public class MetalFactory extends CharacterFactory {
    @Override
    public King createKing() {
        return new MetalKing(getInt(10), 0);
    }
    
    @Override
    public Queen createQueen() {
        return new MetalQueen(getInt(10), 0);
    }
    
    @Override
    public Knight createKnight() {
        return new MetalKnight(getInt(10), 0);
    }
    
    @Override
    public Dragon createDragon() {
        return new MetalDragon(getInt(10), 0);
    }
}
