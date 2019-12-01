package engine;

import heroes.Hero;
import tools.HeroFactory;
import fileio.FileSystem;

import java.io.IOException;
import java.util.ArrayList;

import static constants.Constants.BACKSTAB_BOOST;
import static constants.Constants.FOR_WINNER_XP;
import static constants.Constants.MUL_DIFF_LEVEL;
import static constants.Constants.BACKSTAB_COUNT;



public class PlayGame {
    private int dimN;
    private int dimM;
    private char[][] map;
    private int players;
    private String[] type;
    private int[] line;
    private int[] column;
    private int rounds;
    private char[][] moves;
    private ArrayList<Hero> heroes;
    private int roundNr;


    public PlayGame() {
        rounds = 0;
        heroes = new ArrayList<>();
        roundNr = 0;
    }

    /**
     * The method saves the input, creates the players and sets their id.
     * (The id is used for the override of method equals)
     * @param input
     */

    public final void preparation(final Input input) {
        dimN = input.getDimN();
        dimM = input.getDimM();
        map = input.getMap();
        players = input.getPlayers();
        type = input.getType();
        line = input.getLine();
        column = input.getColumn();
        rounds = input.getRounds();
        moves = input.getMoves();
        HeroFactory heroFactory = HeroFactory.getInstance();
        for (int i = 0; i < players; i++) {
            heroes.add(heroFactory.getHero(type[i], line[i], column[i]));
        }
        for (int i = 0; i < heroes.size(); i++) {
            heroes.get(i).setId(i);
        }
    }

    /**
     *  The fight starts. The land modifiers are set and then the winner gets its xp points.
     */

        public void fight() {
                while (roundNr <= rounds) {
                    for (Hero hero : heroes) {
                        hero.setRoundNR(roundNr);
                        for (Hero enemy : heroes) {
                            if (!hero.equals(enemy)) {
                                if (hero.getLine() == enemy.getLine()
                                        && hero.getCol() == enemy.getCol()) {
                                    if (hero.getLandModif() == map[hero.getLine()][hero.getCol()]) {
                                        hero.setTerrainBoost();
                                    }
                                    if (hero.getRoundNR() % BACKSTAB_COUNT == 0
                                            && hero.getLandModif() == map[hero.getLine()]
                                            [hero.getCol()]) {
                                        hero.setCritical(BACKSTAB_BOOST);
                                    }
                                    enemy.isAttackedBy(hero);
                                    if (enemy.getHp() <= 0 || hero.getHp() <= 0) {
                                        roundNr++;
                                    }
                                }
                                roundNr++;
                            }
                        }

                    }
                }

        for (Hero hero : heroes) {
            for (Hero enemy : heroes) {
                if (enemy.getHp() <= 0) {
                    int levelDif = hero.getLevel() - enemy.getLevel();
                    int maxim = Math.max(0, FOR_WINNER_XP - levelDif * MUL_DIFF_LEVEL);
                    hero.setXp(hero.getXp() + maxim);
                    hero.computeLevelUpXp(hero.getXp());
                }
            }
        }

        }

    /**
     * The method writes the final scores in an output file.
     * @param inputPath
     * @param outputPath
     */

    public void computeOutput(final String inputPath, final String outputPath) {
        try {
            FileSystem fileSystem = new FileSystem(inputPath, outputPath);
            for (Hero hero : heroes) {
                if (hero.getHp() <= 0) {
                    fileSystem.writeCharacter(hero.getType());
                    fileSystem.writeWord(" dead");
                    fileSystem.writeNewLine();
                } else {
                    fileSystem.writeCharacter(hero.getType());
                    fileSystem.writeWord(" ");
                    fileSystem.writeInt(hero.getLevel());
                    fileSystem.writeWord(" ");
                    fileSystem.writeInt(hero.getXp());
                    fileSystem.writeWord(" ");
                    fileSystem.writeInt(hero.getHp());
                    fileSystem.writeWord(" ");
                    fileSystem.writeInt(hero.getLine());
                    fileSystem.writeWord(" ");
                    fileSystem.writeInt(hero.getCol());
                    fileSystem.writeNewLine();
                }
            }
            fileSystem.writeNewLine();
            fileSystem.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }






}

