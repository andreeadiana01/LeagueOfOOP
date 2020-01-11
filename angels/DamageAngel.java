package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

import static constants.AngelConstants.DMG_ANGEL_ON_KNIGHT;
import static constants.AngelConstants.DMG_ANGEL_ON_PYRO;
import static constants.AngelConstants.DMG_ANGEL_ON_ROGUE;
import static constants.AngelConstants.DMG_ANGEL_ON_WIZARD;

public class DamageAngel extends Angel {
    public DamageAngel(final int l, final int c) {
        super(l, c);
        this.setFullType("DamageAngel");
        this.setGood(true);
    }


    /**
     *
     * @param knight
     */

    @Override
    public void visit(final Knight knight) {
        knight.setAngelDamage(DMG_ANGEL_ON_KNIGHT);
    }

    /**
     *
     * @param pyromancer
     */

    @Override
    public void visit(final Pyromancer pyromancer) {
        pyromancer.setAngelDamage(DMG_ANGEL_ON_PYRO);
    }

    /**
     *
     * @param rogue
     */

    @Override
    public void visit(final Rogue rogue) {
        rogue.setAngelDamage(DMG_ANGEL_ON_ROGUE);
    }

    /**
     *
     * @param wizard
     */

    @Override
    public void visit(final Wizard wizard) {
        wizard.setAngelDamage(DMG_ANGEL_ON_WIZARD);

    }
}
