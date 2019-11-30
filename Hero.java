package heroes;

import java.util.Objects;

import static constants.Constants.*;
import static java.lang.Math.round;

public abstract class Hero {
    private int XP;
    private int level;
    private int line;
    private int col;
    private int HP;
    private boolean isWinner;
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

    public Hero(final int l, final int c){
        line = l;
        col = c;
        XP = 0;
        level = 0;
        isIncapacitated = false;
        boost = 0;
        critical = 0;
    }

    public int computeLevelUpXP(int winXP){
        int limitXP = ADD_XP + this.level * XP_PER_LEVEL;
        if (winXP >= limitXP){
            level++;
        }
        int dif = winXP - limitXP;
        while (dif >= XP_PER_LEVEL){
            level++;
            dif -= XP_PER_LEVEL;
        }
        return level;

    }

    public int getXP() {
        return XP;
    }

    public void setXP(int XP) {
        this.XP = XP;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public boolean isWinner() {
        return isWinner;
    }

    public void setWinner(boolean winner) {
        isWinner = winner;
    }

    public int getRoundNR() {
        return roundNR;
    }

    public void setRoundNR(int roundNR) {
        this.roundNR = roundNR;
    }

    public boolean isIncapacitated() {
        return isIncapacitated;
    }

    public void setIncapacitated(boolean incapacitated) {
        isIncapacitated = incapacitated;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public char getLandModif() {
        return landModif;
    }

    public void setLandModif(char landModif) {
        this.landModif = landModif;
    }

    public float getBoost() {
        return boost;
    }

    public float getCritical() {
        return critical;
    }

    public void setCritical(float critical) {
        this.critical = critical;
    }

    public float getId() {
        return id;
    }

    public void setId(float id) {
        this.id = id;
    }

    public void setBoost(float boost) {
        this.boost = boost;
    }

    public void setTerrainBoost(){
        switch (this.getType()){
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
                ;
        }
    }

    public abstract int getMaxHP();

    public int getReceivedDamage() {
        return receivedDamage;
    }

    public void setReceivedDamage(int receivedDamage) {
        this.receivedDamage = receivedDamage;
    }

    public void decreaseHP(int damage){
        this.setHP(this.getHP() - damage);
    }

    public float getUnalteredDamage() {
        return unalteredDamage;
    }

    public void setUnalteredDamage(float unalteredDamage) {
        this.unalteredDamage = unalteredDamage;
    }

    public void setUnaltered() {
        switch (this.getType()){
            case 'P' :
                this.setUnalteredDamage(FIREBLAST_DAMAGE * (this.getBoost() + 1) + IGNITE_BASE_DAMAGE * (this.getBoost() +1));
                break;
            case 'K' :
                this.setUnalteredDamage(EXECUTE_DAMAGE * (this.getBoost() + 1) + SLAM_DAMAGE * (this.getBoost() + 1));
                break;
            case 'R' :
                this.setUnalteredDamage(BACKSTAB_DAMAGE * (this.getBoost() + 1) + PARALYSIS_DAMAGE * (this.getBoost() + 1));
                break;
            case 'W' :

                break;
            default:
                ;
        }

    }

    //    public abstract void boostDamage();


//    public abstract void isAttackedBy(Pyromancer pyromancer);
//    public abstract void isAttackedBy(Wizard wizard);
//    public abstract void isAttackedBy(Rogue rogue);
//    public abstract void isAttackedBy(Knight knight);
    public abstract void isAttackedBy(Hero hero);

//    public abstract void attack(Pyromancer pyromancer);
//    public abstract void attack(Wizard wizard);
//    public abstract void attack(Rogue rogue);
//    public abstract void attack(Knight knight);
    public abstract void attack(Hero hero);


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hero hero = (Hero) o;
        return Float.compare(hero.id, id) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
