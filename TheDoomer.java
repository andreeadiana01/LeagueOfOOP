package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class TheDoomer extends Angel {
    public TheDoomer(final int l, final int c) {
        super(l, c);
        this.setFullType("TheDoomer");
        this.setGood(false);
    }

    /**
     *
     * @param knight
     */

    @Override
    public void visit(final Knight knight) {
        knight.setHp(0);
    }

    /**
     *
     * @param pyromancer
     */

    @Override
    public void visit(final Pyromancer pyromancer) {
        pyromancer.setHp(0);
    }

    /**
     *
     * @param rogue
     */

    @Override
    public void visit(final Rogue rogue) {
        rogue.setHp(0);

    }

    /**
     *
     * @param wizard
     */

    @Override
    public void visit(final Wizard wizard) {
        wizard.setHp(0);
    }
}
