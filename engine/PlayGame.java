package engine;

import angels.Angel;
import heroes.Hero;
import tools.AngelFactory;
import tools.HeroFactory;
import fileio.FileSystem;

import java.io.IOException;
import java.util.ArrayList;


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
    private int[] angelsNr;
    private ArrayList<String> angelType;
    private ArrayList<Character> angelLine;
    private ArrayList<Character> angelCol;
    private ArrayList<Angel> angels;

    public PlayGame() {
        rounds = 0;
        heroes = new ArrayList<>();
        roundNr = 0;
        angels = new ArrayList<>();
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
        angelsNr = input.getAngels();
        angelType = input.getAngelType();
        angelLine = input.getAngelLine();
        angelCol = input.getAngelColumn();
        HeroFactory heroFactory = HeroFactory.getInstance();
        AngelFactory angelFactory = AngelFactory.getInstance();
        for (int i = 0; i < players; i++) {
            heroes.add(heroFactory.getHero(type[i], line[i], column[i]));
        }
        for (int i = 0; i < heroes.size(); i++) {
            heroes.get(i).setId(i);
        }

        for (int i = 0; i < angelType.size(); i++) {
            if (angelType.get(i) != null) {
                angels.add(angelFactory.getAngel(angelType.get(i),
                        angelLine.get(i), angelCol.get(i)));
            }
        }
        for (int i = 0; i < angelsNr[0]; i++) {
            angels.get(i).setRoundNr(1);
        }
        for (int i = angelsNr[0]; i < angelType.size(); i++) {
            angels.get(i).setRoundNr(2);
        }
        input.print();
    }

    /**
     *  The fight starts. The land modifiers are set and then the winner gets its xp points.The angels
     *  then get spawned and impact the hero.
     */

    public void angelFightOut(final String inputPath, final String outputPath) {
        try {
            FileSystem fileSystem = new FileSystem(inputPath, outputPath);
            int sw = 0;
            while (roundNr < rounds) {
                fileSystem.writeWord("~~ Round " + (roundNr + 1) + " ~~");
                fileSystem.writeNewLine();
                for (Hero hero : heroes) {
                    hero.setRoundNR(roundNr);
                    for (Hero enemy : heroes) {
                        if (!hero.equals(enemy) || !enemy.equals(hero)
                                && hero.getHp() >= 0 && enemy.getHp() >= 0) {
                            if (hero.getLine() == enemy.getLine()
                                    && hero.getCol() == enemy.getCol()) {
                                if (hero.getLandModif()
                                        == map[hero.getLine()][hero.getCol()]) {
                                    hero.setTerrainBoost();
                                }
                                enemy.isAttackedBy(hero);
                                if ((enemy.getHp() <= 0 || hero.getHp() <= 0)
                                        && (hero.getRoundNR() != roundNr
                                        || enemy.getRoundNR() != roundNr)) {
                                    sw = 1;
                                    fileSystem.writeWord("Player "
                                            + enemy.getFullType() + " "
                                            + (int) enemy.getId() + " was killed by "
                                            + hero.getFullType() + " " + (int) hero.getId());
                                    fileSystem.writeNewLine();
                                    fileSystem.writeWord("Player "
                                            + hero.getFullType() + " "
                                            + (int) hero.getId() + " was killed by "
                                            + enemy.getFullType() + " " + (int) enemy.getId());
                                    fileSystem.writeNewLine();
                                }
                            }
                        }
                    }

                }
                for (int i = 0; i < angelType.size(); i++) {
                    if (angels.get(i).getRoundNr() == roundNr + 1) {
                        fileSystem.writeWord("Angel "
                                + angelType.get(i) + " was spawned at "
                                + angelLine.get(i) + " " + angelCol.get(i));
                        fileSystem.writeNewLine();
                        for (Hero hero : heroes) {
                            if (angels.get(i).getLine()
                                    == (char) (hero.getLine() + '0')
                                    && angels.get(i).getCol()
                                    == (char) (hero.getCol() + '0') && sw == 0) {
                                hero.accept(angels.get(i));
                                 if (angels.get(i).isGood()) {
                                     fileSystem.writeWord(angelType.get(i)
                                             + " helped " + hero.getFullType()
                                             + " " + (int) hero.getId());
                                } else {
                                     fileSystem.writeWord(angelType.get(i)
                                             + " hit " + hero.getFullType() + " "
                                             + (int) hero.getId());
                                 }
                                fileSystem.writeNewLine();
                            }
                        }
                    }
                }
                roundNr++;
                fileSystem.writeNewLine();
            }
//            System.out.println();
            fileSystem.writeWord("~~ Results ~~");
            fileSystem.writeNewLine();
            for (Hero hero : heroes) {
                if (hero.getHp() <= 0) {
                    fileSystem.writeWord(hero.getType() + " dead");
                    fileSystem.writeNewLine();
                } else {
                    fileSystem.writeWord(hero.getType() + " "
                            + hero.getLevel() + " " + hero.getXp() + " "
                            + hero.getHp() + " " + hero.getLine() + " " + hero.getCol());
                    fileSystem.writeNewLine();
                }
            }
            fileSystem.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

