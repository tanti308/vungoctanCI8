import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameCanvas extends JPanel {

    private BufferedImage starImage;
    private BufferedImage enemyImage;
    private BufferedImage playerImage;
    private BufferedImage backBuffered;
    private Graphics graphics;

    public int positionXStar = 1024;
    public int positionYStar = 200;
    public int positionXPlayer = 600;
    public int positionYPlayer = 200;
    public int positionXEnemy = 100;
    public int postionYEnemy = 200;

    public GameCanvas() {
        // Cách đặt tên biến
        // snake case: user_name
        // camel case: userName (Java hỗ trợ)

        this.setSize(1024,600);
        this.backBuffered = new BufferedImage(1024,600,BufferedImage.TYPE_INT_ARGB);
        this.graphics = this.backBuffered.getGraphics(); // lấy cọ vẽ backBuffered
//        B1. Load ảnh

        // try catch starImage
        try {
            this.starImage = ImageIO.read(new File("resources/images/star.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // try catch playerImage
        try {
            this.playerImage = ImageIO.read(new File("resources/images/circle.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // try catch enemyImage
        try {
            this.enemyImage = ImageIO.read(new File("resources/images/circle.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
//        B2. Vẽ

        this.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
//        Nơi mình vẽ components
        g.drawImage(this.backBuffered,0,0,null);
        // Chỗ này chỉ vẽ duy nhất backBuffered
//        g.setColor(Color.BLACK);
//        g.fillRect(0,0,1024,600);
//        g.drawImage(this.starImage,positionXStar,positionYStar,10,10,null);
    }

    public void renderAll() {
        this.graphics.setColor(Color.BLACK);
        this.graphics.fillRect(0,0,1024,600);
        this.graphics.drawImage(this.starImage,positionXStar,positionYStar,10,10,null);
        this.graphics.drawImage(this.playerImage,positionXPlayer,positionYPlayer,20,20,null);
        this.graphics.drawImage(this.enemyImage,positionXEnemy,postionYEnemy,15,15,null);
        this.repaint();
    }

}
