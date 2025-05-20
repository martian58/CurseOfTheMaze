import javax.swing.*;
import java.awt.*;

import java.util.Random;

public class Door implements GameObject {
    private static int nextId = 1;
    private final int id;

    public Door() {
        this.id = nextId++;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean onPlayerInteract(int x, int y) {
        if (MazeData.keys.contains(id)) {
            MazeData.maze[x][y] = '.';
            JOptionPane.showMessageDialog(null, "🚪 Door ID " + id + " opened with matching key!");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "🚪 Door ID " + id + " - You need the matching key!");
            Toolkit.getDefaultToolkit().beep();
            return false;
        }
    }
}
