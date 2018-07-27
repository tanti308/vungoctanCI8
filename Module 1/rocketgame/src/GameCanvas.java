import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameCanvas extends JPanel {

    private List<Star> stars; // null -> pointer tham chieu null => neu tiep tuc su dung stars => bug null pointer exception
    private BufferedImage backBuffered;
    private BufferedImage playerImage;

    public int positionXPlayer = 600;
    public int positionYPlayer = 200;

    private Graphics graphics;

    private Random random = new Random();

    private int timeIntervalStar = 0;


    public GameCanvas() {

        this.setSize(1024, 600);

        this.setupBackBuffered();

        this.setupCharacter();

        this.setVisible(true);
    }

    private void setupBackBuffered() {
        this.backBuffered = new BufferedImage(1024, 600, BufferedImage.TYPE_INT_ARGB);
        this.graphics = this.backBuffered.getGraphics();
    }

    private void setupCharacter() {
        this.setupStar();
        this.playerImage = this.loadImage("resources/images/circle.png");
    }

    private void setupStar() {
        this.stars = new ArrayList<>();
    } // khoi tao pointer stars

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {
        this.renderBackground();

        this.stars.forEach(star -> star.render(graphics));

        this.graphics.drawImage(this.playerImage, this.positionXPlayer, this.positionYPlayer, 20, 20, null);

        this.repaint();
    }

    public void runAll() {
        this.createStar();
        this.stars.forEach(star -> star.run());
        this.playerMove();
    }

    private void createStar() {
        if (this.timeIntervalStar == 30) {
            Star star = new Star();
            star.x = 1024;
            star.y = this.random.nextInt(600);
            star.image = this.loadImage("resources/images/star.png");
            star.width = 5;
            star.height = 5;
            star.velocityX = this.random.nextInt(3) + 1;
            this.stars.add(star);
            this.timeIntervalStar = 0;
        } else {
            this.timeIntervalStar += 1;
        }

    }


    private void playerMove() {
        if (this.positionXPlayer > 1024) {
            this.positionXPlayer = 0;
            this.positionYPlayer = this.random.nextInt(600);
        }
        if (this.positionXPlayer < 0) {
            this.positionXPlayer = 1024;
            this.positionYPlayer = this.random.nextInt(600);
        }
        if (this.positionYPlayer > 600) {
            this.positionXPlayer = this.random.nextInt(1024);
            this.positionYPlayer = 0;
        }
        if (this.positionYPlayer < 0) {
            this.positionXPlayer = this.random.nextInt(1024);
            this.positionYPlayer = 600;
        }
    }

    private void renderBackground() {
        this.graphics.setColor(Color.BLACK);
        this.graphics.fillRect(0, 0, 1024, 600);
    }

    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            return null;
        }
    }
}
