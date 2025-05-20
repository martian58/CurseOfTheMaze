import java.util.Random;
import javax.swing.*;

public class Key implements GameObject {
    private final int id;

    public Key() {
        this.id = new Random().nextInt(10) + 1;
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
