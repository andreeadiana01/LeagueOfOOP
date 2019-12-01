package tools;

import heroes.Hero;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

// This class creates a hero based on its given position.

public final class HeroFactory {

    private HeroFactory() { }

    public static HeroFactory getInstance() {
        return new HeroFactory();
    }


    public Hero getHero(final String heroType, final int line, final int col) {
        switch (heroType) {
            case "P": return new Pyromancer(line, col);
            case "K": return new Knight(line, col);
            case "W": return new Wizard(line, col);
            case "R": return new Rogue(line, col);
            default : return null;
        }
    }


}
