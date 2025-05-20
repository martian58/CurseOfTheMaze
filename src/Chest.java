
import javax.swing.*;

import java.util.Random;

public class Chest implements GameObject {
    private final int id;

    public Chest() {
        this.id = new Random().nextInt(10) + 1;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean onPlayerInteract(int x, int y) {
        if (MazeData.keys.contains(id)) {
            MazeData.keys.remove((Integer) id);
            int keysFound = new Random().nextInt(3) + 1;
            for (int i = 0; i < keysFound; i++)
                MazeData.keys.add(new Random().nextInt(10) + 1);

            int healthGain = 10 + new Random().nextInt(21);
            MazeData.health += healthGain;
            MazeData.maze[x][y] = '.';
            JOptionPane.showMessageDialog(null, "🎁 Chest ID " + id + " opened! Found " + keysFound + " keys and +" + healthGain + " HP.");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "🔒 Chest ID " + id + " - You don’t have the matching key!");
            return false;
        }
    }
}
