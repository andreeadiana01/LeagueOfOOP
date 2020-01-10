package tools;

import angels.DamageAngel;
import angels.Dracula;
import angels.DarkAngel;
import angels.GoodBoy;
import angels.LevelUpAngel;
import angels.LifeGiver;
import angels.SmallAngel;
import angels.Spawner;
import angels.TheDoomer;
import angels.XPAngel;
import angels.Angel;

public final class AngelFactory {

    private AngelFactory() { }

    public static AngelFactory getInstance() {
        return new AngelFactory();
    }


    public Angel getAngel(final String angelType, final int line, final int col) {
        switch (angelType) {
            case "DamageAngel": return new DamageAngel(line, col);
            case "DarkAngel": return new DarkAngel(line, col);
            case "Dracula": return new Dracula(line, col);
            case "GoodBoy": return new GoodBoy(line, col);
            case "LevelUpAngel": return new LevelUpAngel(line, col);
            case "LifeGiver" : return new LifeGiver(line, col);
            case "SmallAngel" : return new SmallAngel(line, col);
            case "Spawner" : return new Spawner(line, col);
            case "TheDoomer" : return new TheDoomer(line, col);
            case "XPAngel" : return new XPAngel(line, col);
            default : return null;
        }
    }
}
