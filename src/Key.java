import java.util.Random;
import javax.swing.*;

public class Key implements GameObject {
    private static int nextId = 1;
    private final int id;

    public Key() {
        this.id = nextId++;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean onPlayerInteract(int x, int y) {
        MazeData.keys.add(id);
        MazeData.maze[x][y] = '.';
        JOptionPane.showMessageDialog(null, "🗝️ Picked up Key ID: " + id);
        return true;
    }
}
