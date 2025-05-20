import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CurseOfTheMaze extends JFrame {
    MazePanel panel;

    public CurseOfTheMaze() {
        setTitle("Curse Of The Maze");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        panel = new MazePanel();
        add(panel, BorderLayout.CENTER);

        // Initialize objectMap and place unique objects in each cell
        int rows = MazeData.maze.length;
        int cols = MazeData.maze[0].length;
        MazeData.objectMap = new GameObject[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                switch (MazeData.maze[i][j]) {
                    case 'K': MazeData.objectMap[i][j] = new Key(); break;
                    case 'C': MazeData.objectMap[i][j] = new Chest(); break;
                    case 'D': MazeData.objectMap[i][j] = new Door(); break;
                    case 'M': MazeData.objectMap[i][j] = new Monster1(); break;
                    case 'B': MazeData.objectMap[i][j] = new Monster2(); break;
                }
            }
        }

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

                GameObject obj = MazeData.objectMap[newX][newY];
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
        SwingUtilities.invokeLater(CurseOfTheMaze::new);
    }
}