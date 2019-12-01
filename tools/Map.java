package tools;

public final class Map {
    private char[][] map;

//    Class Map is implemented using a Singleton Pattern.

    private Map(final int lines, final int cols) {
        map = new char[lines][cols];
    }

    public static Map getInstance(final int lines, final int cols) {
        return new Map(lines, cols);
    }

//    this method is used for saving the map given in the input file

    public char[][] setMap(final char[] vect, final int lines) {
        for (int i = 0; i < lines; i++) {
            map[i] = vect;
        }
        return map;
    }

    public char[][] getMap() {
        return map;
    }
}
