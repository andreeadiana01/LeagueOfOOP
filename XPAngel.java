package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

import static constants.AngelConstants.XP_ANGEL_ON_KNIGHT;
import static constants.AngelConstants.XP_ANGEL_ON_PYRO;
import static constants.AngelConstants.XP_ANGEL_ON_ROGUE;
import static constants.AngelConstants.XP_ANGEL_ON_WIZARD;

public class XPAngel extends Angel {
    public XPAngel(final int l, final int c) {
        super(l, c);
        this.setFullType("XPAngel");
        this.setGood(true);
    }

    /**
     *
     * @param knight
     */

    @Override
    public void visit(final Knight knight) {
        knight.modifyXp(XP_ANGEL_ON_KNIGHT);
    }

    /**
     *
     * @param pyromancer
     */

    @Override
    public void visit(final Pyromancer pyromancer) {
        pyromancer.modifyXp(XP_ANGEL_ON_PYRO);

    }

    /**
     *
     * @param rogue
     */

    @Override
    public void visit(final Rogue rogue) {
        rogue.modifyXp(XP_ANGEL_ON_ROGUE);
    }

    /**
     *
     * @param wizard
     */

    @Override
    public void visit(final Wizard wizard) {
        wizard.modifyXp(XP_ANGEL_ON_WIZARD);

    }
}
