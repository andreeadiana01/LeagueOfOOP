package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

import static constants.AngelConstants.RESET_ON_KNIGHT;
import static constants.AngelConstants.RESET_ON_PYRO;
import static constants.AngelConstants.RESET_ON_ROGUE;
import static constants.AngelConstants.RESET_ON_WIZARD;

public class Spawner extends Angel {
    public Spawner(final int l, final int c) {
        super(l, c);
        this.setFullType("Spawner");
        this.setGood(true);
    }

    /**
     *
     * @param knight
     */

    @Override
    public void visit(final Knight knight) {
        knight.setHp(RESET_ON_KNIGHT);
    }

    /**
     *
     * @param pyromancer
     */

    @Override
    public void visit(final Pyromancer pyromancer) {
        pyromancer.setHp(RESET_ON_PYRO);
    }

    /**
     *
     * @param rogue
     */

    @Override
    public void visit(final Rogue rogue) {
        rogue.setHp(RESET_ON_ROGUE);
    }

    /**
     *
     * @param wizard
     */

    @Override
    public void visit(final Wizard wizard) {
        wizard.setHp(RESET_ON_WIZARD);
    }
}
