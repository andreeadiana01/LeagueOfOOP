package heroes;

import java.util.Objects;

import static constants.Constants.ADD_XP;
import static constants.Constants.XP_PER_LEVEL;
import static constants.Constants.VOLCANIC_BOOST;
import static constants.Constants.LAND_BOOST;
import static constants.Constants.WOODS_BOOST;
import static constants.Constants.DESERT_BOOST;
import static constants.Constants.FIREBLAST_DAMAGE;
import static constants.Constants.IGNITE_BASE_DAMAGE;
import static constants.Constants.EXECUTE_DAMAGE;
import static constants.Constants.SLAM_DAMAGE;
import static constants.Constants.BACKSTAB_DAMAGE;
import static constants.Constants.PARALYSIS_DAMAGE;

public abstract class Hero {
    private int xp;
    private int level;
    private int line;
    private int col;
    private int hp;
    private int roundNR;
    private int receivedDamage;
    private boolean isIncapacitated;
    private char type;
    private char landModif;
    private float boost;
    private float critical;
    private float id;
    private float unalteredDamage;


    public Hero() {
    }

    public Hero(final int l, final int c) {
        line = l;
        col = c;
        xp = 0;
        level = 0;
        isIncapacitated = false;
        boost = 0;
        critical = 0;
    }

    /**
     *
     * @return
     */

    public int getXp() {
        return xp;
    }

    /**
     *
     * @param xp
     */

    public void setXp(final int xp) {
        this.xp = xp;
    }

    /**
     *
     * @return
     */

    public int getLevel() {
        return level;
    }

    /**
     *
     * @return
     */

    public int getLine() {
        return line;
    }

    /**
     *
     * @return
     */

    public int getCol() {
        return col;
    }

    /**
     *
     * @return
     */

    public int getHp() {
        return hp;
    }

    /**
     *
     * @param hp
     */

    public void setHp(final int hp) {
        this.hp = hp;
    }

    /**
     *
     * @return
     */

    public int getRoundNR() {
        return roundNR;
    }

    /**
     *
     * @param roundNR
     */

    public void setRoundNR(final int roundNR) {
        this.roundNR = roundNR;
    }

    /**
     *
     * @param incapacitated
     */

    public void setIncapacitated(final boolean incapacitated) {
        isIncapacitated = incapacitated;
    }

    /**
     *
     * @return
     */

    public char getType() {
        return type;
    }

    /**
     *
     * @param type
     */

    public void setType(final char type) {
        this.type = type;
    }

    /**
     *
     * @return
     */

    public char getLandModif() {
        return landModif;
    }

    /**
     *
     * @param landModif
     */

    public void setLandModif(final char landModif) {
        this.landModif = landModif;
    }

    /**
     *
     * @return
     */

    public float getBoost() {
        return boost;
    }

    /**
     *
     * @return
     */

    public float getCritical() {
        return critical;
    }

    /**
     *
     * @param critical
     */

    public void setCritical(final float critical) {
        this.critical = critical;
    }

    /**
     *
     * @param id
     */

    public void setId(final float id) {
        this.id = id;
    }

    /**
     *
     * @param boost
     */

    public void setBoost(final float boost) {
        this.boost = boost;
    }

    public abstract int getMaxHp();

    /**
     *
     * @param receivedDamage
     */

    public void setReceivedDamage(final int receivedDamage) {
        this.receivedDamage = receivedDamage;
    }

    /**
     *
     * @param damage
     */

    public void decreaseHp(final int damage) {
        this.setHp(this.getHp() - damage);
    }

    /**
     *
     * @return
     */

    public float getUnalteredDamage() {
        return unalteredDamage;
    }

    /**
     *
     * @param unalteredDamage
     */

    public void setUnalteredDamage(final float unalteredDamage) {
        this.unalteredDamage = unalteredDamage;
    }

    /**
     * This method computes the XP for the winner of the fight.
     * @param winXp
     * @return
     */

    public int computeLevelUpXp(final int winXp) {
        int limitXp = ADD_XP + this.level * XP_PER_LEVEL;
        if (winXp >= limitXp) {
            level++;
        }
        int dif = winXp - limitXp;
        while (dif >= XP_PER_LEVEL) {
            level++;
            dif -= XP_PER_LEVEL;
        }
        return level;

    }

    /**
     * The method sets the land modifier for each player.
     */

    public void setTerrainBoost() {
        switch (this.getType()) {
            case 'P' :
                this.setBoost(VOLCANIC_BOOST);
                break;
            case 'K' :
                this.setBoost(LAND_BOOST);
                break;
            case 'R' :
                this.setBoost(WOODS_BOOST);
                break;
            case 'W' :
                this.setBoost(DESERT_BOOST);
                break;
            default:
                throw new IllegalStateException("Value not expected");
        }
    }


    /**
     * The method sets the base damage for each player.
     * This is used when a wizard applies deflect.
     */

    public void setUnaltered() {
        switch (this.getType()) {
            case 'P' :
                this.setUnalteredDamage(FIREBLAST_DAMAGE * (this.getBoost() + 1)
                        + IGNITE_BASE_DAMAGE * (this.getBoost() + 1));
                break;
            case 'K' :
                this.setUnalteredDamage(EXECUTE_DAMAGE * (this.getBoost() + 1)
                        + SLAM_DAMAGE * (this.getBoost() + 1));
                break;
            case 'R' :
                this.setUnalteredDamage(BACKSTAB_DAMAGE * (this.getBoost() + 1)
                        + PARALYSIS_DAMAGE * (this.getBoost() + 1));
                break;
            case 'W' :

                break;
            default:
                throw new IllegalStateException("Value not expected");
        }

    }

    /**
     *
     * @param o
     * @return
     */

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Hero hero = (Hero) o;
        return Float.compare(hero.id, id) == 0;
    }

    /**
     *
     * @return
     */

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * Methods that implement the Double Dispatch mechanism.
     * @param hero
     */

    public abstract void isAttackedBy(Hero hero);
    public abstract void attack(Pyromancer pyromancer);
    public abstract void attack(Knight knight);
    public abstract void attack(Rogue rogue);
    public abstract void attack(Wizard wizard);
}
