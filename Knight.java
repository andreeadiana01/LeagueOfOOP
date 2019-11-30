package heroes;

import static constants.Constants.*;
import static java.lang.Math.round;

public class Knight extends Hero {
    public Knight() {
    }

    public Knight(int l, int c){
        super(l, c);
        super.setHP(KNIGHT_START_HP + KNIGHT_HP_PER_LEVEL * super.getLevel());
        super.setType('K');
        super.setLandModif('L');
    }

    @Override
    public int getMaxHP() {
        return KNIGHT_START_HP + KNIGHT_HP_PER_LEVEL * super.getLevel();
    }

    public float executePyro(float damage){
        float damageOnPyro = damage * (this.getBoost() + 1) * (EXECUTE_ON_PYRO + 1);
        return damageOnPyro;
    }
    public float executeKnight(float damage){
        float damageOnKnight = damage * (this.getBoost() + 1) * (EXECUTE_ON_KNIGHT + 1);
        return damageOnKnight;
    }
    public float executeRogue(float damage){
        float damageOnRogue = damage * (this.getBoost() + 1) * (EXECUTE_ON_ROGUE + 1);
        return damageOnRogue;
    }
    public float executeWizard(float damage){
        float damageOnWizard = damage * (this.getBoost() + 1) * (EXECUTE_ON_WIZARD + 1);
        return damageOnWizard;
    }

    public float execute(Hero hero){
        float limitHP = 0;
        float baseDamage = 0;
        float finalDamage = 0;
        limitHP = EXECUTE_MUL_LIFE * hero.getMaxHP() + EXECUTE_MUL_LEVEL * hero.getLevel();
        if(hero.getHP() > limitHP) {
            baseDamage = EXECUTE_DAMAGE + EXECUTE_PER_LEVEL * hero.getLevel();
            switch (hero.getType()) {
                case 'P':
                    finalDamage = executePyro(baseDamage);
                    break;
                case 'K':
                    finalDamage = executeKnight(baseDamage);
                    break;
                case 'R':
                    finalDamage = executeRogue(baseDamage);
                    break;
                case 'W':
                    finalDamage = executeWizard(baseDamage);
                    break;
                default:
                    ;
            }
        } else {
            hero.setHP(0);
        }
        return finalDamage;
    }

    public float slamPyro(float damage){
        float damageOnPyro = damage * (this.getBoost() + 1) * (SLAM_ON_PYRO + 1);
        return damageOnPyro;
    }
    public float slamKnight(float damage){
        float damageOnKnight = damage * (this.getBoost() + 1) * (SLAM_ON_KNIGHT + 1);
        return damageOnKnight;
    }
    public float slamRogue(float damage){
        float damageOnRogue = damage * (this.getBoost() + 1) * (SLAM_ON_ROGUE + 1);
        return damageOnRogue;
    }
    public float slamWizard(float damage){
        float damageOnWizard = damage * (this.getBoost() + 1) * (SLAM_ON_WIZARD + 1);
        return damageOnWizard;
    }

    public float slam(Hero hero){
        float finalDamage = 0;
        float baseDamage = SLAM_DAMAGE + SLAM_PER_LEVEL * hero.getLevel();
        int roundNr = hero.getRoundNR();
        int overtime = roundNr + 1;
        for (int i = roundNr; i < overtime; i++ ) {
            hero.setIncapacitated(true);
        }
        switch (hero.getType()) {
            case 'P':
                finalDamage = slamPyro(baseDamage);
                break;
            case 'K':
                finalDamage = slamKnight(baseDamage);
                break;
            case 'R':
                finalDamage = slamRogue(baseDamage);
                break;
            case 'W':
                finalDamage = slamWizard(baseDamage);
                break;
            default:
                ;
        }
        return finalDamage;

    }

    @Override
    public void isAttackedBy(Hero hero) {
        hero.attack(this);

    }

