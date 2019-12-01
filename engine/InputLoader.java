package engine;
import fileio.FileSystem;
import tools.Map;

public class InputLoader {

    private final String inputPath;
    private final String outputPath;

    public InputLoader(final String inputPathLoad, final String outputPathLoad) {
        inputPath = inputPathLoad;
        outputPath = outputPathLoad;
    }

    /**
     *
     * @return
     */

    public Input load() {
        int dimN = 0;
        int dimM = 0;
        int players = 0;
        int rounds = 0;
        char[][] map = new char[dimN][dimM];
        char[][] moves = new char[rounds][players];


        int[] col = new int[0];
        int[] line = new int[0];
        String[] type = new String[0];
        try {
            FileSystem fileSystems = new fileio.FileSystem(inputPath, outputPath);

            dimN = fileSystems.nextInt();
            dimM = fileSystems.nextInt();

            Map instance = Map.getInstance(dimN, dimM);

            for (int i = 0; i < dimN; i++) {

                instance.setMap(fileSystems.nextWord().toCharArray(), dimN);
            }
            map =  instance.getMap();

            players = fileSystems.nextInt();
            line = new int[players];
            col = new int[players];
            type = new String[players];
            for (int i = 0; i < players; i++) {
                type[i] = fileSystems.nextWord();
                line[i] = fileSystems.nextInt();
                col[i] = fileSystems.nextInt();

            }

            rounds = fileSystems.nextInt();


            moves = new char[rounds][players];

            for (int i = 0; i < rounds; i++) {
                moves[i] = fileSystems.nextWord().toCharArray();
            }

            fileSystems.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Input(dimN, dimM, map, players, type, line, col, rounds, moves);

    }




}
