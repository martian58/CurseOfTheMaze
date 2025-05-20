// LabyrinthGameGUI.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class LabyrinthGameGUI extends JFrame {
    MazePanel panel;
    private Map<Character, GameObject> objectMap = new HashMap<>();

    public LabyrinthGameGUI() {
        setTitle("Labyrinth Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        panel = new MazePanel();
        add(panel, BorderLayout.CENTER);

        objectMap.put('K', new Key());
        objectMap.put('C', new Chest());
        objectMap.put('D', new Door());
        objectMap.put('M', new Monster1());
        objectMap.put('B', new Monster2());


        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int newX = MazeData.playerX;
                int newY = MazeData.playerY;

                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:    newX--; break;
                    case KeyEvent.VK_DOWN:  newX++; break;
                    case KeyEvent.VK_LEFT:  newY--; break;
                    case KeyEvent.VK_RIGHT: newY++; break;
                }

                if (newX < 0 || newY < 0 || newX >= MazeData.maze.length || newY >= MazeData.maze[0].length)
                    return;

                char targetCell = MazeData.maze[newX][newY];

                if (targetCell == '#') {
                    Toolkit.getDefaultToolkit().beep();
                    return;
                }

                if (targetCell == 'E') {
                    MazeData.maze[MazeData.playerX][MazeData.playerY] = '.';
                    MazeData.playerX = newX;
                    MazeData.playerY = newY;
                    MazeData.maze[newX][newY] = 'P';
                    panel.repaint();
                    JOptionPane.showMessageDialog(null, "🎉 You reached the exit!");
                    System.exit(0);
                }

                GameObject obj = objectMap.get(targetCell);
                boolean canMove = true;

                if (obj != null) {
                    canMove = obj.onPlayerInteract(newX, newY);
                }

                if (canMove) {
                    MazeData.movePlayer(newX, newY);
                    panel.repaint();
                } else {
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        });

        setPreferredSize(new Dimension(600, 600));
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LabyrinthGameGUI::new);
    }
}
