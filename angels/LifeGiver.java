package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

import static constants.AngelConstants.LIFEGIVER_ON_KNIGHT;
import static constants.AngelConstants.LIFEGIVER_ON_PYRO;
import static constants.AngelConstants.LIFEGIVER_ON_ROGUE;
import static constants.AngelConstants.LIFEGIVER_ON_WIZARD;

public class LifeGiver extends Angel {
    public LifeGiver(final int l, final int c) {
        super(l, c);
        this.setFullType("LifeGiver");
        this.setGood(true);
    }

    /**
     *
     * @param knight
     */

    @Override
    public void visit(final Knight knight) {
        knight.modifyHp(LIFEGIVER_ON_KNIGHT);
    }

    /**
     *
     * @param pyromancer
     */

    @Override
    public void visit(final Pyromancer pyromancer) {
        pyromancer.modifyHp(LIFEGIVER_ON_PYRO);

    }

    /**
     *
     * @param rogue
     */

    @Override
    public void visit(final Rogue rogue) {
        rogue.modifyHp(LIFEGIVER_ON_ROGUE);

    }

    /**
     *
     * @param wizard
     */

    @Override
    public void visit(final Wizard wizard) {
        wizard.modifyHp(LIFEGIVER_ON_WIZARD);
    }
}
