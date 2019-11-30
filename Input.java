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

    public Input(final int dimNCopy, final int dimMCopy, final char[][] mapCopy, final int playersCopy,
                 final String[] typeCopy, final int[] lineCopy,
                 final int[] columnCopy, final int roundsCopy, final char[][] movesCopy) {
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

    public int getDimN() {
        return dimN;
    }

    public int getDimM() {
        return dimM;
    }

    public char[][] getMap() {
        return map;
    }

    public int getPlayers() {
        return players;
    }

    public String[] getType() {
        return type;
    }

    public int[] getLine() {
        return line;
    }

    public int[] getColumn() {
        return column;
    }

    public int getRounds() {
        return rounds;
    }

    public char[][] getMoves() {
        return moves;
    }

    public void setDimN(int dimN) {
        this.dimN = dimN;
    }

    public void setDimM(int dimM) {
        this.dimM = dimM;
    }

    public void setMap(char[][] map) {
        this.map = map;
    }

    public void setPlayers(int players) {
        this.players = players;
    }

    public void setType(String[] type) {
        this.type = type;
    }

    public void setLine(int[] line) {
        this.line = line;
    }

    public void setColumn(int[] column) {
        this.column = column;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public void setMoves(char[][] moves) {
        this.moves = moves;
    }

    public final boolean isValid() {
        boolean dimensionsInstantiated = (dimN != 0) && (dimM != 0);
        return  dimensionsInstantiated;
    }
}
