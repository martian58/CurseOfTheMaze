import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MazePanel extends JPanel {
    private BufferedImage playerImage;
    private BufferedImage keyImage;
    private BufferedImage chestImage;
    private BufferedImage monster1Image;
    private BufferedImage monster2Image;
    private BufferedImage doorImage;

    public MazePanel() {
        try {
            playerImage = ImageIO.read(getClass().getResource("/assets/player.jpg"));
        } catch (IOException | IllegalArgumentException e) {
            playerImage = null;
        }
        try {
            keyImage = ImageIO.read(getClass().getResource("/assets/key.png"));
        } catch (IOException | IllegalArgumentException e) {
            keyImage = null;
        }
        try {
            chestImage = ImageIO.read(getClass().getResource("/assets/chest.jpg"));
        } catch (IOException | IllegalArgumentException e) {
            chestImage = null;
        }
        try {
            monster1Image = ImageIO.read(getClass().getResource("/assets/monster1.png"));
        } catch (IOException | IllegalArgumentException e) {
            monster1Image = null;
        }
        try {
            monster2Image = ImageIO.read(getClass().getResource("/assets/monster2.png"));
        } catch (IOException | IllegalArgumentException e) {
            monster2Image = null;
        }
        try {
            doorImage = ImageIO.read(getClass().getResource("/assets/door.jpg"));
        } catch (IOException | IllegalArgumentException e) {
            doorImage = null;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        int rows = MazeData.maze.length;
        int cols = MazeData.maze[0].length;

        int cellWidth = panelWidth / cols;
        int cellHeight = panelHeight / rows;
        int cellSize = Math.min(cellWidth, cellHeight);

        // Info panel
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        int lineHeight = 25;
        g.drawString("Health: " + MazeData.health + " HP", 10, 20);
        g.drawString("Keys: " + MazeData.keys, 10, 20 + lineHeight);
        g.drawString("Monsters killed: " + MazeData.monstersKilled, 10, 20 + 2 * lineHeight);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int x = j * cellSize;
                int y = i * cellSize + 90;

                char cell = MazeData.maze[i][j];
                g.setColor(Color.WHITE);
                g.fillRect(x, y, cellSize, cellSize); // base background

                switch (cell) {
                    case '#':
                        g.setColor(Color.DARK_GRAY);
                        g.fillRect(x, y, cellSize, cellSize);
                        break;
                    case '.':
                        break;
                    case 'E':
                        g.setColor(Color.GREEN);
                        g.fillRect(x, y, cellSize, cellSize);
                        break;
                    case 'P':
                        if (playerImage != null) {
                            g.drawImage(playerImage, x, y, cellSize, cellSize, null);
                        } else {
                            g.setColor(Color.BLUE);
                            g.fillRect(x, y, cellSize, cellSize);
                        }
                        break;
                    case 'K':
                        if (keyImage != null) {
                            g.drawImage(keyImage, x, y, cellSize, cellSize, null);
                        } else {
                            g.setColor(Color.YELLOW);
                            g.fillOval(x + cellSize / 4, y + cellSize / 4, cellSize / 2, cellSize / 2);
                        }
                        break;
                    case 'C':
                        if (chestImage != null) {
                            g.drawImage(chestImage, x, y, cellSize, cellSize, null);
                        } else {
                            g.setColor(new Color(139, 69, 19));
                            g.fillRect(x + cellSize / 4, y + cellSize / 4, cellSize / 2, cellSize / 2);
                        }
                        break;
                    case 'M':
                        if (monster1Image != null) {
                            g.drawImage(monster1Image, x, y, cellSize, cellSize, null);
                        } else {
                            g.setColor(Color.MAGENTA);
                            g.fillOval(x + cellSize / 4, y + cellSize / 4, cellSize / 2, cellSize / 2);
                        }
                        break;
                    case 'B':
                        if (monster2Image != null) {
                            g.drawImage(monster2Image, x, y, cellSize, cellSize, null);
                        } else {
                            g.setColor(Color.RED);
                            g.fillOval(x + cellSize / 4, y + cellSize / 4, cellSize / 2, cellSize / 2);
                        }
                        break;
                    case 'D':
                        if (doorImage != null) {
                            g.drawImage(doorImage, x, y, cellSize, cellSize, null);
                        } else {
                            g.setColor(Color.ORANGE.darker());
                            g.fillRect(x + cellSize / 4, y + cellSize / 4, cellSize / 2, cellSize / 2);
                        }
                        break;
                }

                g.setColor(Color.BLACK);
                g.drawRect(x, y, cellSize, cellSize);
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 800);
    }
}
