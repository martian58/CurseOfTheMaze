import javax.swing.*;

public class Monster2 implements GameObject {
    @Override
    public boolean onPlayerInteract(int x, int y) {
        if (MazeData.health > 20) {
            MazeData.health -= 20;
            MazeData.monstersKilled++;
            MazeData.maze[x][y] = '.';
            JOptionPane.showMessageDialog(null, "💀 You killed Monster 2! -20 HP");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "☠️ Monster 2 killed you!");
            System.exit(0);
            return false;
        }
    }
}