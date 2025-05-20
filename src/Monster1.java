import javax.swing.*;

public class Monster1 implements GameObject {
    @Override
    public boolean onPlayerInteract(int x, int y) {
        if (MazeData.health > 30) {
            MazeData.health -= 30;
            MazeData.monstersKilled++;
            MazeData.maze[x][y] = '.';
            JOptionPane.showMessageDialog(null, "💀 You killed Monster 1! -30 HP");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "☠️ Monster 1 killed you!");
            System.exit(0);
            return false; // unreachable, but keeps method signature valid
        }
    }
}