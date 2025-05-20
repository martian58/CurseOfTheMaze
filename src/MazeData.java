import java.util.ArrayList;
import java.util.List;

public class MazeData {
    public static char[][] maze = {
        {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'},
        {'#','P','K','K','#','.','.','#','.','.','.','#','.','.','#','.','.','.','.','#'},
        {'#','#','#','K','#','.','#','#','.','#','.','#','.','#','#','.','#','#','.','#'},
        {'#','.','.','K','K','D','C','D','.','#','B','.','.','.','.','.','.','#','.','#'},
        {'#','.','#','#','#','#','.','#','#','#','#','#','#','.','#','#','.','#','.','#'},
        {'#','.','.','.','#','.','.','.','#','.','.','#','.','.','#','.','M','#','.','#'},
        {'#','#','#','.','#','#','#','.','#','#','C','#','#','#','#','.','#','#','.','#'},
        {'#','.','.','.','.','.','#','.','.','#','.','.','.','.','#','.','.','.','.','#'},
        {'#','.','#','#','#','.','#','#','.','#','#','#','C','#','#','#','#','#','#','#'},
        {'#','.','.','#','.','.','.','.','.','.','.','#','.','.','.','.','.','.','.','#'},
        {'#','#','.','#','#','D','#','#','#','#','.','#','#','#','#','#','#','#','.','#'},
        {'#','.','.','.','#','.','M','D','.','#','.','.','.','.','.','.','#','.','.','#'},
        {'#','.','#','#','#','#','#','#','.','#','#','#','#','#','.','#','#','#','#','#'},
        {'#','.','#','.','.','.','.','#','B','.','.','C','.','#','.','.','.','.','.','#'},
        {'#','#','#','.','#','#','.','#','#','#','#','#','B','#','#','#','#','.','#','#'},
        {'#','.','.','.','#','.','.','.','.','.','.','#','.','.','.','#','.','.','.','#'},
        {'#','#','.','#','#','.','#','#','#','#','.','#','#','#','.','#','#','#','.','#'},
        {'#','.','.','.','#','.','.','.','.','#','M','.','.','.','.','#','M','.','.','E'},
        {'#','.','#','#','#','#','#','#','.','#','#','#','#','#','#','#','#','#','.','#'},
        {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'}
    };

    public static GameObject[][] objectMap; // ← Changed to 2D array
    public static int playerX = 1, playerY = 1;
    public static int health = 100;
    public static List<Integer> keys = new ArrayList<>();
    public static int monstersKilled = 0;

    public static void movePlayer(int newX, int newY) {
        maze[playerX][playerY] = '.';
        playerX = newX;
        playerY = newY;
        maze[newX][newY] = 'P';
    }

    public static boolean isValidMove(int x, int y) {
        return x >= 0 && y >= 0 && x < maze.length && y < maze[0].length &&
                maze[x][y] != '#';
    }

    public static String getMonsterType(int x, int y) {
        if (maze[x][y] == 'M') return "M1";
        if (maze[x][y] == 'B') return "M2";
        return "";
    }

    // ✅ NEW: Create individual GameObject per cell
    public static void initializeObjectMap() {
        objectMap = new GameObject[maze.length][maze[0].length];
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                char cell = maze[i][j];
                switch (cell) {
                    case 'K': objectMap[i][j] = new Key(); break;
                    case 'C': objectMap[i][j] = new Chest(); break;
                    case 'D': objectMap[i][j] = new Door(); break;
                    case 'M': objectMap[i][j] = new Monster1(); break;
                    case 'B': objectMap[i][j] = new Monster2(); break;
                }
            }
        }
    }
}
