package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

import static constants.AngelConstants.GB_DMG_ON_KNIGHT;
import static constants.AngelConstants.GB_DMG_ON_PYRO;
import static constants.AngelConstants.GB_DMG_ON_ROGUE;
import static constants.AngelConstants.GB_DMG_ON_WIZARD;
import static constants.AngelConstants.GB_HP_ON_KNIGHT;
import static constants.AngelConstants.GB_HP_ON_PYRO;
import static constants.AngelConstants.GB_HP_ON_ROGUE;
import static constants.AngelConstants.GB_HP_ON_WIZARD;


public class GoodBoy extends Angel {
    public GoodBoy(final int l, final int c) {
        super(l, c);
        this.setFullType("GoodBoy");
        this.setGood(true);
    }

    /**
     *
     * @param knight
     */

    @Override
    public void visit(final Knight knight) {
        knight.setAngelDamage(GB_DMG_ON_KNIGHT);
        knight.modifyHp(GB_HP_ON_KNIGHT);

    }

    /**
     *
     * @param pyromancer
     */

    @Override
    public void visit(final Pyromancer pyromancer) {
        pyromancer.setAngelDamage(GB_DMG_ON_PYRO);
        pyromancer.modifyHp(GB_HP_ON_PYRO);

    }

    /**
     *
     * @param rogue
     */

    @Override
    public void visit(final Rogue rogue) {
        rogue.setAngelDamage(GB_DMG_ON_ROGUE);
        rogue.modifyHp(GB_HP_ON_ROGUE);
    }

    /**
     *
     * @param wizard
     */

    @Override
    public void visit(final Wizard wizard) {
        wizard.setAngelDamage(GB_DMG_ON_WIZARD);
        wizard.modifyHp(GB_HP_ON_WIZARD);
    }
}
