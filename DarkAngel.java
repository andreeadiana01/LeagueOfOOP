package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

import static constants.AngelConstants.DARK_ANGEL_ON_KNIGHT;
import static constants.AngelConstants.DARK_ANGEL_ON_PYRO;
import static constants.AngelConstants.DARK_ANGEL_ON_ROGUE;
import static constants.AngelConstants.DARK_ANGEL_ON_WIZARD;

public class DarkAngel extends Angel {
    public DarkAngel(final int l, final int c) {
        super(l, c);
        this.setFullType("DarkAngel");
        this.setGood(false);
    }

    /**
     *
     * @param knight
     */

    @Override
    public void visit(final Knight knight) {
        knight.modifyHp(DARK_ANGEL_ON_KNIGHT);
    }

    /**
     *
     * @param pyromancer
     */

    @Override
    public void visit(final Pyromancer pyromancer) {
        pyromancer.modifyHp(DARK_ANGEL_ON_PYRO);

    }

    /**
     *
     * @param rogue
     */

    @Override
    public void visit(final Rogue rogue) {
        rogue.modifyHp(DARK_ANGEL_ON_ROGUE);
    }

    /**
     *
     * @param wizard
     */

    @Override
    public void visit(final Wizard wizard) {
        wizard.modifyHp(DARK_ANGEL_ON_WIZARD);
    }
}
