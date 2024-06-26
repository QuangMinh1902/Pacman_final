package pacman.maze;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import pacman.Tile;
import pacman.TileCoordinate;
import pacman.tiles.Door;
import pacman.tiles.Dot;
import pacman.tiles.EmptyTile;
import pacman.tiles.PurpleDot;
import pacman.tiles.GreenDot;
import pacman.tiles.OrangeDot;
import pacman.tiles.Wall;

public class MazeBuilder {
    private static final String WALLED_MAZE_MAP_FILENAME = "walled_maze.map";
    private static final String MAZE_MAP_FILENAME = "maze.map";
    @SuppressWarnings("serial")
    private static final Map<Character, Class<? extends Tile>> mazeParser = new HashMap<Character, Class<? extends Tile>>() {
        {
            put('1', Wall.class);
            put('2', Wall.class);
            put('3', Wall.class);
            put('4', Wall.class);
            put('5', Wall.class);
            put('6', Wall.class);
            put('7', Door.class);
            put('+', Wall.class);
            put('-', Door.class);
            put('.', Dot.class);
            put('*', PurpleDot.class);
            put('x', GreenDot.class);
            put('o', OrangeDot.class);
            put(' ', EmptyTile.class);
        }
    };

    public static Maze buildDefaultMaze() throws Exception {
        InputStream fileInputStream = MazeBuilder.class.getResourceAsStream(MAZE_MAP_FILENAME);
        Scanner scanner = new Scanner(fileInputStream);

        return buildMaze(scanner);
    }

    public static Maze buildWalledMaze() throws Exception {
        InputStream fileInputStream = MazeBuilder.class.getResourceAsStream(WALLED_MAZE_MAP_FILENAME);
        Scanner scanner = new Scanner(fileInputStream);

        return buildMaze(scanner);
    }

    public static Maze buildMaze(String mazeDescription) throws Exception {
        Scanner scanner = new Scanner(mazeDescription);
        return buildMaze(scanner);
    }

    private static Maze buildMaze(Scanner scanner) throws Exception {
        MazeBuilder builder = new MazeBuilder();
        while (scanner.hasNextLine()) {
            builder.process(scanner.nextLine());
        }
        return builder.build();
    }

    private int width = 0;
    private int height = 0;
    private Map<TileCoordinate, Tile> tiles = new HashMap<TileCoordinate, Tile>();

    Maze build() {
        return new Maze(width, height, tiles);
    }

    void process(String row) throws Exception {
        for (int x = 0; x < row.length(); x++) {
            TileCoordinate coordinate = new TileCoordinate(x, height);
            tiles.put(coordinate, createTile(row.charAt(x), coordinate));
        }
        width = row.length();
        height += 1;
    }

    private Tile createTile(char tileCharacter, TileCoordinate coordinate) throws Exception {
        return mazeParser.get(tileCharacter).getConstructor(TileCoordinate.class, String.class)
                .newInstance(coordinate, String.valueOf(tileCharacter));
    }
}
