package tools;

public final class Map {
    private char[][] map;
//    private int lines;
//    private int cols;

    private Map(int lines, int cols){
        map = new char[lines][cols];
    }

//    public void setDim(int lines, int cols){
//        this.lines = lines;
//        this.cols = cols;
//
//    }

    public static Map getInstance(int lines, int cols){
        return new Map(lines,cols);
    }

    public char[][] setMap(char[] vect, int lines){
        for(int i = 0; i < lines; i++){
            map[i] = vect;
        }
        return map;
    }

//    public char getElem(int lines, int cols){
//        for(int i = 0; i < lines; i++){
//            for(int j = 0; j < cols; j++){
//                System.out.print( map[i][j]);
//            }
//            System.out.println();
//        }
//        return '0';
//    }

    public char[][] getMap(){
        return map;
    }
}
