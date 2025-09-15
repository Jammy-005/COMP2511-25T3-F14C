package thrones.factories;

import thrones.characters.Dragon;
import thrones.characters.King;
import thrones.characters.Knight;
import thrones.characters.Queen;
import thrones.characters.plastic.PlasticDragon;
import thrones.characters.plastic.PlasticKing;
import thrones.characters.plastic.PlasticKnight;
import thrones.characters.plastic.PlasticQueen;

public class PlasticFactory extends CharacterFactory {

    private int bound;

    public PlasticFactory(int bound) {
        this.bound = bound;
    }

    @Override
    public King createKing() {
        return new PlasticKing(getInt(bound), getInt(bound));
    }
    
    @Override
    public Queen createQueen() {
        return new PlasticQueen(getInt(bound), getInt(bound));
    }
    
    @Override
    public Knight createKnight() {
        return new PlasticKnight(getInt(bound), getInt(bound));
    }
    
    @Override
    public Dragon createDragon() {
        return new PlasticDragon(getInt(bound), getInt(bound));
    }
    
}
