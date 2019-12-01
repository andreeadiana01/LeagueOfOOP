package engine;

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

    public Input(final int dimNCopy, final int dimMCopy,
                 final char[][] mapCopy, final int playersCopy,
                 final String[] typeCopy, final int[] lineCopy,
                 final int[] columnCopy, final int roundsCopy,
                 final char[][] movesCopy) {
        dimN = dimNCopy;
        dimM = dimMCopy;
        map = mapCopy;
        players = playersCopy;
        type = typeCopy;
        line = lineCopy;
        column = columnCopy;
        rounds = roundsCopy;
        moves = movesCopy;
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
}
