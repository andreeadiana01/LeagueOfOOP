package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

import static constants.AngelConstants.SMALL_DMG_ON_KNIGHT;
import static constants.AngelConstants.SMALL_DMG_ON_PYRO;
import static constants.AngelConstants.SMALL_DMG_ON_ROGUE;
import static constants.AngelConstants.SMALL_DMG_ON_WIZARD;
import static constants.AngelConstants.SMALL_HP_ON_KNIGHT;
import static constants.AngelConstants.SMALL_HP_ON_PYRO;
import static constants.AngelConstants.SMALL_HP_ON_ROGUE;
import static constants.AngelConstants.SMALL_HP_ON_WIZARD;

public class SmallAngel extends Angel {
    public SmallAngel(final int l, final int c) {
        super(l, c);
        this.setFullType("SmallAngel");
        this.setGood(true);
    }

    /**
     *
     * @param knight
     */

    @Override
    public void visit(final Knight knight) {
        knight.setAngelDamage(SMALL_DMG_ON_KNIGHT);
        knight.modifyHp(SMALL_HP_ON_KNIGHT);

    }

    /**
     *
     * @param pyromancer
     */

    @Override
    public void visit(final Pyromancer pyromancer) {
        pyromancer.setAngelDamage(SMALL_DMG_ON_PYRO);
        pyromancer.modifyHp(SMALL_HP_ON_PYRO);

    }

    /**
     *
     * @param rogue
     */

    @Override
    public void visit(final Rogue rogue) {
        rogue.setAngelDamage(SMALL_DMG_ON_ROGUE);
        rogue.modifyHp(SMALL_HP_ON_ROGUE);

    }

    /**
     *
     * @param wizard
     */

    @Override
    public void visit(final Wizard wizard) {
        wizard.setAngelDamage(SMALL_DMG_ON_WIZARD);
        wizard.modifyHp(SMALL_HP_ON_WIZARD);

    }
}