    @Override
    public void attack(Hero hero) {
        int damageExecute = round(execute(hero));
        int damageSlam = round(slam(hero));
        int total = damageExecute + damageSlam;
        hero.decreaseHP(total);
        hero.setReceivedDamage(total);

    }






























//    public void execute(Hero hero){
//        float limitHP = 0;
//        limitHP = EXECUTE_MUL_LIFE * hero.getMaxHP() + EXECUTE_MUL_LEVEL * hero.getLevel() ;
////        System.out.println(hero.getHP());
//        if(hero.getHP() > limitHP) {
////            System.out.println(hero.getHP());
//            damage = EXECUTE_DAMAGE + EXECUTE_PER_LEVEL * hero.getLevel();
//            hero.setReceivedDamage(damage);
////            System.out.println(hero.getReceivedDamage());
//            hero.decreaseHP(damage);
//        } else {
//            hero.setHP(0);
//        }
//
//
//    }
//
//    public void execute(Pyromancer pyromancer){
//        float limitHP = 0;
//        limitHP = EXECUTE_MUL_LIFE * pyromancer.getMaxHP() + EXECUTE_MUL_LEVEL * pyromancer.getLevel();
//        if(pyromancer.getHP() > limitHP) {
//            int base_damage = EXECUTE_DAMAGE + EXECUTE_PER_LEVEL * pyromancer.getLevel();
//            int damageOnPyro = round(base_damage * EXECUTE_ON_PYRO) + base_damage;
//            pyromancer.setReceivedDamage(damageOnPyro);
//            damage = damageOnPyro;
////            System.out.println(damage + " kkkkkkkkkkkkkkkkkkkk");
//            pyromancer.decreaseHP(damage);
//        } else {
//            pyromancer.setHP(0);
//        }
//
//    }
//
//    public  void execute(Knight knight){
//        float limitHP = 0;
//        limitHP = EXECUTE_MUL_LIFE * knight.getMaxHP() + EXECUTE_MUL_LEVEL * knight.getLevel();
//        if(knight.getHP() > limitHP) {
//            damage = EXECUTE_DAMAGE + EXECUTE_PER_LEVEL * knight.getLevel();
//            int damageOnKnight = round(damage * EXECUTE_ON_KNIGHT) + damage;
//            knight.setReceivedDamage(damageOnKnight);
//
//            damage = damageOnKnight;
//            knight.decreaseHP(damage);
//        } else {
//            knight.setHP(0);
//        }
//
//
//    }
//
//    public void execute(Wizard wizard){
//        float limitHP = 0;
//        limitHP = EXECUTE_MUL_LIFE * wizard.getMaxHP() + EXECUTE_MUL_LEVEL * wizard.getLevel();
//        if(wizard.getHP() > limitHP) {
//            damage = EXECUTE_DAMAGE + EXECUTE_PER_LEVEL * wizard.getLevel();
//            int damageOnWizard = round(damage * EXECUTE_ON_WIZARD) + damage;
//            wizard.setReceivedDamage(damageOnWizard);
//
//            damage = damageOnWizard;
//            wizard.decreaseHP(damage);
//        } else {
//            wizard.setHP(0);
//        }
//
//
//    }
//
//    public void execute(Rogue rogue){
//        float limitHP = 0;
//        limitHP = EXECUTE_MUL_LIFE * rogue.getMaxHP() + EXECUTE_MUL_LEVEL * rogue.getLevel();
//        if(rogue.getHP() > limitHP) {
//            damage = EXECUTE_DAMAGE + EXECUTE_PER_LEVEL * rogue.getLevel();
//            int damageOnRogue = round(damage * EXECUTE_ON_ROGUE) + damage;
//            rogue.setReceivedDamage(damageOnRogue);
//
//            damage = damageOnRogue;
//            rogue.decreaseHP(damage);
//        } else {
//            rogue.setHP(0);
//        }
//
//
//    }
//
////    SLAM
//
//    public void slam(Hero hero){
//        damage = SLAM_DAMAGE + SLAM_PER_LEVEL * hero.getLevel();
//        hero.decreaseHP(damage);
//        System.out.println(damage);
//        hero.setReceivedDamage(damage);
//
//
//    }
//
//    public void slam(Pyromancer pyromancer){
//        damage = SLAM_DAMAGE + SLAM_PER_LEVEL * pyromancer.getLevel();
//        int damageOnPyro = round(damage * SLAM_ON_PYRO) + damage;
//        pyromancer.setReceivedDamage(damageOnPyro);
//
//        damage = damageOnPyro;
//        pyromancer.decreaseHP(damage);
//
//    }
//
//    public void slam(Knight knight){
//        damage = SLAM_DAMAGE + SLAM_PER_LEVEL * knight.getLevel();
//        int damageOnKnight = round(damage * SLAM_ON_KNIGHT) + damage;
//        knight.setReceivedDamage(damageOnKnight);
//
//        damage = damageOnKnight;
//        knight.decreaseHP(damage);
//
//    }
//
//    public void slam(Wizard wizard){
//        damage = SLAM_DAMAGE + SLAM_PER_LEVEL * wizard.getLevel();
//        int damageOnWizard = round(damage * SLAM_ON_WIZARD) + damage;
//        wizard.setReceivedDamage(damageOnWizard);
//
//        damage = damageOnWizard;
//        wizard.decreaseHP(damage);
//
//    }
//
//    public void slam(Rogue rogue){
//        damage = SLAM_DAMAGE + SLAM_PER_LEVEL * rogue.getLevel();
//        int damageOnRogue = round(damage * SLAM_ON_ROGUE) + damage;
//        rogue.setReceivedDamage(damageOnRogue);
//
//        damage = damageOnRogue;
//        rogue.decreaseHP(damage);
//
//    }
//
//    @Override
//    public void boostDamage(){
//        damage = round(damage * LAND_BOOST) + damage;
//    }
//
//    public int getDamage() {
//        return damage;
//    }
//
//    public void setDamage(int damage) {
//        this.damage = damage;
//    }
//
//    @Override
//    public void isAttackedBy(Pyromancer pyromancer) {
//        pyromancer.attack(this);
//
//    }
//
//    @Override
//    public void isAttackedBy(Wizard wizard) {
//        wizard.attack(this);
//
//    }
//
//    @Override
//    public void isAttackedBy(Rogue rogue) {
//        rogue.attack(this);
//
//    }
//
//    @Override
//    public void isAttackedBy(Knight knight) {
//        knight.attack(this);
//
//    }
//
//    @Override
//    public void isAttackedBy(Hero hero) {
//        hero.attack(this);
//    }
////
////    @Override
////    public void attack(Knight knight) {
////        execute(knight);
////        slam(knight);
////
////    }
//
//    @Override
//    public void attack(Hero hero) {
////        execute(hero);
////        System.out.println(hero.getReceivedDamage());
////        slam(hero);
//
//    }

//    @Override
//    public void attack(Rogue rogue) {
//        execute(rogue);
//        slam(rogue);
//
//    }
//
//    @Override
//    public void attack(Wizard wizard) {
//        execute(wizard);
//        slam(wizard);
//
//    }
//
//    @Override
//    public void attack(Pyromancer pyromancer) {
//        execute(pyromancer);
//        slam(pyromancer);
//
//    }
}
