import javax.swing.*;
import java.awt.*;

import java.util.Random;

public class Door implements GameObject {
    private final int id;

    public Door() {
        this.id = new Random().nextInt(10) + 1;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean onPlayerInteract(int x, int y) {
        if (MazeData.keys.contains(id)) {
            MazeData.keys.remove((Integer) id);
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
