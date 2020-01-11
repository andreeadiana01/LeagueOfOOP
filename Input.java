package engine;

import java.util.ArrayList;

public class Input {
    private int dimN;
    private int dimM;
    private char[][] map;
    private int players;
    private String[] type;
    private int[] line;
    private int[] column;
    private int rounds;
    private char[][] moves;
    private int[] angels;
    private ArrayList<String> angelType;
    private ArrayList<Character> angelLine;
    private ArrayList<Character> angelColumn;

    public Input(final int dimNCopy, final int dimMCopy,
                 final char[][] mapCopy, final int playersCopy,
                 final String[] typeCopy, final int[] lineCopy,
                 final int[] columnCopy, final int roundsCopy,
                 final char[][] movesCopy, final int[] angelsCopy,
                 final ArrayList<String> angelTypeCopy, final ArrayList<Character> angelLineCopy,
                 final ArrayList<Character> angelColumnCopy) {
        dimN = dimNCopy;
        dimM = dimMCopy;
        map = mapCopy;
        players = playersCopy;
        type = typeCopy;
        line = lineCopy;
        column = columnCopy;
        rounds = roundsCopy;
        moves = movesCopy;
        angels = angelsCopy;
        angelType = angelTypeCopy;
        angelLine = angelLineCopy;
        angelColumn = angelColumnCopy;
    }

    /**
     *
     * @return
     */

    public int getDimN() {
        return dimN;
    }

    /**
     *
     * @return
     */

    public int getDimM() {
        return dimM;
    }

    /**
     *
     * @return
     */

    public char[][] getMap() {
        return map;
    }

    /**
     *
     * @return
     */

    public int getPlayers() {
        return players;
    }

    /**
     *
     * @return
     */

    public String[] getType() {
        return type;
    }

    /**
     *
     * @return
     */

    public int[] getLine() {
        return line;
    }

    /**
     *
     * @return
     */

    public int[] getColumn() {
        return column;
    }

    /**
     *
     * @return
     */

    public int getRounds() {
        return rounds;
    }

    /**
     *
     * @return
     */

    public char[][] getMoves() {
        return moves;
    }

    /**
     *
     * @return
     */

    public int[] getAngels() {
        return angels;
    }

    /**
     *
     * @return
     */

    public ArrayList<String> getAngelType() {
        return angelType;
    }

    /**
     *
     * @return
     */

    public ArrayList<Character> getAngelLine() {
        return angelLine;
    }

    /**
     *
     * @return
     */

    public ArrayList<Character> getAngelColumn() {
        return angelColumn;
    }

    /**
     *
     */

    public void print() {
        System.out.println(dimN + " " + dimM);
        for (int i = 0; i < dimN; i++) {
            for (int j = 0; j < dimM; j++) {
                System.out.println(map[i][j]);
            }
        }
        System.out.println(players);
        for (int i = 0; i < players; i++) {
            System.out.println(type[i] + " " + line[i] + " " + column[i]);
        }
        System.out.println(rounds);
        for (int i = 0; i < players; i++) {
            for (int j = 0; j < rounds; j++) {
                System.out.print(moves[i][j]);
            }
            System.out.println();
        }

        for (int i = 0; i < angelType.size(); i++) {
            System.out.println(angelType.get(i));
            System.out.println(angelLine.get(i));
            System.out.println(angelColumn.get(i));
        }
    }
}
