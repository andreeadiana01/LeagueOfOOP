package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

import static constants.AngelConstants.LVL_UP_ANGEL_ON_KNIGHT;
import static constants.AngelConstants.LVL_UP_ANGEL_ON_PYRO;
import static constants.AngelConstants.LVL_UP_ANGEL_ON_ROGUE;
import static constants.AngelConstants.LVL_UP_ANGEL_ON_WIZARD;

public class LevelUpAngel extends Angel {
    public LevelUpAngel(final int l, final int c) {
        super(l, c);
        this.setFullType("LevelUpAngel");
        this.setGood(true);
    }


    /**
     *
     * @param knight
     */

    @Override
    public void visit(final Knight knight) {
        knight.setAngelDamage(LVL_UP_ANGEL_ON_KNIGHT);
        knight.setLevel(knight.getLevel() + 1);
    }

    /**
     *
     * @param pyromancer
     */

    @Override
    public void visit(final Pyromancer pyromancer) {
        pyromancer.setAngelDamage(LVL_UP_ANGEL_ON_PYRO);
        pyromancer.setLevel(pyromancer.getLevel() + 1);

    }

    /**
     *
     * @param rogue
     */

    @Override
    public void visit(final Rogue rogue) {
        rogue.setAngelDamage(LVL_UP_ANGEL_ON_ROGUE);
        rogue.setLevel(rogue.getLevel() + 1);
    }

    /**
     *
     * @param wizard
     */

    @Override
    public void visit(final Wizard wizard) {
        wizard.setAngelDamage(LVL_UP_ANGEL_ON_WIZARD);
        wizard.setLevel(wizard.getLevel() + 1);
    }
}
