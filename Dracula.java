package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

import static constants.AngelConstants.DRACULA_DMG_ON_KNIGHT;
import static constants.AngelConstants.DRACULA_DMG_ON_PYRO;
import static constants.AngelConstants.DRACULA_DMG_ON_ROGUE;
import static constants.AngelConstants.DRACULA_DMG_ON_WIZARD;
import static constants.AngelConstants.DRACULA_HP_ON_KNIGHT;
import static constants.AngelConstants.DRACULA_HP_ON_PYRO;
import static constants.AngelConstants.DRACULA_HP_ON_ROGUE;
import static constants.AngelConstants.DRACULA_HP_ON_WIZARD;

public class Dracula extends Angel {
    public Dracula(final int l, final int c) {
        super(l, c);
        this.setFullType("Dracula");
        this.setGood(false);
    }

    /**
     *
     * @param knight
     */

    @Override
    public void visit(final Knight knight) {
        knight.setAngelDamage(DRACULA_DMG_ON_KNIGHT);
        knight.modifyHp(DRACULA_HP_ON_KNIGHT);
    }

    /**
     *
     * @param pyromancer
     */

    @Override
    public void visit(final Pyromancer pyromancer) {
        pyromancer.setAngelDamage(DRACULA_DMG_ON_PYRO);
        pyromancer.modifyHp(DRACULA_HP_ON_PYRO);

    }

    /**
     *
     * @param rogue
     */

    @Override
    public void visit(final Rogue rogue) {
        rogue.setAngelDamage(DRACULA_DMG_ON_ROGUE);
        rogue.modifyHp(DRACULA_HP_ON_ROGUE);
    }

    /**
     *
     * @param wizard
     */

    @Override
    public void visit(final Wizard wizard) {
        wizard.setAngelDamage(DRACULA_DMG_ON_WIZARD);
        wizard.modifyHp(DRACULA_HP_ON_WIZARD);

    }
}
